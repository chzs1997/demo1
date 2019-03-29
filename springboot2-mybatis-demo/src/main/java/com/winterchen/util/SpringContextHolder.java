package com.winterchen.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @Author: liuzipan
 * @Description
 * @Date :17:50 2019/3/2
 * @Modefied By:
 */

public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        SpringContextHolder.applicationContext = context;
    }

    /**
     * @Auther: fanxuebo
     * @Description: 获取 ApplicationContext 容器
     */
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    /**
     * @Auther: fanxuebo
     * @Description: 获取 bean
     */
    public static Object getBean(String name) {
        return applicationContext.getBean (name);
    }

}
