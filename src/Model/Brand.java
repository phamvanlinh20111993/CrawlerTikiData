package Model;

public class Brand {
	// COMIX
	private String brandName;
	// 245
	private Integer total;
	
	public Brand() {
		
	}

	/**
	 * @param brandName
	 * @param total
	 */
	public Brand(String brandName, Integer total) {
		super();
		this.brandName = brandName;
		this.total = total;
	}



	/**
	 * @return the brandName
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * @param brandName the brandName to set
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Brand [brandName=" + brandName + ", total=" + total + "]";
	}

}
