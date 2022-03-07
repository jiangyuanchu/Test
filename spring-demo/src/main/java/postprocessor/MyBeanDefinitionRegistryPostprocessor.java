package postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.core.Ordered;

/**
 * @author jiangyuanchu
 * @description todo
 * @data 2022/3/7 5:46 下午
 */
public class MyBeanDefinitionRegistryPostprocessor implements BeanDefinitionRegistryPostProcessor{
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        System.out.println("自定义BeanDefinitionRegistryPostprocessor postProcessBeanDefinitionRegistry");
        BeanDefinition customer = registry.getBeanDefinition("customer");
        String beanClassName = customer.getBeanClassName();
        System.out.println(beanClassName);
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("自定义BeanDefinitionRegistryPostprocessor postProcessBeanFactory");
    }

}
