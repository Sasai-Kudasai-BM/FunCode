package net.skds.jvk.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.FIELD, ElementType.PARAMETER})
public @interface NativeType {

	String value();
}
