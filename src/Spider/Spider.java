package Spider;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import Crawl.CatalogAndProductType;
import Crawl.CatalogAndProductTypeImpl;
import Crawl.ProductDetailInforImpl;
import Crawl.ProductDetailInforPage;
import Model.CategoryProduct;
import Model.DetailDescriptionProduct;
import Model.ObjectData;
import Model.ProductDetail;
import Model.ProductType;
import Model.TikiData;
import Utils.Constant;

public class Spider {
    private ProductDetailInforPage productDetailOnPage;
    private CatalogAndProductType catalogAndProductType;
    protected LogFile logFile;

    private static Integer countProduct = 0;

    public Spider() {
        this.productDetailOnPage = new ProductDetailInforImpl();
        this.catalogAndProductType = new CatalogAndProductTypeImpl();
        logFile = LogFile.getInstance();
    }

    /**
     * 
     * @param url
     * @return
     * @throws InterruptedException
     */
    public static Document connect(String url) {
        // refence:
        // https://stackoverflow.com/questions/6581655/jsoup-useragent-how-to-set-it-right
        Integer Min_time_connect = Constant.MIN_TIME_CONNECTION;
        Document HTMLDOM = null;
        Long currentTime = new Date().getTime(), nextTime = 0L;
        boolean isFirstTime = true;
        // Stay connected status
        while (true) {
            nextTime = new Date().getTime();
            if (nextTime - currentTime > Min_time_connect || isFirstTime) {
                isFirstTime = false;
                try {
                    // just break connect internet after max time connection
                    if (Min_time_connect > Constant.MAX_TIME_CONNECTION) {
                        break;
                    }
                    currentTime = (new Date().getTime());
                    System.out.println("--/--/--/--/-- Created request " + url);
                    HTMLDOM = Jsoup.connect(url).timeout(Min_time_connect).ignoreContentType(true).userAgent(
                            "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) coc_coc_browser/83.0.144 Chrome/77.0.3865.144 Safari/537.36")
                            .referrer(Constant.BASEURL).get();
                    // response success
                    if (HTMLDOM != null) {
                        break;
                    }
                } catch (IOException e) {
                    System.out.println("Error IOException " + e.getMessage());
                    Min_time_connect += 30000;
                    // e.printStackTrace();
                } catch (Exception e1) {
                    System.out.println("Error Exception " + e1.getMessage());
                    Min_time_connect += 30000;
                    // e1.printStackTrace();
                }
            }
        }

        return HTMLDOM;
    }
    /**
     * 
     * @return
     */
    public Integer countTotalProduct() {
        Document HTMLDOM;
        Integer totalProduct = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(Constant.MULTI_THREAD);
        try {
            HTMLDOM = Spider.connect(Constant.BASEURL);
            List<ObjectData> getListType = catalogAndProductType.getTikiData(HTMLDOM);
            Future<Integer> future = executorService.submit(new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Integer countProduct = 0;
                    for (ObjectData objectData : getListType) {
                        Document HTMLDOM1 = Spider.connect(objectData.getKey().toString());
                        List<ObjectData> listUrlProductType = catalogAndProductType.getProductType(HTMLDOM1);

                        for (ObjectData objectDataChild : listUrlProductType) {
                            ProductType productType = (ProductType) objectDataChild.getValue();
                            countProduct += productType.getTotal();
                        }
                    }
                    return countProduct;
                }
            });
            
