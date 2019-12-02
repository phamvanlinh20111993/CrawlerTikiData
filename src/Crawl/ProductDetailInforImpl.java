package Crawl;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Model.DetailDescriptionProduct;
import Model.ObjectData;
import Utils.UtilsFunc;

public class ProductDetailInforImpl implements ProductDetailInforPage {
	
	@Override
	public DetailDescriptionProduct getProductDetail(Element element) {
		DetailDescriptionProduct desProduct = new DetailDescriptionProduct();
		Element getProductDetail = element.selectFirst("div#gioi-thieu");
		desProduct.setDescriptionHtml(getProductDetail.toString());
		
		String replaceTask = UtilsFunc.replaceTagHtmlByString(getProductDetail.toString());
		desProduct.setDescription(replaceTask);
		
		List<String> listText = UtilsFunc.getTextInformationInTagHtml(getProductDetail.toString());
		desProduct.setStorageInformation(listText);
		
		return desProduct;
	}

	@Override
	public List<String> getImageList(Element element) {
		List<String> response = new ArrayList<String>();
		Element getContainerImageList = element.selectFirst("div.product-feature-images.vertical");
		Elements ImageList = getContainerImageList.select("img.lazy");
		for (Element image : ImageList) {
			String url = image.absUrl("src");
			response.add(url);
		}
		return response;
	}

	@Override
	public List<String> getDescriptionList(Element element){
		List<String> descriptionList = new ArrayList<>();
		Element getDivContainerDesList = element.selectFirst("div.top-feature-item.bullet-wrap");
		if(getDivContainerDesList != null) {
			Elements getAllDes = getDivContainerDesList.select("p");
			for (Element eachDes : getAllDes) {
				String des = UtilsFunc.getValueInTagHtml(eachDes.toString());
				descriptionList.add(des);
			}
		}
		return descriptionList;
	}

	@Override
	public String getProductName(Element element){
	    Element divContain = element.selectFirst("div.product-customer-col-5.js-customer-col-5");
	    divContain = divContain == null ? element : divContain;
		Element divContainProductName = divContain.selectFirst("div.product-detail");
		Element divContainProductNameNext = divContainProductName.selectFirst("div.info");
		Element productNameElement = divContainProductNameNext.selectFirst("div.title");
		return productNameElement != null ? UtilsFunc.getValueInTagHtml(productNameElement.toString()) : "";
	}

	@Override
	public String getBrand(Element element){
		element = element.selectFirst("div.product-brand-block");
		Element getDivContainerBrand = element.selectFirst("div.item-brand");
		Element brandTag = null;
		if(getDivContainerBrand != null) {
    		Element getPTagBrand = getDivContainerBrand.selectFirst("p");
    		if(getPTagBrand != null) {
    		    brandTag = getPTagBrand.selectFirst("a");
    		}
		}
		return UtilsFunc.getValueInTagHtml(brandTag != null ? brandTag.toString() : "");
	}

	@Override
	public Long getPrice(Element element){
		element = element.selectFirst("p#p-specialprice");
		Element priceStr = null;
		if(element != null) {
			priceStr = element.selectFirst("span#span-price");
		}
		Double price = UtilsFunc.convertCurrencyToNumber(priceStr != null ? priceStr.toString() : "");
		return price.longValue();
	}

	@Override
	public String getSave(Element element){
		element = element.selectFirst("p#p-saving-price");
		Element saving = null;
		if(element != null) {
			saving = element.selectFirst("span#span-discount-percent");
		}
		return saving != null ? UtilsFunc.getValueInTagHtml(saving.toString()) : "0%";
	}

	@Override
	public Long getMarketPrice(Element element){
		element = element.selectFirst("p#p-listpirce");
		Element marketPriceStr = null;
		if(element != null) {
			marketPriceStr = element.selectFirst("span#span-list-price");
		}
		Double price = UtilsFunc.convertCurrencyToNumber(marketPriceStr != null ? marketPriceStr.toString() : "");
		return price.longValue();
	}

	@Override
	public Integer getStar(Element element){
		element = element.selectFirst("div.product-brand-block");
		Element getDivContainerStarNext = null;
		if(element != null) {
		    Element getDivContainerStar = element.selectFirst("div.item-other");
            getDivContainerStarNext = getDivContainerStar == null ? new Element("p")
                    : getDivContainerStar.selectFirst("div");
		}
		
		String star = UtilsFunc.getValueAttrTagHtml(getDivContainerStarNext.select("meta").first().toString(),
				"content");
		;
		Integer starNum = UtilsFunc.isNumeric(star) ? (int)(Double.parseDouble(star)*10) : 0;
		return starNum;
	}

	@Override
	public Integer getVotes(Element element){
		element = element.selectFirst("div.product-brand-block");
		Elements metaTag = null;
        Element getDivContainerVote = element.selectFirst("div.item-other") == null ? new Element("p")
                : element.selectFirst("div.item-other");
		if(getDivContainerVote != null) {
		    Element getDivContainerVoteNext = getDivContainerVote.selectFirst("div");
	        metaTag = getDivContainerVoteNext.select("meta");
		}
		
		String vote = UtilsFunc.getValueAttrTagHtml(metaTag.size() > 0 ? metaTag.get(1).toString() : null, "content");

		Integer starNum = UtilsFunc.isNumeric(vote) ? Integer.parseInt(vote) : 0;
		return starNum;
	}

	@Override
	public Long getSKU(Element element){
		element = element.selectFirst("div.product-brand-block");
		Element getDivContainerSKU = element.selectFirst("div#product-sku");
		Element getPTagSKU = getDivContainerSKU.selectFirst("p");
		String skuStr = UtilsFunc.getValueInTagHtml(getPTagSKU != null ? getPTagSKU.toString() : "");

		return UtilsFunc.isNumeric(skuStr) ? Long.parseLong(skuStr) : 0L;
	}
	
	@Override
	public String getUnitCurrency(Element element){
		Element getDivContainerUnit = element.selectFirst("div.price-block.show-border");
		String unit = "VND";
		if(getDivContainerUnit != null) {
			Elements getMetaTagUnit = getDivContainerUnit.select("meta");
			if (getMetaTagUnit != null && getMetaTagUnit.size() > 0) {
				unit = UtilsFunc.getValueAttrTagHtmlNotStart(getMetaTagUnit.get(0).toString(), "content");
			}
		}
		return unit;
	}

	@Override
	public List<ObjectData> getAnotherData(Element element){
		List<ObjectData> anotherDataList = new ArrayList<>();
		Element divContainer = element.selectFirst("table#chi-tiet");
		List<String> listText = UtilsFunc.getTextInformationInTagHtml(divContainer.toString());
		for(int index = 0; index < listText.size()-1; index += 2) {
			anotherDataList.add(new ObjectData(listText.get(index), listText.get(index+1)));
		}
		return anotherDataList;
	}
	
}
