/**
 * 
 */
package Crawl;

import java.util.List;

import org.jsoup.nodes.Element;

import Model.DetailDescriptionProduct;
import Model.ObjectData;

/**
 * @author PhamVanLinh
 *
 */
public interface ProductDetailInforPage {
	
	String getUnitCurrency(Element element) throws Exception;
	/**
	 * 
	 * @param element
	 * @return
	 */
	DetailDescriptionProduct getProductDetail(Element element) throws Exception;

	/**
	 * 
	 * @param element
	 * @return
	 */
	List<String> getImageList(Element element) throws Exception;

	/**
	 * 
	 * @param element
	 * @return
	 */
	List<String> getDescriptionList(Element element) throws Exception;

	/**
	 * 
	 * @param element
	 * @return
	 */
	String getProductName(Element element) throws Exception;

	/**
	 * 
	 * @param element
	 * @return
	 */
	String getBrand(Element element) throws Exception;

	/**
	 * 
	 * @param element
	 * @return
	 */
	Long getPrice(Element element) throws Exception;

	/**
	 * 
	 * @param element
	 * @return
	 */
	String getSave(Element element) throws Exception;

	/**
	 * 
	 * @param element
	 * @return
	 */
	Long getMarketPrice(Element element) throws Exception;

	/**
	 * 
	 * @param element
	 * @return
	 */
	Integer getStar(Element element) throws Exception;

	/**
	 * 
	 * @param element
	 * @return
	 */
	Integer getVotes(Element element) throws Exception;

	/**
	 * 
	 * @param element
	 * @return
	 */
	Long getSKU(Element element) throws Exception;
	
	/**
	 * 
	 * @param element
	 * @return
	 */
	List<ObjectData> getAnotherData(Element element) throws Exception;
	
	/**
	 * 
	 * @param dom
	 * @return
	 */
	boolean checkIsRedirectPage(Element dom);
}