            totalProduct += future.get();
            executorService.shutdown();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return totalProduct;
    }

    /**
     * 
     * @return
     */
    protected List<TikiData> spiderTikiPage() {
        List<TikiData> tikiDataList = new ArrayList<TikiData>();
        // create 16 thread for get each product detail
        ExecutorService executorService = Executors.newFixedThreadPool(Constant.MULTI_THREAD);
        Document HTMLDOM, HTMLDOM1, HTMLDOM2;
        String page = "&page=";
        Integer totalUrlOnApage = 48;
        String url = null;

        try {
            HTMLDOM = Spider.connect(Constant.BASEURL);
            List<ObjectData> getListType = catalogAndProductType.getTikiData(HTMLDOM);

            int count = 0;
            for (ObjectData objectData : getListType) {
                // if (count == 1)
                // break;
                TikiData tikiData = (TikiData) objectData.getValue();
                HTMLDOM1 = Spider.connect(objectData.getKey().toString());
                logFile.writeInListUrlCrawlFile(
                        "----" + Spider.getCountProduct() + ", Url: " + objectData.getKey());
                CategoryProduct categoryProduct = catalogAndProductType.getCategoryProduct(HTMLDOM1);
                List<ObjectData> listUrlProductType = catalogAndProductType.getProductType(HTMLDOM1);

                int count1 = 0;
                List<ProductType> productTypeList = new ArrayList<>();
                for (ObjectData objectDataChild : listUrlProductType) {
                    // if (count1 == 2)
                    // break;
                    ProductType productType = (ProductType) objectDataChild.getValue();
                    ArrayList<ProductDetail> productList = new ArrayList<>();
                    Integer totalPage = (int) Math.ceil((float) productType.getTotal() / totalUrlOnApage);

                    for (int index = 1; index <= totalPage; index++) {
                        url = objectDataChild.getKey() + page + index;
                        HTMLDOM2 = Spider.connect(url);
                        // return 48 url for each page
                        List<String> listUrlEachPage = catalogAndProductType
                                .getListUrlProductInAPage(HTMLDOM2);
                        // reference: https://viblo.asia/p/thread-pools-trong-java-ZK1ov1DxG5b9
                        Future<List<ProductDetail>> future = executorService
                                .submit(new Callable<List<ProductDetail>>() {
                                    @Override
                                    public List<ProductDetail> call() throws Exception {
                                        ArrayList<ProductDetail> productList = new ArrayList<>();
                                        for (String urlDetail : listUrlEachPage) {
                                            Document HTMLDOM3 = Spider.connect(urlDetail);
                                            Spider spider = new Spider();
                                            Spider.setCountProduct(Spider.getCountProduct() + 1);
                                            ProductDetail productDetail;

                                            try {
                                                productDetail = spider.getProductDetail(HTMLDOM3);
                                                logFile.writeInStorageProductFile(productDetail);
                                                productList.add(productDetail);
                                                logFile.writeInListUrlCrawlFile("--------"
                                                        + Spider.getCountProduct() + ", Url: " + urlDetail);
                                                System.out.println(Spider.getCountProduct() + ", Infor: "
                                                        + productDetail.getProductName() + "---"
                                                        + productDetail.getPrice());
                                                // break;
                                            } catch (NullPointerException e) {
                                                System.out.println(e.getLocalizedMessage());
                                                Spider.setCountProduct(Spider.getCountProduct() - 1);
                                                System.out.println("Error url: " + urlDetail);
                                                logFile.writeInLogErrorFile(
                                                        "##################### Error NullPointerException #########################");
                                                logFile.writeInLogErrorFile("1, Url: " + urlDetail);
                                                logFile.writeInLogErrorFile("2, Cause: " + e.getMessage());
                                                logFile.writeInLogErrorFile("3, At time: " + new Date());
                                            } catch (Exception ex) {
                                                System.out.println(ex.getMessage());
                                                Spider.setCountProduct(Spider.getCountProduct() - 1);
                                                System.out.println("Error url: " + urlDetail);
                                                logFile.writeInLogErrorFile(
                                                        "##################### Error Exception #########################");
                                                logFile.writeInLogErrorFile("1, Url: " + urlDetail);
                                                logFile.writeInLogErrorFile("2, Cause: " + ex.getMessage());
                                                logFile.writeInLogErrorFile("3, At time: " + new Date());
                                            }

                                        }

                                        return productList;
                                    }
                                });
                        productList.addAll(future.get());
                    }
                    productType.setProductList(productList);
                    productTypeList.add(productType);

                    // count1++;
                }

                categoryProduct.setProductTypeList(productTypeList);
                tikiData.setCategoryProduct(categoryProduct);
                tikiDataList.add(tikiData);

                // count++;
            }
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("Error url: " + url);
            logFile.writeInLogErrorFile(
                    "##################### Error NullPointerException #########################");
            logFile.writeInLogErrorFile("1, Url: " + url);
            logFile.writeInLogErrorFile("2, Cause: " + e.getLocalizedMessage());
            logFile.writeInLogErrorFile("3, At time: " + new Date());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("Error url: " + url);
            logFile.writeInLogErrorFile("##################### Error Exception #########################");
            logFile.writeInLogErrorFile("1, Url: " + url);
            logFile.writeInLogErrorFile("2, Cause: " + ex.getLocalizedMessage());
            logFile.writeInLogErrorFile("3, At time: " + new Date());
        }
        executorService.shutdown();

        return tikiDataList;
    }
	
