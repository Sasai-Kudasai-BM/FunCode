package net.skds.jvk.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.METHOD, ElementType.TYPE_PARAMETER, ElementType.FIELD, ElementType.PARAMETER})
public @interface NativeType {

	String value();
}
