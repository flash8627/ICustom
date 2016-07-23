package com.gwtjs.core.entity;

import java.math.BigDecimal;
import java.util.Date;

public class NavigationVO {
    private BigDecimal itemId;

    private String itemName;

    private BigDecimal parentId;

    private String icon;

    private String url;

    private BigDecimal orderCode;

    private BigDecimal createdUser;

    private Date createdDate;

    private BigDecimal updateLastUser;

    private Date updateLastDate;

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

    public BigDecimal getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(BigDecimal orderCode) {
        this.orderCode = orderCode;
    }

    public BigDecimal getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(BigDecimal createdUser) {
        this.createdUser = createdUser;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public BigDecimal getUpdateLastUser() {
        return updateLastUser;
    }

    public void setUpdateLastUser(BigDecimal updateLastUser) {
        this.updateLastUser = updateLastUser;
    }

    public Date getUpdateLastDate() {
        return updateLastDate;
    }

    public void setUpdateLastDate(Date updateLastDate) {
        this.updateLastDate = updateLastDate;
    }
}