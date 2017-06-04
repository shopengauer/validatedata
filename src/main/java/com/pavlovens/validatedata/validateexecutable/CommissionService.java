package com.pavlovens.validatedata.validateexecutable;

import com.pavlovens.validatedata.domain.CashManContract;
import org.springframework.stereotype.Service;

@Service
public class CommissionService implements ICommissionService{

    @Override
    public String checkForCommission(CashManContract contract) {
        return null;
    }

    @Override
    public void checkCashManContract(CashManContract contract) {
        System.out.println("In method checkCashManContract");
    }
}
