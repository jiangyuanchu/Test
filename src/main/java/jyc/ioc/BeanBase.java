package jyc.ioc;

public interface BeanBase {

    /**
     * 根据类名获取对象实例信息
     * @param name
     * @return
     * @throws IllegalAccessException
     */
    Object getBean(String name) throws IllegalAccessException;

}
