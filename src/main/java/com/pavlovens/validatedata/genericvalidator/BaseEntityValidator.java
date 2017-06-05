package com.pavlovens.validatedata.genericvalidator;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public class BaseEntityValidator<T> implements EntityValidator<T> {

    protected final Validator validator;

    public BaseEntityValidator(Validator validator) {
        this.validator = validator;
    }

    @Override
    public Set<ConstraintViolation<T>> validate(T t) {
        return validator.validate(t);
    }

    @Override
    public Set<ConstraintViolation<T>> validateGroup(T t, Class<?>... clazz) {
        return validator.validate(t,clazz);
    }

    @Override
    public Set<ConstraintViolation<T>> validateProperty(T t, String propName) {
        return validator.validateProperty(t,propName);
    }
}
