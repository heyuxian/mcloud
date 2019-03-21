package me.javaroad.mcloud.common.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

@Component
public class SpringUtils implements BeanFactoryPostProcessor {

    private static ConfigurableListableBeanFactory beanFactory;

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
        throws BeansException {
        beanFactory = configurableListableBeanFactory;
    }

    public static <T> T getBean(String name, Class<T> clazz) throws BeansException {
        return beanFactory.getBean(name, clazz);
    }

}
