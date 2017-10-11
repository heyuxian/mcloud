package me.javaroad.common.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author heyx
 */
public class SpringUtils implements BeanFactoryPostProcessor {
    private static ConfigurableListableBeanFactory beanFactory;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
        throws BeansException {
        beanFactory = configurableListableBeanFactory;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(String name) throws BeansException {
        return (T) beanFactory.getBean(name);
    }

}
