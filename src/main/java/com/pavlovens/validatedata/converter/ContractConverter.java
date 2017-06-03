package com.pavlovens.validatedata.converter;

import com.pavlovens.validatedata.domain.CashManContract;
import com.pavlovens.validatedata.domain.PublishedContract;
import org.springframework.core.convert.converter.Converter;

import static com.pavlovens.validatedata.domain.ContractKeys.*;

public class ContractConverter implements Converter<PublishedContract,CashManContract> {

    @Override
    public CashManContract convert(PublishedContract publishedContract) {
        CashManContract contract = new CashManContract();
        System.out.println(publishedContract);
        System.out.println((Long)publishedContract.getDynamicParam(CM_AgreementId));
        contract.setAgreementId(null);
        contract.setOrgId((publishedContract.getDynamicParam(CM_OrgId)));
        contract.setOrgType(publishedContract.getDynamicParam(CM_OrgType));
        contract.setBankBIC(publishedContract.getDynamicParam(CM_BankBIC));
        contract.setBankCodeCom(publishedContract.getDynamicParam(CM_BankCodeCom));
        contract.setOrgAccountComNum(publishedContract.getDynamicParam(CM_OrgAccountComNum));
        return contract;
    }
}
