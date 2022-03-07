package postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author jiangyuanchu
 * @description todo
 * @data 2022/3/7 5:43 下午
 */
public class MyBeanFactoryPostProcesser implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("自定义BeanFactoryPostProcessor");
    }

}
