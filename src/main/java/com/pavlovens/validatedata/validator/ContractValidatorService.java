package com.pavlovens.validatedata.validator;

import com.pavlovens.validatedata.domain.CashManContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Service
public class ContractValidatorService {


    @Qualifier("validator")
    @Autowired
    private Validator validator;

    public Set<ConstraintViolation<CashManContract>> validate(CashManContract cashManContract){
        return validator.validate(cashManContract);
    }

}
