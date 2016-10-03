package com.gwtjs.icustom.entity;

import java.util.Date;

import com.gwtjs.common.entity.BaseResource;

/**
 * 系统用户
 * @author aGuang
 *
 */
public class SysUserVO extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2593524274770477308L;
	
	private long userId;

    private String userAccount;

    private String userName;

    private String userPassword;

    private String userDesc;

    private Date validityStartDate;

    private Date validityEndDate;

    private long createdUser;

    private Date createdDate;

    private long updateLastUser;

    private Date updateLastDate;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserDesc() {
        return userDesc;
    }

    public void setUserDesc(String userDesc) {
        this.userDesc = userDesc == null ? null : userDesc.trim();
    }

    public Date getValidityStartDate() {
        return validityStartDate;
    }

    public void setValidityStartDate(Date validityStartDate) {
        this.validityStartDate = validityStartDate;
    }

    public Date getValidityEndDate() {
        return validityEndDate;
    }

    public void setValidityEndDate(Date validityEndDate) {
        this.validityEndDate = validityEndDate;
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
	
}
