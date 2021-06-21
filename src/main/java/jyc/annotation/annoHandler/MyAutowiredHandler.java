package jyc.annotation.annoHandler;

import jyc.annotation.annoHandler.BaseAnnotationHandler;
import jyc.utils.StringUtils;
import jyc.ioc.BeanFactory;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;

@Slf4j
public class MyAutowiredHandler implements BaseAnnotationHandler {

    Field field = null;

    @Override
    public <T> void run(T annotationLocation, String className, Object... param) {
        field = (Field)annotationLocation;
        log.info("字段名称{}",field.getName());
        BeanFactory beanFactory = BeanFactory.getBeanFactory();
        try {
            field.setAccessible(true);
            StringUtils stringUtils = new StringUtils();
            field.set(beanFactory.getBean(stringUtils.classNameToBeanName(className)), beanFactory.getBean(field.getName()));
            System.out.println("设置"+beanFactory.getBean(stringUtils.classNameToBeanName(className)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
