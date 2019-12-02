package Model;

import java.util.ArrayList;

public class ProductType {
	//Điện Thoại SmartPhone
	private String productTypeName;
	//Total product
	private Integer total;
	// Lò Nướng Điện Sunhouse SHD4206 (10L) - Hàng chính hãng
	private ArrayList<ProductDetail> productList;

	public ProductType() {
		
	}

	/**
	 * @param productTypeName
	 * @param total
	 * @param productList
	 */
	public ProductType(String productTypeName, Integer total, ArrayList<ProductDetail> productList) {
		super();
		this.productTypeName = productTypeName;
		this.total = total;
		this.productList = productList;
	}

	/**
	 * @return the productTypeName
	 */
	public String getProductTypeName() {
		return productTypeName;
	}

	/**
	 * @param productTypeName the productTypeName to set
	 */
	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

	/**
	 * @return the productList
	 */
	public ArrayList<ProductDetail> getProductList() {
		return productList;
	}

	/**
	 * @param productList the productList to set
	 */
	public void setProductList(ArrayList<ProductDetail> productList) {
		this.productList = productList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductType [productTypeName=" + productTypeName + ", total=" + total + ", productList=" + productList
				+ "]";
	}
}
