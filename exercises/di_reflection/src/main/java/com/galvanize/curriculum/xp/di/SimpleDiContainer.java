package com.galvanize.curriculum.xp.di;

import javax.inject.Inject;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class SimpleDiContainer {

    private Object[] dependencies;

    public SimpleDiContainer(Object... dependencies) {
        this.dependencies = dependencies;
    }

    public <T> T getBean(Class<T> beanType) {
        try {
            T instance = beanType.newInstance();
            injectDependencies(instance);
            return instance;
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void injectDependencies(Object instance) throws Exception {
        for (Field field : instance.getClass().getDeclaredFields()) {
            for (Annotation annotation : field.getAnnotations()) {
                if (annotation instanceof Inject) {
                    field.setAccessible(true);
                    field.set(instance, getDependencyOfType(field.getType()));
                }
            }
        }
    }

    private Object getDependencyOfType(Class<?> type) throws Exception {
        for (Object dependency : dependencies) {
            if (type.isAssignableFrom(dependency.getClass())) {
                return dependency;
            }
        }
        throw new ClassNotFoundException("No dependency found for class: " + type);
    }
}
