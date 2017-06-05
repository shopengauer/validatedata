package com.pavlovens.validatedata.genericvalidator;

import javax.validation.ConstraintViolation;
import java.util.Set;

public interface EntityValidator<T> {

    Set<ConstraintViolation<T>> validate(T t);

    Set<ConstraintViolation<T>> validateGroup(T t, Class<?> ... clazz);

    Set<ConstraintViolation<T>> validateProperty(T t, String propName);


}