/*	protected List<TikiData> spiderTikiPage() {
		List<TikiData> tikiDataList = new ArrayList<TikiData>();
		// create 16 thread for get each product detail
		ExecutorService executorService = Executors.newFixedThreadPool(Constant.MULTI_THREAD);
		Document HTMLDOM, HTMLDOM1, HTMLDOM2;
		String page = "&page=";
		Integer totalUrlOnApage = 48;
		String url = null;

		try {
			HTMLDOM = Spider.connect(Constant.BASEURL);
			List<ObjectData> getListType = catalogAndProductType.getTikiData(HTMLDOM);

			int count = 0;
			for (ObjectData objectData : getListType) {
				if (count == 1)
					break;
				TikiData tikiData = (TikiData) objectData.getValue();
				HTMLDOM1 = Spider.connect(objectData.getKey());
				ioFile.writeToFile("ListUrl", "----" + Spider.getCountProduct() + ", Url: " + objectData.getKey());
				CategoryProduct categoryProduct = catalogAndProductType.getCategoryProduct(HTMLDOM1);
				List<ObjectData> listUrlProductType = catalogAndProductType.getProductType(HTMLDOM1);

				int count1 = 0;
				List<ProductType> productTypeList = new ArrayList<>();
				for (ObjectData objectDataChild : listUrlProductType) {
					if (count1 == 1)
						break;
					ProductType productType = (ProductType) objectDataChild.getValue();
					ArrayList<ProductDetail> productList = new ArrayList<>();
					Integer totalPage = (int) Math.ceil((float) productType.getTotal() / totalUrlOnApage);

					int count2 = 0;
					for (int index = 1; index <= totalPage; index++) {
						if (count2 == 10)
							break;
						url = objectDataChild.getKey() + page + index;
						HTMLDOM2 = Spider.connect(url);
						// return 48 url for each page
						List<String> listUrlEachPage = catalogAndProductType.getListUrlProductInAPage(HTMLDOM2);
						// reference: https://viblo.asia/p/thread-pools-trong-java-ZK1ov1DxG5b9
						executorService.execute(new Runnable() {
							@Override
							public void run() {
								for (String urlDetail : listUrlEachPage) {
									Document HTMLDOM3 = Spider.connect(urlDetail);
									Spider spider = new Spider();
									Spider.setCountProduct(Spider.getCountProduct() + 1);
									ProductDetail productDetail;

									try {
										productDetail = spider.getProductDetail(HTMLDOM3);
										ioFile.writeToFile("TikiData_" + new SimpleDateFormat("dd-MM-yyyy").format(new Date()),
												convertObjToJson.convertObjectToPrettyJson(productDetail));
										productList.add(productDetail);
										ioFile.writeToFile(
												"ListUrl_" + new SimpleDateFormat("dd-MM-yyyy").format(new Date()),
												"--------" + Spider.getCountProduct() + ", Url: " + urlDetail);
										System.out.println(Spider.getCountProduct() + ", Infor: "
												+ productDetail.getProductName() + "---" + productDetail.getPrice());
										// break;
									} catch (NullPointerException e) {
										System.out.println(e.getLocalizedMessage());
										Spider.setCountProduct(Spider.getCountProduct() - 1);
										System.out.println("Error url: " + urlDetail);
										ioFile.writeToFile("LogErrorFile_" + Spider.prefixName,
												"##################### Error NullPointerException #########################");
										ioFile.writeToFile("LogErrorFile_" + Spider.prefixName, "1, Url: " + urlDetail);
										ioFile.writeToFile("LogErrorFile_" + Spider.prefixName,
												"2, Cause: " + e.getMessage());
										ioFile.writeToFile("LogErrorFile_" + Spider.prefixName,
												"3, At time: " + new Date());
									} catch (Exception ex) {
										System.out.println(ex.getMessage());
										Spider.setCountProduct(Spider.getCountProduct() - 1);
										System.out.println("Error url: " + urlDetail);
										ioFile.writeToFile("LogErrorFile_" + Spider.prefixName,
												"##################### Error Exception #########################");
										ioFile.writeToFile("LogErrorFile_" + Spider.prefixName, "1, Url: " + urlDetail);
										ioFile.writeToFile("LogErrorFile_" + Spider.prefixName,
												"2, Cause: " + ex.getMessage());
										ioFile.writeToFile("LogErrorFile_" + Spider.prefixName,
												"3, At time: " + new Date());
									}

								}
							}
						});
						count2++;
					}
					productType.setProductList(productList);
					productTypeList.add(productType);

					count1++;
				}

				categoryProduct.setProductTypeList(productTypeList);
				tikiData.setCategoryProduct(categoryProduct);
				tikiDataList.add(tikiData);

				count++;
			}
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			System.out.println("Error url: " + url);
			ioFile.writeToFile("LogErrorFile_" + Spider.prefixName,
					"##################### Error NullPointerException #########################");
			ioFile.writeToFile("LogErrorFile_" + Spider.prefixName, "1, Url: " + url);
			ioFile.writeToFile("LogErrorFile_" + Spider.prefixName, "2, Cause: " + e.getLocalizedMessage());
			ioFile.writeToFile("LogErrorFile_" + Spider.prefixName, "3, At time: " + new Date());
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error url: " + url);
			ioFile.writeToFile("LogErrorFile_" + Spider.prefixName,
					"##################### Error Exception #########################");
			ioFile.writeToFile("LogErrorFile_" + Spider.prefixName, "1, Url: " + url);
			ioFile.writeToFile("LogErrorFile_" + Spider.prefixName, "2, Cause: " + ex.getLocalizedMessage());
			ioFile.writeToFile("LogErrorFile_" + Spider.prefixName, "3, At time: " + new Date());
		}
		executorService.shutdown();

		return tikiDataList;
	} */

    /**
     * 
     * @param dom
     * @return
     */
    private ProductDetail getProductDetail(Element dom) throws Exception {
        ProductDetail productDetail = new ProductDetail();
        String productName = this.productDetailOnPage.getProductName(dom);
        productDetail.setProductName(productName);

        String brand = this.productDetailOnPage.getBrand(dom);
        productDetail.setBrand(brand);

        Long price = this.productDetailOnPage.getPrice(dom);
        productDetail.setPrice(price);

        String unit = this.productDetailOnPage.getUnitCurrency(dom);
        productDetail.setUnit(unit);

        String save = this.productDetailOnPage.getSave(dom);
        productDetail.setSave(save);

        Long marketPrice = this.productDetailOnPage.getMarketPrice(dom);
        productDetail.setMarketPrice(marketPrice);

        Long sku = this.productDetailOnPage.getSKU(dom);
        productDetail.setSKU(sku);

        List<String> description = this.productDetailOnPage.getDescriptionList(dom);
        productDetail.setDescription(description);

        List<String> imageList = this.productDetailOnPage.getImageList(dom);
        productDetail.setImageList(imageList);

        Integer star = this.productDetailOnPage.getStar(dom);
        productDetail.setStar(Double.valueOf(star));

        Integer vote = this.productDetailOnPage.getVotes(dom);
        productDetail.setVotes(vote);

        DetailDescriptionProduct detailProduct = this.productDetailOnPage.getProductDetail(dom);
        productDetail.setDetailProduct(detailProduct);

        List<ObjectData> anotherData = this.productDetailOnPage.getAnotherData(dom);
        productDetail.setAnotherDetail(anotherData);

        return productDetail;
    }

    /**
     * @return the countProduct
     */
    synchronized public static Integer getCountProduct() {
        return countProduct;
    }

    /**
     * @param countProduct
     *            the countProduct to set
     */
    synchronized public static void setCountProduct(Integer countProduct) {
        Spider.countProduct = countProduct;
    }
}
