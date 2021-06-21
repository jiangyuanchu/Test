package jyc.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LeetCodeHandler implements InvocationHandler {

    private Object object;

    public LeetCodeHandler(){}

    public LeetCodeHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理类执行前");
        Object invoke = method.invoke(object, args);
        System.out.println("代理类执行后");
        return invoke;
    }
}
