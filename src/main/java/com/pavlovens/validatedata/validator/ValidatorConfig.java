package com.pavlovens.validatedata.validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

@Configuration
public class ValidatorConfig {

   @Bean
   public Validator validator(){
       ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
       return validatorFactory.getValidator();
   }

   @Bean
   public ExecutableValidator executableValidator(){
       ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
       return validatorFactory.getValidator().forExecutables();
   }

}
