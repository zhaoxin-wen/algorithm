package com.example.practice.circualdependencies.demo5;

import org.springframework.beans.factory.ObjectFactory;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wzw
 * @date 2025/4/24 14:43
 * @description

 */
public class Cycle {
    // 单例池，里面放的是完整的bean，已完成填充属性
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    // 存放的是 加工bean的工厂方法
    private final Map<String, ObjectFactory<?>> singletonFactories = new HashMap<>();

    // 存放的是提前暴露出来的bean，没有经历过spring完整的生命周期，没有填充属性
    private final Map<String, Object> earlySingletonObjects = new HashMap<>();

    private final Set<String> singletonsCurrentlyInCreation = new HashSet<>();

    static Map<String, Class<?>> map = new HashMap<>();

    static {
        map.put("orderService", OrderService.class);
        map.put("userService", UserService.class);
    }

    public void init() {
        for (Map.Entry<String, Class<?>> stringClassEntry : map.entrySet()) {
            createBean(stringClassEntry.getKey());
        }
    }

    private Object createBean(String beanName) {
        Object instance = null;
        try {
            instance = map.get(beanName).getConstructor().newInstance();
        } catch (Exception ex) {
        }

        Object finalInstance = instance;
        this.singletonFactories.put(beanName, () -> {
            // 创建代理对象
            return finalInstance;
        });

        populateBean(instance);

        this.singletonObjects.put(beanName, instance);
        return instance;
    }

    public Object getBean(String beanName) {
        // 尝试从singletonObjects中取，
        Object singletonObject = this.singletonObjects.get(beanName);
        if (singletonObject != null) {
            return singletonObject;
        }

        // 尝试从earlySingletonObjects取
        singletonObject = this.earlySingletonObjects.get(beanName);
        if (singletonObject != null) {
            return singletonObject;
        }

        // 尝试从singletonFactories取出工厂方法
        ObjectFactory<?> objectFactory = this.singletonFactories.get(beanName);
        if (objectFactory != null) {
            singletonObject = objectFactory.getObject();
            this.earlySingletonObjects.put(beanName, singletonObject);
            return singletonObject;
        }

        return createBean(beanName);
    }

    private void populateBean(Object object) {
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.getAnnotation(CodeBearAutowired.class) != null) {
                Object value = getBean(field.getName());
                try {
                    field.setAccessible(true);
                    field.set(object, value);
                } catch (IllegalAccessException ignored) {
                }
            }
        }
    }
}