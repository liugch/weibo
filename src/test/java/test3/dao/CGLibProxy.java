package test3.dao;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Date;

/**
 * Created by Administrator on 2017/2/20.
 */
public class CGLibProxy implements MethodInterceptor {


    public Object init(Class clazz ) {

        Enhancer e = new Enhancer();
        e.setClassLoader(clazz.getClassLoader());
        e.setSuperclass( clazz);
        e.setCallback(this);
        return e.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {



        System.out.println("当前时间为:"+new Date(System.currentTimeMillis()));
        methodProxy.invokeSuper(o,objects);
        return null;
    }
}
