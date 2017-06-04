package com.pavlovens.validatedata.validator;

import com.pavlovens.validatedata.domain.CashManContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class ContractValidationService {


    @Qualifier("validator")
    @Autowired
    private Validator validator;

    public Set<ConstraintViolation<CashManContract>> validateContract(CashManContract cashManContract){
        return validator.validate(cashManContract);
    }

    public Set<ConstraintViolation<CashManContract>> validateContractProperty(CashManContract cashManContract,String property){
        return validator.validateProperty(cashManContract,property);
    }

    public Set<ConstraintViolation<CashManContract>> validateContractValue(String property,Object value){
        return validator.validateValue(CashManContract.class,property,value);
    }



}
