package jyc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@AnnotationAutoScan("jyc.annotation.annoHandler.MyAutowiredHandler")
public @interface MyAutowired {
}
