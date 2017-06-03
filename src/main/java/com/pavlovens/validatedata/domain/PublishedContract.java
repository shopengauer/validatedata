package com.pavlovens.validatedata.domain;

import java.util.Map;

public class PublishedContract {

    private long id;
    private Map<String,Object> dynamicParams;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Map<String, Object> getDynamicParams() {
        return dynamicParams;
    }

    public void setDynamicParams(Map<String, Object> dynamicParams) {
        this.dynamicParams = dynamicParams;
    }
}
