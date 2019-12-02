package Test;

import java.io.IOException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import Crawl.CatalogAndProductType;
import Crawl.CatalogAndProductTypeImpl;
import Crawl.ProductDetailInforImpl;
import Crawl.ProductDetailInforPage;
import Crawl.RedirectPageJsFunctionImpl;
import Model.Brand;
import Model.CategoryProduct;
import Model.DetailDescriptionProduct;
import Model.ObjectData;
import Model.ProductType;
import Model.TikiData;
import Utils.Constant;
import Utils.UtilsFunc;

public class MainTest {

	public static void main(String[] args) {
		Document doc;

	/*	try {
			// check CatalogAndProductType class
			CatalogAndProductType testFuncCatalog = new CatalogAndProductTypeImpl();

			// test function getTikiData();
			System.out.println("################################################################################");
			doc = Jsoup.connect(Constant.BASEURL).timeout(Constant.MAX_TIME_CONNECTION).get();
			List<ObjectData> dataReturn = testFuncCatalog.getTikiData(doc);
			for (ObjectData data : dataReturn) {
				System.out.println(data.getKey());
				TikiData tikiData = (TikiData) data.getValue();
				System.out.println(tikiData.getIcon() + " ---- " + tikiData.getName());
			}

			// check function getListUrlProductInAPage();
			System.out.println("################################################################################");
			doc = Jsoup
					.connect("https://tiki.vn/dien-thoai-may-tinh-bang/c1789?src=c.1789.hamburger_menu_fly_out_banner")
					.timeout(Constant.MAX_TIME_CONNECTION).get();
			List<String> listUrl = testFuncCatalog.getListUrlProductInAPage(doc);
			for (String url : listUrl) {
				System.out.println(url);
			}

			// test function getBrandEachProductType();
			System.out.println("################################################################################");
			doc = Jsoup
					.connect("https://tiki.vn/voucher-dich-vu/c11312?src=c.11312.hamburger_menu_fly_out_banner&page=5")
					.timeout(Constant.MAX_TIME_CONNECTION).get();
			List<Brand> brandList = testFuncCatalog.getBrandEachProductType(doc);
			for (Brand data : brandList) {
				System.out.println(data.getBrandName() + "---" + data.getTotal());
			}

			// test function getProductType();
			System.out.println("################################################################################");
			doc = Jsoup
					.connect("https://tiki.vn/thiet-bi-kts-phu-kien-so/c1815?src=c.1815.hamburger_menu_fly_out_banner")
					.timeout(Constant.MAX_TIME_CONNECTION).get();
			List<ObjectData> listObjectData = testFuncCatalog.getProductType(doc);
			for (ObjectData data : listObjectData) {
				System.out.println(data.getKey());
				ProductType productType = (ProductType) data.getValue();
				System.out.println(productType.getProductTypeName() + "---" + productType.getTotal());
			}

			// test function getCategoryProduct();
			System.out.println("################################################################################");
			doc = Jsoup.connect("https://tiki.vn/voucher-dich-vu/c11312?src=c.11312.hamburger_menu_fly_out_banner")
					.timeout(Constant.MAX_TIME_CONNECTION).get();
			CategoryProduct categoryProduct = testFuncCatalog.getCategoryProduct(doc);
			System.out.println(categoryProduct.getCategoryProductName());
			List<Brand> brandList1 = categoryProduct.getBrandList();
			for (Brand brand : brandList1) {
				System.out.println(brand.getBrandName() + "----" + brand.getTotal());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		*/

	/*	try {
			// check ProductDetailInfor class
			ProductDetailInforPage testProductDetailInfor = new ProductDetailInforImpl();
			//url: https://tiki.vn/mu-bao-hiem-royal-m139-kinh-am-p5757605.html?src=category-page-8594&2hi=0
			//url: https://tiki.vn/may-loc-khong-khi-cho-xe-hoi-sharp-ig-gc2e-b-den-hang-chinh-hang-p801326.html?src=category-page-8594&2hi=1
			//url: https://tiki.vn/ta-quan-huggies-dry-goi-cuc-dai-l68-68-mieng-bao-bi-moi-p849022.html?src=category-page-2549&2hi=0
			//url: https://tiki.vn/ngu-coc-hoa-qua-calbee-furugura-nhat-ban-goi-800g-p6956581.html?src=category-page-4384&2hi=1
			//url: https://tiki.vn/bo-5-day-dan-hoi-tap-gym-day-dan-hoi-khang-luc-cao-cap-day-dan-hoi-tap-the-duc-tai-nha-cho-nam-va-nu-p14380357.html?src=category-page-1975&2hi=1
			//url: https://tiki.vn/chuot-khong-day-logitech-m331-silent-plus-hang-chinh-hang-p299461.html?src=category-page-1815&2hi=1
			// https://tiki.vn/may-doc-sach-kindle-paperwhite-2018-7th-hang-chinh-hang-p2686969.html?jsredirect=oke&src=category-page-1789.1794&amp;2hi=1
			//https://tiki.vn/dien-thoai-nokia-105-single-sim-2017-hang-chinh-hang-p809652.html?src=category-page-1789.1796&amp;2hi=1
			doc = Jsoup.connect(
					"https://tiki.vn/ipad-mini-4-128gb-wifi-3g-4g-nhap-khau-chinh-hang-vang-p1587275.html?src=category-page-1789.1794&amp;2hi=1")
					.timeout(Constant.MAX_TIME_CONNECTION)
					.get();
			System.out.println(doc);
			System.out.println("brand: " + testProductDetailInfor.getBrand(doc));
			System.out.println("name: " + testProductDetailInfor.getProductName(doc));
			System.out.println("save: " + testProductDetailInfor.getSave(doc));

			System.out.println("market Price: " + testProductDetailInfor.getMarketPrice(doc));
			System.out.println("Sku: " + testProductDetailInfor.getSKU(doc));
			System.out.println("star: " + testProductDetailInfor.getStar(doc));

			System.out.println("vote: " + testProductDetailInfor.getVotes(doc));
			System.out.println("price: " + testProductDetailInfor.getPrice(doc)); 

			System.out.println("image List: ");
			List<String> image = testProductDetailInfor.getImageList(doc);
			for (String img : image)
				System.out.println(img);

			System.out.println("description List: ");
			List<String> description = testProductDetailInfor.getDescriptionList(doc);
			for (String des : description)
				System.out.println(des); 

			System.out.println("DetailDescriptionProduct List: ");
			DetailDescriptionProduct detailDes = testProductDetailInfor.getProductDetail(doc);
			
			System.out.println("***) html: " + detailDes.getDescriptionHtml());
			
			System.out.println("***) replace All html tag: " + detailDes.getDescription());
			
			System.out.println("***) put in text: ");
			List<String> listDesc = detailDes.getStorageInformation();
			for (String desc : listDesc)
				System.out.println(desc);
			
			List<ObjectData> objectData = testProductDetailInfor.getAnotherData(doc);
			for(ObjectData data : objectData) {
				System.out.println(data.getKey() + "---" + data.getValue());
			}
			
			String unit = testProductDetailInfor.getUnitCurrency(doc);
			System.out.println("unit " + unit);
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}  */
	
		
/*	String str = "<div id=\"gioi-thieu\" class=\"content js-content\" itemprop=\"description\"> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: center;\" align=\"center\"><span style=\"margin: 0px; padding: 0px; font-size: 11pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 15.6933px;\"><span style=\"margin: 0px; padding: 0px; font-family: calibri, sans-serif;\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder;\"><span style=\"margin: 0px; padding: 0px; font-size: 16pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 22.8267px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i7.5ae66d39rOntDP\">BỘ 5 DÂY CAO SU �?ÀN HỒI KH�?NG LỰC THỂ THAO DYNAMIC</span></span></span></span></span></span></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px;\">Trong đ�?i sống hiện đại ngày nay, con ngư�?i ta đã quan tâm nhi�?u hơn đến sức kh�?e của bản thân mình. Cụ thể là việc trào lưu tập gym, yoga, các h�?at động thể dục thể thao ra đ�?i và ngày càng phát triển. Không những vậy, các dụng cụ bổ trợ cho quá trình tập luyện cũng rất được ưa chuộng. Dây cao su đàn hồi kháng lực Dynamic là một trong những sản phẩm như thế.</span></span></span></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder;\"><span style=\"margin: 0px; padding: 0px;\">Vậy… dây cao su đàn hồi kháng lực là gì?</span></span></span></span></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px;\">Là sản phẩm được làm từ chất liệu cao su cao cấp, hỗ trợ các hoạt động luyện tập thể dục thể thao đạt hiệu quả tốt hơn.</span></span></span></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\">Với những ưu điểm như: giá cả phải chăng, dễ sử dụng, đem lại hiệu quả tập luyện cao. Dây kháng lực Dynamic sẽ là sự lựa ch�?n lý tưởng cho việc luyện tập hàng ngày của bạn.<img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/93/ef/b2/24cc7e565bfd25f7bf0469cb6eceacdc.jpg\" alt=\"\" width=\"643\" height=\"900\"></span></span></span></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder;\"><span style=\"margin: 0px; padding: 0px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i8.5ae66d39rOntDP\">Công dụng:</span></span></span></span></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px;\">Dây đàn hồi cao su kháng lực cho phép ngư�?i sử dụng đi�?u chỉnh mức độ đàn hồi phù hợp với mức cơ bắp muốn đạt tới. Loại dây này phù hợp cho các bài tập KHÔNG cần đến tạ, giúp tăng lực cơ tay, vai, lưng, chân, hỗ trợ tập squat và rất nhi�?u bài tập từ cấp độ đơn giản đến phức tạp.</span></span></span></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder;\"><span style=\"margin: 0px; padding: 0px;\">Tại sao lựa ch�?n?</span></span></span></span></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\">- Kích thước:</span></span></span></span><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\">&nbsp;đa dạng, có nhi�?u lựa ch�?n giúp đi�?u chỉnh mức đàn hồi chính xác với mức từng cơ bắp mong muốn.</span></span></span></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\">&nbsp;</p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><img style=\"margin: 0px; padding: 0px; border-style: none; max-width: 100%; height: 200px; width: 818px;\" src=\"https://vn-live.slatic.net/original/03e16d0b062f537fd02528212d88c959.jpg\"></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/55/a3/71/2db505aac7000a4a5ab148cb42705d00.jpg\" alt=\"\" width=\"643\" height=\"900\"></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder; text-align: justify;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i9.5ae66d39rOntDP\">- Hỗ trợ tăng cư�?ng sự linh hoạt</span></span></span></span><span style=\"margin: 0px; padding: 0px; text-align: justify; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\">: làm các nhóm cơ trở nên săn chắc hơn, phù hợp với các bài tập mông, chân, bụng, eo trong các bài tập gym và yoga.</span></span></span></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><span style=\"margin: 0px; padding: 0px; text-align: justify; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/e2/d0/13/7f2c4563aec927114d2bfa8d69528189.jpg\" alt=\"\" width=\"740\" height=\"800\"></span></span></span></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder;\"><span style=\"margin: 0px; padding: 0px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i10.5ae66d39rOntDP\">T�?C DỤNGX2:</span></span><span style=\"margin: 0px; padding: 0px;\">&nbsp;khác với nâng tạ tự do chỉ cung cấp kháng lực cho bạn khi bạn nhấc lên, việc sử dụng dây đàn hồi cung cấp cho bạn kháng lực cả 2 chi�?u. Nh�? đó, hiệu quả tập luyện sẽ được nâng lên&nbsp;<span style=\"margin: 0px; padding: 0px; font-weight: bolder;\"><span style=\"margin: 0px; padding: 0px;\">gấp đôi</span></span>.</span></span></span></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px;\">Không những thế, việc sử dụng dây cao su kháng lực còn giúp tăng cư�?ng khả năng chịu đựng cho cơ tay,cơ vai, cơ chân và giúp loại b�? lượng calo và chất béo dư thừa ngay khi bạn đang thả l�?ng.</span></span></span></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\">&nbsp;</p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\">Việc thư�?ng xuyên tập luyện với dây đai cao su sẽ cho bạn hệ cơ phát triển toàn diện, giảm mỡ thừa hiệu quả, đặc biệt làở các vùng khó giảm như eo, đùi, bắp tay,…</span></span></span></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/df/8e/ba/218af2995b71a1da3b9665b48f7e5b5b.png\" alt=\"\" width=\"643\" height=\"900\"></span></span></span></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder; text-align: justify;\"><span style=\"margin: 0px; padding: 0px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i11.5ae66d39rOntDP\">&nbsp;Chất liệu:</span></span><span style=\"margin: 0px; padding: 0px; text-align: justify;\">&nbsp;cao su cao cấp, đàn hồi cao, đạt tiêu chuẩn châu Âu và than thiện với môi trư�?ng. Ngoài ra, dây còn có thể kéo dài hơn 6 lần và nhanh đàn hồi, không biến dạng, không độc hại.</span></span></span></span></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; text-align: justify;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/33/bd/5d/9406a2a9003ce19d55e640d9cc36778a.jpg\" alt=\"\" width=\"687\" height=\"854\"></span></span></span></span></p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\">&nbsp;</p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i12.5ae66d39rOntDP\"><span style=\"margin: 0px; padding: 0px; font-size: 11pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 15.6933px;\"><span style=\"margin: 0px; padding: 0px; font-family: calibri, sans-serif;\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\">- Tiện dụng:</span></span></span><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i14.5ae66d39rOntDP\">&nbsp;trong việc cất giữ hoặc mang đi tập ở m�?i nơi, m�?i lúc.</span></span></span></span></span></p> \r\n" + 
			" <p><span style=\"margin: 0px; padding: 0px; font-size: 11pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 15.6933px;\"><span style=\"margin: 0px; padding: 0px; font-family: calibri, sans-serif;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i14.5ae66d39rOntDP\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/33/de/5b/766e0812c195845de1a65ed7dec545f7.jpg\" alt=\"\" width=\"643\" height=\"900\"><br></span></span></span></span></span></p> \r\n" + 
			" <p><span style=\"margin: 0px; padding: 0px; font-size: 11pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 15.6933px;\"><span style=\"margin: 0px; padding: 0px; font-family: calibri, sans-serif;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i14.5ae66d39rOntDP\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><u style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\">Hướng dẫn tập luyện</span></span></span></u></span></span></span></span></span></span></p> \r\n" + 
			" <p><span style=\"margin: 0px; padding: 0px; font-size: 11pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 15.6933px;\"><span style=\"margin: 0px; padding: 0px; font-family: calibri, sans-serif;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i14.5ae66d39rOntDP\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><u style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/df/55/05/22cb4afdc5036a1a6f19eef2a146f7f2.jpg\" alt=\"\" width=\"750\" height=\"416\"></span></span></span></u></span></span></span></span></span></span></p> \r\n" + 
			" <p><span style=\"margin: 0px; padding: 0px; font-size: 11pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 15.6933px;\"><span style=\"margin: 0px; padding: 0px; font-family: calibri, sans-serif;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i14.5ae66d39rOntDP\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><u style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/c8/3c/fa/5427c3013824bd309b88bb38098d54f5.jpg\" alt=\"\" width=\"750\" height=\"469\"></span></span></span></u></span></span></span></span></span></span></p> \r\n" + 
			" <p><span style=\"margin: 0px; padding: 0px; font-size: 11pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 15.6933px;\"><span style=\"margin: 0px; padding: 0px; font-family: calibri, sans-serif;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i14.5ae66d39rOntDP\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><u style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/a3/fb/9c/7e89508dc1d910b6458f6927f339c3a6.jpg\" alt=\"\" width=\"750\" height=\"562\"></span></span></span></u></span></span></span></span></span></span></p> \r\n" + 
			" <p><span style=\"margin: 0px; padding: 0px; font-size: 11pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 15.6933px;\"><span style=\"margin: 0px; padding: 0px; font-family: calibri, sans-serif;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i14.5ae66d39rOntDP\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><u style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/71/c8/15/30a1bf621fbb28ad4cd2984a870a554c.jpg\" alt=\"\" width=\"750\" height=\"469\"></span></span></span></u></span></span></span></span></span></span></p> \r\n" + 
			" <p><img id=\"https://salt.tikicdn.com/ts/tmp/1d/01/b6/d1d2c23b2effb736c01c9358e91008b1.jpg\" style=\"display: block; margin-left: auto; margin-right: auto;\" title=\"\" src=\"https://salt.tikicdn.com/ts/tmp/1d/01/b6/d1d2c23b2effb736c01c9358e91008b1.jpg\" alt=\"\" width=\"600\" height=\"400\"></p> \r\n" + 
			" <p><img id=\"https://salt.tikicdn.com/ts/tmp/0a/85/a9/90eaf29ce9fd25cb37408522bf8c82b0.jpg\" style=\"display: block; margin-left: auto; margin-right: auto;\" title=\"\" src=\"https://salt.tikicdn.com/ts/tmp/0a/85/a9/90eaf29ce9fd25cb37408522bf8c82b0.jpg\" alt=\"\" width=\"650\" height=\"599\"></p> \r\n" + 
			" <p><img id=\"https://salt.tikicdn.com/ts/tmp/7d/30/7a/ed3d6a8971e5973805759d5ccaee6f49.jpg\" style=\"display: block; margin-left: auto; margin-right: auto;\" title=\"\" src=\"https://salt.tikicdn.com/ts/tmp/7d/30/7a/ed3d6a8971e5973805759d5ccaee6f49.jpg\" alt=\"\" width=\"600\" height=\"600\"></p> \r\n" + 
			" <p>&nbsp;</p> \r\n" + 
			" <p>&nbsp;</p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\">&nbsp;</p> \r\n" + 
			" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\">&nbsp;</p> \r\n" + 
			"</div>";	
	
	List<String> listText = UtilsFunc.getTextInformationInTagHtmlAdvance(str);
	System.out.println("#########################################(UtilsFunc.getTextInformationInTagHtmlAdvance(str))########################################");
	for(String text2 : listText)
		System.out.println(text2);
	
	String another = "<p style=\\\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\\\"><span style=\\\"margin: 0px; padding: 0px; font-weight: bolder;\\\"><span style=\\\"margin: 0px; padding: 0px; font-size: 12pt;\\\"><span style=\\\"margin: 0px; padding: 0px; line-height: 17.12px;\\\"><span style=\\\"margin: 0px; padding: 0px;\\\">- Kích thước:</span></span></span></span><span style=\\\"margin: 0px; padding: 0px; font-size: 12pt;\\\"><span style=\\\"margin: 0px; padding: 0px; line-height: 17.12px;\\\"><span style=\\\"margin: 0px; padding: 0px;\\\">&nbsp;đa dạng, có nhi�?u lựa ch�?n giúp đi�?u chỉnh mức đàn hồi chính xác với mức từng cơ bắp mong muốn.</span></span></span></p>";
	List<String> listText1 = UtilsFunc.getTextInformationInTagHtmlAdvance(another);
	System.out.println("#######################################(UtilsFunc.getTextInformationInTagHtmlAdvance(another))##########################################");
	for(String text : listText1)
		System.out.println(text);
		
	String textabc = " <div class=\"attribute-table multi-table\"></div>\r\n" + 
			"            <table id=\"chi-tiet\" cellspacing=\"0\" class=\"table table-bordered table-detail table-striped\">\r\n" + 
			"                <colgroup>\r\n" + 
			"                    <col style=\"width: 25%;\"><col>\r\n" + 
			"                </colgroup>\r\n" + 
			"                <tbody>\r\n" + 
			"                                                                                        <tr>\r\n" + 
			"                                <td rel=\"brand\">Thương hiệu</td>\r\n" + 
			"                                <td class=\"last\">\r\n" + 
			"                                                                            <a href=\"http://tiki.vn/thuong-hieu/soho.html\">Soho</a>\r\n" + 
			"                                    \r\n" + 
			"                                                                    </td>\r\n" + 
			"                            </tr>\r\n" + 
			"                                                    <tr>\r\n" + 
			"                                <td rel=\"sku\">SKU</td>\r\n" + 
			"                                <td class=\"last\">\r\n" + 
			"                                                                            2026353258835                                    \r\n" + 
			"                                                                    </td>\r\n" + 
			"                            </tr>\r\n" + 
			"                                                                                                                                    <tr>\r\n" + 
			"                                <td rel=\"origin\">Sản xuất tại</td>\r\n" + 
			"                                <td class=\"last\">\r\n" + 
			"                                                                            Việt Nam                                    \r\n" + 
			"                                                                    </td>\r\n" + 
			"                            </tr>\r\n" + 
			"                                                    <tr>\r\n" + 
			"                                <td rel=\"product_weight\">Tr�?ng lượng</td>\r\n" + 
			"                                <td class=\"last\">\r\n" + 
			"                                                                            7000                                    \r\n" + 
			"                                                                    </td>\r\n" + 
			"                            </tr>\r\n" + 
			"                                                    <tr>\r\n" + 
			"                                <td rel=\"dimensions\">Kích thước</td>\r\n" + 
			"                                <td class=\"last\">\r\n" + 
			"                                                                            70 x 39 x 12 cm                                    \r\n" + 
			"                                                                    </td>\r\n" + 
			"                            </tr>\r\n" + 
			"                                                                        </tbody>\r\n" + 
			"        </table>\r\n" + 
			"    </div>";
	
		List<String> listText2 = UtilsFunc.getTextInformationInTagHtmlAdvance(textabc);
		System.out.println("#########################################(UtilsFunc.getTextInformationInTagHtmlAdvance(textabc);)########################################");
		for(String text : listText2)
			System.out.println(text);
		*/
		
	/*	
		String str = "<div id=\"gioi-thieu\" class=\"content js-content\" itemprop=\"description\"> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: center;\" align=\"center\"><span style=\"margin: 0px; padding: 0px; font-size: 11pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 15.6933px;\"><span style=\"margin: 0px; padding: 0px; font-family: calibri, sans-serif;\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder;\"><span style=\"margin: 0px; padding: 0px; font-size: 16pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 22.8267px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i7.5ae66d39rOntDP\">BỘ 5 DÂY CAO SU �?ÀN HỒI KH�?NG LỰC THỂ THAO DYNAMIC</span></span></span></span></span></span></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px;\">Trong đ�?i sống hiện đại ngày nay, con ngư�?i ta đã quan tâm nhi�?u hơn đến sức kh�?e của bản thân mình. Cụ thể là việc trào lưu tập gym, yoga, các h�?at động thể dục thể thao ra đ�?i và ngày càng phát triển. Không những vậy, các dụng cụ bổ trợ cho quá trình tập luyện cũng rất được ưa chuộng. Dây cao su đàn hồi kháng lực Dynamic là một trong những sản phẩm như thế.</span></span></span></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder;\"><span style=\"margin: 0px; padding: 0px;\">Vậy… dây cao su đàn hồi kháng lực là gì?</span></span></span></span></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px;\">Là sản phẩm được làm từ chất liệu cao su cao cấp, hỗ trợ các hoạt động luyện tập thể dục thể thao đạt hiệu quả tốt hơn.</span></span></span></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\">Với những ưu điểm như: giá cả phải chăng, dễ sử dụng, đem lại hiệu quả tập luyện cao. Dây kháng lực Dynamic sẽ là sự lựa ch�?n lý tưởng cho việc luyện tập hàng ngày của bạn.<img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/93/ef/b2/24cc7e565bfd25f7bf0469cb6eceacdc.jpg\" alt=\"\" width=\"643\" height=\"900\"></span></span></span></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder;\"><span style=\"margin: 0px; padding: 0px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i8.5ae66d39rOntDP\">Công dụng:</span></span></span></span></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px;\">Dây đàn hồi cao su kháng lực cho phép ngư�?i sử dụng đi�?u chỉnh mức độ đàn hồi phù hợp với mức cơ bắp muốn đạt tới. Loại dây này phù hợp cho các bài tập KHÔNG cần đến tạ, giúp tăng lực cơ tay, vai, lưng, chân, hỗ trợ tập squat và rất nhi�?u bài tập từ cấp độ đơn giản đến phức tạp.</span></span></span></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder;\"><span style=\"margin: 0px; padding: 0px;\">Tại sao lựa ch�?n?</span></span></span></span></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\">- Kích thước:</span></span></span></span><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\">&nbsp;đa dạng, có nhi�?u lựa ch�?n giúp đi�?u chỉnh mức đàn hồi chính xác với mức từng cơ bắp mong muốn.</span></span></span></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\">&nbsp;</p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><img style=\"margin: 0px; padding: 0px; border-style: none; max-width: 100%; height: 200px; width: 818px;\" src=\"https://vn-live.slatic.net/original/03e16d0b062f537fd02528212d88c959.jpg\"></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/55/a3/71/2db505aac7000a4a5ab148cb42705d00.jpg\" alt=\"\" width=\"643\" height=\"900\"></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder; text-align: justify;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i9.5ae66d39rOntDP\">- Hỗ trợ tăng cư�?ng sự linh hoạt</span></span></span></span><span style=\"margin: 0px; padding: 0px; text-align: justify; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\">: làm các nhóm cơ trở nên săn chắc hơn, phù hợp với các bài tập mông, chân, bụng, eo trong các bài tập gym và yoga.</span></span></span></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><span style=\"margin: 0px; padding: 0px; text-align: justify; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/e2/d0/13/7f2c4563aec927114d2bfa8d69528189.jpg\" alt=\"\" width=\"740\" height=\"800\"></span></span></span></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder;\"><span style=\"margin: 0px; padding: 0px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i10.5ae66d39rOntDP\">T�?C DỤNGX2:</span></span><span style=\"margin: 0px; padding: 0px;\">&nbsp;khác với nâng tạ tự do chỉ cung cấp kháng lực cho bạn khi bạn nhấc lên, việc sử dụng dây đàn hồi cung cấp cho bạn kháng lực cả 2 chi�?u. Nh�? đó, hiệu quả tập luyện sẽ được nâng lên&nbsp;<span style=\"margin: 0px; padding: 0px; font-weight: bolder;\"><span style=\"margin: 0px; padding: 0px;\">gấp đôi</span></span>.</span></span></span></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px;\">Không những thế, việc sử dụng dây cao su kháng lực còn giúp tăng cư�?ng khả năng chịu đựng cho cơ tay,cơ vai, cơ chân và giúp loại b�? lượng calo và chất béo dư thừa ngay khi bạn đang thả l�?ng.</span></span></span></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\">&nbsp;</p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\">Việc thư�?ng xuyên tập luyện với dây đai cao su sẽ cho bạn hệ cơ phát triển toàn diện, giảm mỡ thừa hiệu quả, đặc biệt làở các vùng khó giảm như eo, đùi, bắp tay,…</span></span></span></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/df/8e/ba/218af2995b71a1da3b9665b48f7e5b5b.png\" alt=\"\" width=\"643\" height=\"900\"></span></span></span></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder; text-align: justify;\"><span style=\"margin: 0px; padding: 0px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i11.5ae66d39rOntDP\">&nbsp;Chất liệu:</span></span><span style=\"margin: 0px; padding: 0px; text-align: justify;\">&nbsp;cao su cao cấp, đàn hồi cao, đạt tiêu chuẩn châu Âu và than thiện với môi trư�?ng. Ngoài ra, dây còn có thể kéo dài hơn 6 lần và nhanh đàn hồi, không biến dạng, không độc hại.</span></span></span></span></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; text-align: justify;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/33/bd/5d/9406a2a9003ce19d55e640d9cc36778a.jpg\" alt=\"\" width=\"687\" height=\"854\"></span></span></span></span></p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\">&nbsp;</p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i12.5ae66d39rOntDP\"><span style=\"margin: 0px; padding: 0px; font-size: 11pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 15.6933px;\"><span style=\"margin: 0px; padding: 0px; font-family: calibri, sans-serif;\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\">- Tiện dụng:</span></span></span><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i14.5ae66d39rOntDP\">&nbsp;trong việc cất giữ hoặc mang đi tập ở m�?i nơi, m�?i lúc.</span></span></span></span></span></p> \r\n" + 
				" <p><span style=\"margin: 0px; padding: 0px; font-size: 11pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 15.6933px;\"><span style=\"margin: 0px; padding: 0px; font-family: calibri, sans-serif;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i14.5ae66d39rOntDP\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/33/de/5b/766e0812c195845de1a65ed7dec545f7.jpg\" alt=\"\" width=\"643\" height=\"900\"><br></span></span></span></span></span></p> \r\n" + 
				" <p><span style=\"margin: 0px; padding: 0px; font-size: 11pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 15.6933px;\"><span style=\"margin: 0px; padding: 0px; font-family: calibri, sans-serif;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i14.5ae66d39rOntDP\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><u style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\">Hướng dẫn tập luyện</span></span></span></u></span></span></span></span></span></span></p> \r\n" + 
				" <p><span style=\"margin: 0px; padding: 0px; font-size: 11pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 15.6933px;\"><span style=\"margin: 0px; padding: 0px; font-family: calibri, sans-serif;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i14.5ae66d39rOntDP\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><u style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/df/55/05/22cb4afdc5036a1a6f19eef2a146f7f2.jpg\" alt=\"\" width=\"750\" height=\"416\"></span></span></span></u></span></span></span></span></span></span></p> \r\n" + 
				" <p><span style=\"margin: 0px; padding: 0px; font-size: 11pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 15.6933px;\"><span style=\"margin: 0px; padding: 0px; font-family: calibri, sans-serif;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i14.5ae66d39rOntDP\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><u style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/c8/3c/fa/5427c3013824bd309b88bb38098d54f5.jpg\" alt=\"\" width=\"750\" height=\"469\"></span></span></span></u></span></span></span></span></span></span></p> \r\n" + 
				" <p><span style=\"margin: 0px; padding: 0px; font-size: 11pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 15.6933px;\"><span style=\"margin: 0px; padding: 0px; font-family: calibri, sans-serif;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i14.5ae66d39rOntDP\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><u style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/a3/fb/9c/7e89508dc1d910b6458f6927f339c3a6.jpg\" alt=\"\" width=\"750\" height=\"562\"></span></span></span></u></span></span></span></span></span></span></p> \r\n" + 
				" <p><span style=\"margin: 0px; padding: 0px; font-size: 11pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 15.6933px;\"><span style=\"margin: 0px; padding: 0px; font-family: calibri, sans-serif;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\" data-spm-anchor-id=\"a2o4n.pdp.product_detail.i14.5ae66d39rOntDP\"><span style=\"margin: 0px; padding: 0px; font-weight: bolder; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\"><u style=\"margin: 0px; padding: 0px;\"><span style=\"margin: 0px; padding: 0px; font-size: 12pt;\"><span style=\"margin: 0px; padding: 0px; line-height: 17.12px;\"><span style=\"margin: 0px; padding: 0px;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src=\"https://salt.tikicdn.com/ts/tmp/71/c8/15/30a1bf621fbb28ad4cd2984a870a554c.jpg\" alt=\"\" width=\"750\" height=\"469\"></span></span></span></u></span></span></span></span></span></span></p> \r\n" + 
				" <p><img id=\"https://salt.tikicdn.com/ts/tmp/1d/01/b6/d1d2c23b2effb736c01c9358e91008b1.jpg\" style=\"display: block; margin-left: auto; margin-right: auto;\" title=\"\" src=\"https://salt.tikicdn.com/ts/tmp/1d/01/b6/d1d2c23b2effb736c01c9358e91008b1.jpg\" alt=\"\" width=\"600\" height=\"400\"></p> \r\n" + 
				" <p><img id=\"https://salt.tikicdn.com/ts/tmp/0a/85/a9/90eaf29ce9fd25cb37408522bf8c82b0.jpg\" style=\"display: block; margin-left: auto; margin-right: auto;\" title=\"\" src=\"https://salt.tikicdn.com/ts/tmp/0a/85/a9/90eaf29ce9fd25cb37408522bf8c82b0.jpg\" alt=\"\" width=\"650\" height=\"599\"></p> \r\n" + 
				" <p><img id=\"https://salt.tikicdn.com/ts/tmp/7d/30/7a/ed3d6a8971e5973805759d5ccaee6f49.jpg\" style=\"display: block; margin-left: auto; margin-right: auto;\" title=\"\" src=\"https://salt.tikicdn.com/ts/tmp/7d/30/7a/ed3d6a8971e5973805759d5ccaee6f49.jpg\" alt=\"\" width=\"600\" height=\"600\"></p> \r\n" + 
				" <p>&nbsp;</p> \r\n" + 
				" <p>&nbsp;</p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\">&nbsp;</p> \r\n" + 
				" <p style=\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px;\">&nbsp;</p> \r\n" + 
				"</div>";	
		
		List<String> listText = UtilsFunc.getTextInformationInTagHtml(str);
		System.out.println("##################################################################################");
		for(String text2 : listText)
			System.out.println(text2);
		
		String another = "<p style=\\\"margin: 0in 0in 8pt; padding: 0px; unicode-bidi: embed; font-family: Roboto, -apple-system, BlinkMacSystemFont, 'Helvetica Neue', Helvetica, sans-serif; font-size: 12px; text-align: justify;\\\"><span style=\\\"margin: 0px; padding: 0px; font-weight: bolder;\\\"><span style=\\\"margin: 0px; padding: 0px; font-size: 12pt;\\\"><span style=\\\"margin: 0px; padding: 0px; line-height: 17.12px;\\\"><span style=\\\"margin: 0px; padding: 0px;\\\">- Kích thước:</span></span></span></span><span style=\\\"margin: 0px; padding: 0px; font-size: 12pt;\\\"><span style=\\\"margin: 0px; padding: 0px; line-height: 17.12px;\\\"><span style=\\\"margin: 0px; padding: 0px;\\\">&nbsp;đa dạng, có nhi�?u lựa ch�?n giúp đi�?u chỉnh mức đàn hồi chính xác với mức từng cơ bắp mong muốn.</span></span></span></p>";
		List<String> listText1 = UtilsFunc.getTextInformationInTagHtml(another);
		System.out.println("##################################################################################");
		for(String text : listText1)
			System.out.println(text);
			
		String textabc = " <div class=\"attribute-table multi-table\"></div>\r\n" + 
				"            <table id=\"chi-tiet\" cellspacing=\"0\" class=\"table table-bordered table-detail table-striped\">\r\n" + 
				"                <colgroup>\r\n" + 
				"                    <col style=\"width: 25%;\"><col>\r\n" + 
				"                </colgroup>\r\n" + 
				"                <tbody>\r\n" + 
				"                                                                                        <tr>\r\n" + 
				"                                <td rel=\"brand\">Thương hiệu</td>\r\n" + 
				"                                <td class=\"last\">\r\n" + 
				"                                                                            <a href=\"http://tiki.vn/thuong-hieu/soho.html\">Soho</a>\r\n" + 
				"                                    \r\n" + 
				"                                                                    </td>\r\n" + 
				"                            </tr>\r\n" + 
				"                                                    <tr>\r\n" + 
				"                                <td rel=\"sku\">SKU</td>\r\n" + 
				"                                <td class=\"last\">\r\n" + 
				"                                                                            2026353258835                                    \r\n" + 
				"                                                                    </td>\r\n" + 
				"                            </tr>\r\n" + 
				"                                                                                                                                    <tr>\r\n" + 
				"                                <td rel=\"origin\">Sản xuất tại</td>\r\n" + 
				"                                <td class=\"last\">\r\n" + 
				"                                                                            Việt Nam                                    \r\n" + 
				"                                                                    </td>\r\n" + 
				"                            </tr>\r\n" + 
				"                                                    <tr>\r\n" + 
				"                                <td rel=\"product_weight\">Tr�?ng lượng</td>\r\n" + 
				"                                <td class=\"last\">\r\n" + 
				"                                                                            7000                                    \r\n" + 
				"                                                                    </td>\r\n" + 
				"                            </tr>\r\n" + 
				"                                                    <tr>\r\n" + 
				"                                <td rel=\"dimensions\">Kích thước</td>\r\n" + 
				"                                <td class=\"last\">\r\n" + 
				"                                                                            70 x 39 x 12 cm                                    \r\n" + 
				"                                                                    </td>\r\n" + 
				"                            </tr>\r\n" + 
				"                                                                        </tbody>\r\n" + 
				"        </table>\r\n" + 
				"    </div>";
		
			List<String> listText2 = UtilsFunc.getTextInformationInTagHtml(textabc);
			System.out.println("##################################################################################");
			for(String text : listText2)
				System.out.println(text); 
				
		*/
		
		//String test = "int a = 2;\n\r int b = 47;/*37;*///41;\n\r int c = 3/*4//5*/;\n\r return a / b * c/*a /* b / c*/;";
        String test = "#var a = 2;\n\r"
                + "// hello world pham val // /// //////\n\r"
                + "let m = 5000000;<!--\n\r"
                + "var b = 2;\n\r"
                + "if (a === b) {\n\r  b = a + 1;\n\r"
                + "  //b = a * 2 - 1;\n\r"
                + "}\n\r"
                + "-->\n\r"
                + "var b = 3;\n\r"
                + "return a * b;return a / b * c<!--a <!-- b / c-->;\n\r"
                + "const counter = 234; /* example for this /* not for you, let bn = \\\"jajaja\\\" **/";
		
		RedirectPageJsFunctionImpl testRedirectPageJsFunctionImpl = new RedirectPageJsFunctionImpl();
		String tmp = testRedirectPageJsFunctionImpl.ignoreCommentAdvance(test, "//||#||--", "(<!--||-->)##(/*||*/)");
		System.out.println(tmp);
	//	System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
	//	System.out.println(testRedirectPageJsFunctionImpl.ignoreComment(test));
	}
}
