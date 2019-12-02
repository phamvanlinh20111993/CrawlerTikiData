package Crawl;

import java.util.List;

import org.jsoup.nodes.Element;

import Model.Brand;
import Model.CategoryProduct;
import Model.ObjectData;

public interface CatalogAndProductType {
	
	/**
	 * 
	 * @param element
	 * @return
	 */
	public List<ObjectData> getTikiData(Element element) throws Exception;
	/**
	 * 
	 * @param element
	 * @return
	 */
	CategoryProduct getCategoryProduct(Element element) throws Exception;
	
	/**
	 * 
	 * @param element
	 * @return
	 */
	List<ObjectData> getProductType(Element element) throws Exception;
	
	/**
	 * 
	 * @param element
	 * @return
	 */
	List<Brand> getBrandEachProductType(Element element) throws Exception;
	/**
	 * 
	 * @param element
	 * @return
	 */
	List<String> getListUrlProductInAPage(Element element) throws Exception;
}
