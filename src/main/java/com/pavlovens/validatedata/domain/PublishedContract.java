package com.pavlovens.validatedata.domain;

import java.util.HashMap;
import java.util.Map;

public class PublishedContract {

    private final Map<String,Object> dynamicParams = new HashMap<>();

    @SuppressWarnings("unchecked")
    public <T> T getDynamicParam(ContractKeys key) {
        return (T) dynamicParams.get(key.name());
    }

    public void setDynamicParam(ContractKeys key, Object value) {
        dynamicParams.put(key.name(),value);
    }
}
