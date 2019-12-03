package Crawl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Model.Brand;
import Model.CategoryProduct;
import Model.ObjectData;
import Model.ProductType;
import Model.TikiData;
import Utils.Constant;
import Utils.UtilsFunc;

public class CatalogAndProductTypeImpl implements CatalogAndProductType {

    private volatile static CatalogAndProductTypeImpl catalogAndProductTypeImpl;
    
    private CatalogAndProductTypeImpl() {}
    
    public static CatalogAndProductTypeImpl getInstanceObject() {
        if(catalogAndProductTypeImpl == null) {
            synchronized (CatalogAndProductTypeImpl.class) {
                if(catalogAndProductTypeImpl == null)
                    return new CatalogAndProductTypeImpl();
            }
        }
        
        return catalogAndProductTypeImpl;
    }
    
	@Override
	public List<ObjectData> getTikiData(Element element){
		List<ObjectData> data = new ArrayList<>();
		Element mainDocument = element.selectFirst("main");
		Element containerList = mainDocument.selectFirst("div.Container-sc-1fnsswg-0.itgICN");
		Element containerListUl = containerList.selectFirst("ul");
		Elements containerListLi = containerListUl.select("li");

		for (Element elemt : containerListLi) {
			ObjectData objectData = new ObjectData();

			Element Eurl = elemt.selectFirst("a");
			String url = Eurl != null ? UtilsFunc.getValueAttrTagHtml(Eurl.toString(), "href") : "";
			objectData.setKey(url);

			Element EProductName = elemt.selectFirst("span.text");
			String productName = EProductName != null ? UtilsFunc.getValueInTagHtml(EProductName.toString()) : "";

			Element Eicon = elemt.selectFirst("span.icon-wrap").selectFirst("i");
			String icon = Eicon != null ? UtilsFunc.getValueAttrTagHtml(Eicon.toString(), "class") : "";

			TikiData categoryProduct = new TikiData();
			categoryProduct.setName(productName);
			categoryProduct.setIcon(icon);

			objectData.setValue(categoryProduct);
			data.add(objectData);
		}

		return data;
	}

	@Override
	public CategoryProduct getCategoryProduct(Element element){
		CategoryProduct data = new CategoryProduct();
		Element divContainer = element.selectFirst("div#collapse-category");
		Element categoryProductNameE = divContainer.selectFirst("div.list-group-item.is-top");
		
		String categoryProductName = categoryProductNameE.selectFirst("strong").html();
		data.setCategoryProductName(categoryProductName);
		List<Brand> brandList = this.getBrandEachProductType(element);
		data.setBrandList(brandList);
		
		return data;
	}

	@Override
	public List<ObjectData> getProductType(Element element){
		List<ObjectData> data = new ArrayList<>();
		Element divContainer = element.selectFirst("div#collapse-category");
		Elements listProductType = divContainer.select("div.list-group-item.is-child");

		for (Element ele : listProductType) {
			ObjectData objectData = new ObjectData();
			Element urlE = ele.selectFirst("a");
			String url = urlE != null ? UtilsFunc.getValueAttrTagHtml(urlE.toString(), "href") : "";
			objectData.setKey(Constant.BASEURL.concat(url));
			ProductType productType = new ProductType();
			if (urlE != null) {
				String productTypeName = UtilsFunc.getValueInTagHtml(urlE.toString());
				productType.setProductTypeName(productTypeName);

				Element totalCompanyTagA = urlE.selectFirst("span");
				String totalStr = totalCompanyTagA.html().substring(1, totalCompanyTagA.html().length() - 1);
				Integer total = UtilsFunc.isNumeric(totalStr) ? Integer.parseInt(totalStr) : 0;
				productType.setTotal(total);
			}
			objectData.setValue(productType);
			data.add(objectData);
		}

		return data;
	}

	@Override
	public List<Brand> getBrandEachProductType(Element element){
		List<Brand> brandList = new ArrayList<Brand>();

		Element divContainer = element.selectFirst("div#collapse-brand");
		if(divContainer == null ) {
			element.selectFirst("div#collapse-device_compatibilityƯ");
		}
		if(divContainer == null ) {
			element.selectFirst("div#collapse-filter_baby_diaper_size");
		}
		Element divContainerNext = divContainer.selectFirst("div.list-group");
		Elements brandListE = divContainerNext.select("div.list-group-item");
		for (Element brandE : brandListE) {
			Brand brand = new Brand();
			Element brandNameTagA = brandE.selectFirst("a");
			String brandName = brandNameTagA != null ? UtilsFunc.getValueInTagHtml(brandNameTagA.toString()) : "";
			brand.setBrandName(brandName);
			if (brandNameTagA != null) {
				Element totalCompanyTagA = brandNameTagA.selectFirst("span");
				if(totalCompanyTagA != null) {
					String totalStr = totalCompanyTagA.html().substring(1, totalCompanyTagA.html().length() - 1);
					Integer total = UtilsFunc.isNumeric(totalStr) ? Integer.parseInt(totalStr) : 0;
					brand.setTotal(total);
				}
			}
			brandList.add(brand);
		}
		// Show more brand
		Element divContainerShowmoreItem = divContainer.selectFirst("div.list-group-more.js-more");
		if(divContainerShowmoreItem != null) {
			brandListE = divContainerShowmoreItem.select("div.list-group-item");
			for (Element brandE : brandListE) {
				Brand brand = new Brand();
				Element brandNameTagA = brandE.selectFirst("a");
				String brandName = brandNameTagA != null ? UtilsFunc.getValueInTagHtml(brandNameTagA.toString()) : "";
				brand.setBrandName(brandName);
				if (brandNameTagA != null) {
					Element totalCompanyTagA = brandNameTagA.selectFirst("span");
					String totalStr = totalCompanyTagA.html().substring(1, totalCompanyTagA.html().length() - 1);
					Integer total = UtilsFunc.isNumeric(totalStr) ? Integer.parseInt(totalStr) : 0;
					brand.setTotal(total);
				}
				brandList.add(brand);
			}
		}

		return brandList;
	}

	@Override
	public List<String> getListUrlProductInAPage(Element element){
		List<String> listUrlProductDetail = new ArrayList<>();
		Element divContainer = element.selectFirst("div.product-box-list");
		Elements tagAList = divContainer.select("a");
		for(Element tagA: tagAList) {
			String url = UtilsFunc.getValueAttrTagHtml(tagA.toString(), "href");
			listUrlProductDetail.add(url);
		}
		return listUrlProductDetail;
	}

}
