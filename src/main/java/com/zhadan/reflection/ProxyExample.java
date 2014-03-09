package com.zhadan.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 15.12.13
 * Time: 22:39
 */
public class ProxyExample {
    public static void main(String[] args) {
        final Map<String, Integer> map = new HashMap<String, Integer>();
        final Object lock = new Object();
        Map newMap = (Map) Proxy.newProxyInstance(ProxyExample.class.getClassLoader(), new Class[]
                {Map.class}, new InvocationHandler() {

            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                synchronized (lock) {
                    System.out.println(method);
                    return method.invoke(map, args);
                }
            }
        });
        newMap.entrySet();
        newMap.put("ABC", 1);
        newMap.put("XYZ", 2);
        newMap.put("XYZ", 3);
        newMap.entrySet();

        //AOP
    }
}
