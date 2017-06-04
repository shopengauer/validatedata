package com.pavlovens.validatedata.validateexecutable;


import com.pavlovens.validatedata.domain.CashManContract;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Validated
public interface ICommissionService {

   @NotNull(message = "Возвращаемая комиссиия null")
   String checkForCommission(@NotNull(message = "Котракт для расчета null") CashManContract contract);


}
