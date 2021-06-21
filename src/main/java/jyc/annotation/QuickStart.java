package jyc.annotation;

import jyc.utils.LeetCodeQuickStart;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Jiang_YuanChu
 * @see LeetCodeQuickStart
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface QuickStart {

    /**
     * This num {@code order} is sort value. If num is smaller, the method would prioritization of execution
     * @see LeetCodeQuickStart
     */
    int order() default 1;

}
