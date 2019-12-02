package Model;

import java.util.List;

public class CategoryProduct {
	// Nhà sách tiki
	private String categoryProductName;
	// Nhà xuất bản kim đồng (123123)
	List<Brand> brandList;
	// English Books
	List<ProductType> productTypeList;

	public CategoryProduct() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param categoryProductName
	 * @param brandList
	 * @param productTypeList
	 */
	public CategoryProduct(String categoryProductName, List<Brand> brandList, List<ProductType> productTypeList) {
		super();
		this.categoryProductName = categoryProductName;
		this.brandList = brandList;
		this.productTypeList = productTypeList;
	}

	/**
	 * @return the categoryProductName
	 */
	public String getCategoryProductName() {
		return categoryProductName;
	}

	/**
	 * @param categoryProductName the categoryProductName to set
	 */
	public void setCategoryProductName(String categoryProductName) {
		this.categoryProductName = categoryProductName;
	}

	/**
	 * @return the brandList
	 */
	public List<Brand> getBrandList() {
		return brandList;
	}

	/**
	 * @param brandList the brandList to set
	 */
	public void setBrandList(List<Brand> brandList) {
		this.brandList = brandList;
	}

	/**
	 * @return the productTypeList
	 */
	public List<ProductType> getProductTypeList() {
		return productTypeList;
	}

	/**
	 * @param productTypeList the productTypeList to set
	 */
	public void setProductTypeList(List<ProductType> productTypeList) {
		this.productTypeList = productTypeList;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CategoryProduct [categoryProductName=" + categoryProductName + ", brandList=" + brandList
				+ ", productTypeList=" + productTypeList + "]";
	}
	
	
}
