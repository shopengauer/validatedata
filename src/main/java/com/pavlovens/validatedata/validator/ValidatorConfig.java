package com.pavlovens.validatedata.validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

@Configuration
public class ValidatorConfig {


   /*
    Другой вариант создания валидатора
    @Bean
    public Validator validator(){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        return validatorFactory.getValidator();
    }
   */


   @Bean
   public Validator validator(){
      return new LocalValidatorFactoryBean();
   }

   @Bean
   public ExecutableValidator executableValidator(){
       ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
       return validatorFactory.getValidator().forExecutables();
   }

   @Bean
   public MethodValidationPostProcessor methodValidationPostProcessor(){
       return new MethodValidationPostProcessor();
   }

}
