package com.pavlovens.validatedata.converter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConverterConfig {

    @Bean
    public ContractConverter contractConverter(){
        return new ContractConverter();
    }


    @Bean
    public ConversionServiceFactoryBean conversionService(){
        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<>();
        converters.add(contractConverter());
        factoryBean.setConverters(converters);
        return factoryBean;
    }




}
