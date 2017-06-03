package com.pavlovens.validatedata.converter;

import com.pavlovens.validatedata.domain.CashManContract;
import com.pavlovens.validatedata.domain.PublishedContract;
import org.springframework.core.convert.converter.Converter;

import static com.pavlovens.validatedata.domain.ContractKeys.*;

public class ContractConverter implements Converter<PublishedContract,CashManContract> {

    @Override
    public CashManContract convert(PublishedContract publishedContract) {
        CashManContract contract = new CashManContract();
        contract.setAgreementId((Long) publishedContract.getDynamicParams().get(CM_AgreementId.name()));
        contract.setOrgId((Long) publishedContract.getDynamicParams().get(CM_OrgId.name()));
        contract.setOrgType((String) publishedContract.getDynamicParams().get(CM_OrgType.name()));
        contract.setBankBIC((String) publishedContract.getDynamicParams().get(CM_BankBIC.name()));
        contract.setBankCodeCom((String) publishedContract.getDynamicParams().get(CM_BankCodeCom.name()));
        contract.setOrgAccountComNum((String) publishedContract.getDynamicParams().get(CM_OrgAccountComNum.name()));
        return contract;
    }
}
