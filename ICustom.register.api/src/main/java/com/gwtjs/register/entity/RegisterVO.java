package com.gwtjs.register.entity;

import java.math.BigDecimal;

import com.gwtjs.common.entity.BaseResource;

public class RegisterVO  extends BaseResource{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal regId;

    private String regName;

    private String regCode;

    private String regDesc;

    private BigDecimal parentId;

    private Short validFlag;

    public BigDecimal getRegId() {
        return regId;
    }

    public void setRegId(BigDecimal regId) {
        this.regId = regId;
    }

    public String getRegName() {
        return regName;
    }

    public void setRegName(String regName) {
        this.regName = regName == null ? null : regName.trim();
    }

    public String getRegCode() {
        return regCode;
    }

    public void setRegCode(String regCode) {
        this.regCode = regCode == null ? null : regCode.trim();
    }

    public String getRegDesc() {
        return regDesc;
    }

    public void setRegDesc(String regDesc) {
        this.regDesc = regDesc == null ? null : regDesc.trim();
    }

    public BigDecimal getParentId() {
        return parentId;
    }

    public void setParentId(BigDecimal parentId) {
        this.parentId = parentId;
    }

    public Short getValidFlag() {
        return validFlag;
    }

    public void setValidFlag(Short validFlag) {
        this.validFlag = validFlag;
    }
}
