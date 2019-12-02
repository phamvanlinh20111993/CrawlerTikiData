package Model;

public class TikiData {
	
	private String name;
	
	private CategoryProduct categoryProduct;
	
	private String icon;
	
	public TikiData() {}

	/**
	 * @param name
	 * @param categoryProduct
	 * @param icon
	 */
	public TikiData(String name, CategoryProduct categoryProduct, String icon) {
		super();
		this.name = name;
		this.categoryProduct = categoryProduct;
		this.icon = icon;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the categoryProduct
	 */
	public CategoryProduct getCategoryProduct() {
		return categoryProduct;
	}

	/**
	 * @param categoryProduct the categoryProduct to set
	 */
	public void setCategoryProduct(CategoryProduct categoryProduct) {
		this.categoryProduct = categoryProduct;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TikiData [name=" + name + ", categoryProduct=" + categoryProduct + ", icon=" + icon + "]";
	}
	
}
