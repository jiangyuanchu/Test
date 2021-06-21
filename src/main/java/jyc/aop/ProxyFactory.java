package jyc.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public <T extends LeetCodeBase> T getProxyInstance(Class instance) throws Exception{
        T t = (T)instance.newInstance();
        InvocationHandler handler = new LeetCodeHandler(t);
        T proxy = (T)Proxy.newProxyInstance(handler.getClass().getClassLoader(), t.getClass().getInterfaces(), handler);
        return proxy;
    }



}
