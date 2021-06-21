package jyc.ioc;

import jyc.aop.ProxyFactory;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class BeanFactory implements BeanBase{

    //实例对象管理者
    private static final ConcurrentHashMap<String, Object> beanMap = new ConcurrentHashMap<>();

    //对象定义与内容管理者
    private static final ConcurrentHashMap<String, XmlEntity> undefineMap = new ConcurrentHashMap<>();

    //对象清单
    private static final Set<Object> beanNameSet = Collections.synchronizedSet(new HashSet<Object>());

    ProxyFactory proxyFactory = new ProxyFactory();

    public static BeanFactory beanFactory = null;

    public static BeanFactory getBeanFactory(){
        synchronized (BeanFactory.class){
            if(beanFactory == null){
                synchronized (BeanFactory.class){
                    beanFactory = new XmlHandler("BeanApplication.xml");
                }
            }
        }
        return beanFactory;
    }

    @Override
    public Object getBean(String name) throws IllegalAccessException {
        Object bean = null;
        if(!beanNameSet.contains(name)){
            log.error("{}管理对象不在bean管理范围内", name);
            throw new IllegalAccessException();
        }
        //尝试获取对象实例
        bean = beanMap.get(name);
        if(bean != null){
            return bean;
        }
        bean = createBean(name);

        return bean;
    }

    private Object createBean(String name){
        Object object = null;
        try {
            Class clazz = Class.forName(undefineMap.get(name).getClassName());
//            System.out.println("实例创建"+Class.forName(undefineMap.get(name).getClassName()).newInstance());
            //加入代理
//            object = proxyFactory.getProxyInstance(clazz);
            object = clazz.newInstance();
            beanMap.put(name, object);
        } catch (Exception e){
            log.error("{}实例化失败", name);
            e.printStackTrace();
        }
        return object;

    }

    protected void registerBean(String name, XmlEntity xmlEntity){
        //将对象注册进定义与内容管理者
        undefineMap.put(name, xmlEntity);
        //加入对象清单
        beanNameSet.add(name);
    }
}
