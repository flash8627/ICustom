package com.gwtjs.international.entity;

import java.math.BigDecimal;

import com.gwtjs.common.entity.BaseResource;

public class LanguageVO extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 36316418868787090L;

	private BigDecimal itemId;

	private String itemName;

	private BigDecimal parentId;

	private String icon;

	private String url;

	private Short resourceType;

	public BigDecimal getItemId() {
		return itemId;
	}

	public void setItemId(BigDecimal itemId) {
		this.itemId = itemId;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName == null ? null : itemName.trim();
	}

	public BigDecimal getParentId() {
		return parentId;
	}

	public void setParentId(BigDecimal parentId) {
		this.parentId = parentId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon == null ? null : icon.trim();
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url == null ? null : url.trim();
	}

	public Short getResourceType() {
		return resourceType;
	}

	public void setResourceType(Short resourceType) {
		this.resourceType = resourceType;
	}
}