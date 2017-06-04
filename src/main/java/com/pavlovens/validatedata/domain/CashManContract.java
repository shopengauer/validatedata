package com.pavlovens.validatedata.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

public class CashManContract {


    @NotNull
    private Long agreementId;

    @NotNull
    private Long orgId;

    @NotEmpty
    private String orgType;

    private String orgAccountComNum;
    private String bankCodeCom;
    private String bankBIC;

    public CashManContract() {
    }

    public Long getAgreementId() {
        return agreementId;
    }

    public void setAgreementId(Long agreementId) {
        this.agreementId = agreementId;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
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
