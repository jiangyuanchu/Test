package jyc.utils;

import jyc.annotation.QuickStart;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @see QuickStart
 */
@Slf4j
public class LeetCodeQuickStart {

    public static Object quickStart(Class clazz, Object... args) throws Exception{
        return quickStart(0, clazz, args);
    }

    public static Object quickStart(int index, Class clazz, Object... args) throws Exception{
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> list = new ArrayList<>();
        for(Method method : methods){
            if(method.getAnnotation(QuickStart.class) != null)
                list.add(method);
        }
        list.sort(Comparator.comparingInt(t -> t.getAnnotation(QuickStart.class).order()));
        Method firstMethod = list.get(index);
//        log.info("获取到方法 --> {}",firstMethod.getName());
        long start = System.nanoTime();
        Object obj = firstMethod.invoke(clazz.newInstance(), args);
        log.info("方法运行时间：{} ns", System.nanoTime() - start);
        return obj;
    }

}
