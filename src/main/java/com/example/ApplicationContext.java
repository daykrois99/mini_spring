package com.example;

import java.util.List;

public class ApplicationContext {

    public ApplicationContext(String packageName) {
        initContext(packageName);
    }


    public void initContext(String packageName) {
        List<Class<?>> componentClassList = scanPackage(packageName).stream().filter(c -> c.isAnnotationPresent(Component.class)).toList();
    }

    public List<Class<?>> scanPackage(String packageName) {
        return null;
    }

    public Object getBean(String beanName) {
        return null;

    }

    public <T> T getBean(Class<T> beanType) {
        return null;

    }

    public <T> List<T> getBeans(Class<T> beanType) {
        return null;
    }
}
