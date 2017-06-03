package com.pavlovens.validatedata.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class CashManContract {


    @NotNull
    private long agreementId;

    @NotNull
    private long orgId;

    @NotEmpty
    private String orgType;

    private String orgAccountComNum;
    private String bankCodeCom;
    private String bankBIC;

    public CashManContract() {
    }

    public long getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(long agreementId) {
        this.agreementId = agreementId;
    }

    public long getOrgId() {
        return orgId;
    }

    public void setOrgId(long orgId) {
        this.orgId = orgId;
    }

    public String getOrgType() {
        return orgType;
    }

    public void setOrgType(String orgType) {
        this.orgType = orgType;
    }

    public String getOrgAccountComNum() {
        return orgAccountComNum;
    }

    public void setOrgAccountComNum(String orgAccountComNum) {
        this.orgAccountComNum = orgAccountComNum;
    }

    public String getBankCodeCom() {
        return bankCodeCom;
    }

    public void setBankCodeCom(String bankCodeCom) {
        this.bankCodeCom = bankCodeCom;
    }

    public String getBankBIC() {
        return bankBIC;
    }

    public void setBankBIC(String bankBIC) {
        this.bankBIC = bankBIC;
    }
}
