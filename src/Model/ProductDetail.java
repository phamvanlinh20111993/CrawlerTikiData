package Model;

import java.util.List;

public class ProductDetail {
	// Bộ 2 tạ nhựa tay 10kg
	private String productName;
	// Thương hiệu: MOMENT
	private String brand;
	// 98.000
	private Long price;
	// ₫
	private String unit;
	// Tiết kiệm: 39% (62.000đ)
	private String save;
	// 160.000
	private Long marketPrice;
	// SKU: 3334320765088
	private Long SKU;
	/**
	 * Chất liệu cao cấp, bền chắc
	 * 
	 * Thiết kế kiểu dáng hiện đại, hài hòa
	 * 
	 * Chất lượng và độ an toàn tuyệt đối
	 * 
	 * Sản phẩm tiện dụng, mang lại lợi ích tối đa cho người sử dụng
	 */
	private List<String> description;
	/**
	 * https://salt.tikicdn.com/cache/75x75/ts/product/72/fa/44/4875c37b5ae3083cce08e1f0662704f2.jpg
	 * https://salt.tikicdn.com/cache/75x75/ts/product/5d/93/29/816368959b5606c7f14126729e7adfd3.jpg
	 */
	private List<String> imageList;
	// width:85% đánh giá theo 5 sao
	private Double star;
	// 51 đánh giá
	private Integer votes;
	/**
	 * Giấy sợi tre Sipiao chiết xuất từ sợi tre, mềm, mịn, thấm nước tốt
	 * 
	 * Giấy dai, thấm nước không bị nát
	 * 
	 * Được làm từ bột trúc không có chất tẩy trắng nên an toàn khi sử dụng
	 * 
	 * Độ dai tự nhiên, có thể dùng thay khăn giấy ướt
	 * 
	 * Gói đóng 300 tờ/ 1 bịch nên sử dụng được rất lâu
	 */
	DetailDescriptionProduct detailProduct;
	/**
	 * Thương hiệu Soho 
	 * SKU 2026353258835 
	 * Sản xuất tại Việt Nam 
	 * Trọng lượng 7000
	 * Kích thước 70 x 39 x 12 cm
	 */
	List<ObjectData> anotherDetail;
	
	/**
	 * three field bellow using on get advance
	 */
	private String productTypeName;
    //Total product
    private Integer total;
    //nha sach kim dong
    private String categoryProductName;

	public ProductDetail() {

	}

	/**
	 * @param productName
	 * @param brand
	 * @param price
	 * @param unit
	 * @param save
	 * @param marketPrice
	 * @param sKU
	 * @param description
	 * @param imageList
	 * @param star
	 * @param votes
	 * @param detailProduct
	 */
	public ProductDetail(String productName, String brand, Long price, String unit, String save, Long marketPrice,
			Long sKU, List<String> description, List<String> imageList, Double star, Integer votes,
			DetailDescriptionProduct detailProduct, List<ObjectData> anotherDetail) {
		super();
		this.productName = productName;
		this.brand = brand;
		this.price = price;
		this.unit = unit;
		this.save = save;
		this.marketPrice = marketPrice;
		this.SKU = sKU;
		this.description = description;
		this.imageList = imageList;
		this.star = star;
		this.votes = votes;
		this.detailProduct = detailProduct;
		this.anotherDetail = anotherDetail;
	}

	/**
     * @param productName
     * @param brand
     * @param price
     * @param unit
     * @param save
     * @param marketPrice
     * @param sKU
     * @param description
     * @param imageList
     * @param star
     * @param votes
     * @param detailProduct
     * @param anotherDetail
     * @param productTypeName
     * @param total
     */
    public ProductDetail(String productName, String brand, Long price, String unit, String save,
            Long marketPrice, Long sKU, List<String> description, List<String> imageList, Double star,
            Integer votes, DetailDescriptionProduct detailProduct, List<ObjectData> anotherDetail,
            String productTypeName, Integer total, String categoryProductName) {
        super();
        this.productName = productName;
        this.brand = brand;
        this.price = price;
        this.unit = unit;
        this.save = save;
        this.marketPrice = marketPrice;
        this.SKU = sKU;
        this.description = description;
        this.imageList = imageList;
        this.star = star;
        this.votes = votes;
        this.detailProduct = detailProduct;
        this.anotherDetail = anotherDetail;
        this.productTypeName = productTypeName;
        this.total = total;
        this.categoryProductName = categoryProductName;
    }

    /**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * @param brand
	 *            the brand to set
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * @return the price
	 */
	public Long getPrice() {
		return price;
	}

	/**
	 * @param price
	 *            the price to set
	 */
	public void setPrice(Long price) {
		this.price = price;
	}

	/**
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit
	 *            the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return the save
	 */
	public String getSave() {
		return save;
	}

	/**
	 * @param save
	 *            the save to set
	 */
	public void setSave(String save) {
		this.save = save;
	}

	/**
	 * @return the marketPrice
	 */
	public Long getMarketPrice() {
		return marketPrice;
	}

	/**
	 * @param marketPrice
	 *            the marketPrice to set
	 */
	public void setMarketPrice(Long marketPrice) {
		this.marketPrice = marketPrice;
	}

	/**
	 * @return the sKU
	 */
	public Long getSKU() {
		return SKU;
	}

	/**
	 * @param sKU
	 *            the sKU to set
	 */
	public void setSKU(Long sKU) {
		SKU = sKU;
	}

	/**
	 * @return the description
	 */
	public List<String> getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(List<String> description) {
		this.description = description;
	}

	/**
	 * @return the imageList
	 */
	public List<String> getImageList() {
		return imageList;
	}

	/**
	 * @param imageList
	 *            the imageList to set
	 */
	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}

	/**
	 * @return the star
	 */
	public Double getStar() {
		return star;
	}

	/**
	 * @param star
	 *            the star to set
	 */
	public void setStar(Double star) {
		this.star = star;
	}

	/**
	 * @return the votes
	 */
	public Integer getVotes() {
		return votes;
	}

	/**
	 * @param votes
	 *            the votes to set
	 */
	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	/**
	 * @return the detailProduct
	 */
	public DetailDescriptionProduct getDetailProduct() {
		return detailProduct;
	}

	/**
	 * @param detailProduct
	 *            the detailProduct to set
	 */
	public void setDetailProduct(DetailDescriptionProduct detailProduct) {
		this.detailProduct = detailProduct;
	}

	/**
	 * @return the anotherDetail
	 */
	public List<ObjectData> getAnotherDetail() {
		return anotherDetail;
	}

	/**
	 * @param anotherDetail the anotherDetail to set
	 */
	public void setAnotherDetail(List<ObjectData> anotherDetail) {
		this.anotherDetail = anotherDetail;
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

    /* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ProductDetail [productName=" + productName + ", brand=" + brand + ", price=" + price + ", unit=" + unit
				+ ", save=" + save + ", marketPrice=" + marketPrice + ", SKU=" + SKU + ", description=" + description
				+ ", imageList=" + imageList + ", star=" + star + ", votes=" + votes + ", detailProduct="
				+ detailProduct + ", anotherDetail=" + anotherDetail + "]";
	}
	
}
