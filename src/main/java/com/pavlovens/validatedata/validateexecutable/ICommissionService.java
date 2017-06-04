package com.pavlovens.validatedata.validateexecutable;


import com.pavlovens.validatedata.domain.CashManContract;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Validated// add AOP interceptor to the methods with validator annotation
public interface ICommissionService {

   @NotNull(message = "Возвращаемая комиссиия null")
   String checkForCommission(@NotNull(message = "Котракт для расчета null") @Valid CashManContract contract);

   void checkCashManContract(@Valid CashManContract contract);


}
