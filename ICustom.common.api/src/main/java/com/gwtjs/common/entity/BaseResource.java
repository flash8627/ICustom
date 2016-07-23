package com.gwtjs.common.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统基础属性
 * 
 * @author aGuang
 *
 */
public class BaseResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5402317918334633979L;
	private long createdUser;
	private Date createdDate;
	private String nameCn;

	private long updateLastUser;
	private Date updateLastDate;
	private String lastNameCn;
	private String language;

	private int orderCode;

	public BaseResource() {
		super();
	}

	public BaseResource(long createdUser, Date createdDate,
			long updateLastUser, Date updateLastDate, String language,
			int orderCode) {
		super();
		this.createdUser = createdUser;
		this.createdDate = createdDate;
		this.updateLastUser = updateLastUser;
		this.updateLastDate = updateLastDate;
		this.language = language;
		this.orderCode = orderCode;
	}

	public long getCreatedUser() {
		return createdUser;
	}

	public void setCreatedUser(long createdUser) {
		this.createdUser = createdUser;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public long getUpdateLastUser() {
		return updateLastUser;
	}

	public void setUpdateLastUser(long updateLastUser) {
		this.updateLastUser = updateLastUser;
	}

	public Date getUpdateLastDate() {
		return updateLastDate;
	}

	public void setUpdateLastDate(Date updateLastDate) {
		this.updateLastDate = updateLastDate;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public String getNameCn() {
		return nameCn;
	}

	public void setNameCn(String nameCn) {
		this.nameCn = nameCn;
	}

	public String getLastNameCn() {
		return lastNameCn;
	}

	public void setLastNameCn(String lastNameCn) {
		this.lastNameCn = lastNameCn;
	}

}
