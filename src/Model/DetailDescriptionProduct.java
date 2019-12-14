package Model;

import java.util.ArrayList;
import java.util.List;

public class DetailDescriptionProduct {
	// storage plain html required
	private String descriptionHtml;
	// required just replace html tag
	private String description;
	// optional
	List<String> storageInformation;

	public DetailDescriptionProduct() {
	    storageInformation = new ArrayList<String>();
	}

	/**
	 * @param descriptionHtml
	 * @param description
	 * @param title
	 * @param imageAva
	 */
	public DetailDescriptionProduct(String descriptionHtml, String description, List<String> storageInformation) {
		super();
		this.descriptionHtml = descriptionHtml;
		this.description = description;
		this.storageInformation = storageInformation;
	}

	/**
	 * @return the descriptionHtml
	 */
	public String getDescriptionHtml() {
		return descriptionHtml;
	}

	/**
	 * @param descriptionHtml
	 *            the descriptionHtml to set
	 */
	public void setDescriptionHtml(String descriptionHtml) {
		this.descriptionHtml = descriptionHtml;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the storageInformation
	 */
	public List<String> getStorageInformation() {
		return storageInformation;
	}

	/**
	 * @param storageInformation
	 *            the storageInformation to set
	 */
	public void setStorageInformation(List<String> storageInformation) {
		this.storageInformation = storageInformation;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DetailDescriptionProduct [descriptionHtml=" + descriptionHtml + ", description=" + description
				+ ", storageInformation=" + storageInformation + "]";
	}
	
}
