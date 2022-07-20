package com.kunminx.aptannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Create by KunMinX at 2022/7/20
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface KeyValueGroup {
}
