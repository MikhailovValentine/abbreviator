package ru.urlshortening.abbreviator.service.qualifier;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Qualifier
@Target({ElementType.FIELD,
        ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface StorageTypeQualifier {
    Type value();

    enum Type {
        IN_MRMORY,
        RELATIONAL_DATABASE,
        KEY_VALUE_STORAGE
    }
}
