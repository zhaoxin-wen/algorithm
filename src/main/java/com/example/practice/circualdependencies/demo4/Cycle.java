package com.example.practice.circualdependencies.demo4;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author wzw
 * @date 2025/4/23 19:24
 * @description

 */
public class Cycle {
    private final Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    // 存放的是提前暴露出来的bean，没有经历过spring完整的生命周期，没有填充属性
    private final Map<String, Object> earlySingletonObjects = new HashMap<>();

    // 在Spring中，这个map存放的是beanNam和beanDefinition的映射关系
    static Map<String, Class<?>> map = new HashMap<>();

    static {
        map.put("orderService", OrderService.class);
        map.put("userService", UserService.class);
    }

    // 如果先调用init方法，就是预加载，如果直接调用getBean就是懒加载，两者的循环依赖问题都解决了
    public void init() {
        for (Map.Entry<String, Class<?>> stringClassEntry : map.entrySet()) {
            createBean(stringClassEntry.getKey());
        }
    }


    /**
     *  This method returns an object based on the given bean name.

     *
     * @param beanName the name of the bean to retrieve
     * @return the object associated with the given bean name
     */
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

        return createBean(beanName);
    }

    private Object createBean(String beanName) {
        Object singletonObject;

        try {
            // 创建对象
            singletonObject = map.get(beanName).getConstructor().newInstance();

            // 把没有完成填充属性的半成品 bean 放入earlySingletonObjects
            earlySingletonObjects.put(beanName, singletonObject);

            // 填充属性
            populateBean(singletonObject);

            // bean创建成功，放入singletonObjects
            this.singletonObjects.put(beanName, singletonObject);

            return singletonObject;
        } catch (Exception ignore) {
        }
        return null;
    }

    /**
     *  This method populates a bean with the given object.

     *
     * @param object The object to be populated into the bean.
     */
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