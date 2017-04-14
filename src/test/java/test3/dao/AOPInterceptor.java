package test3.dao;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
@Component
public class AOPInterceptor {

    SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");


    // 可以不定义,可以用来复用
    @Pointcut(value = "execution(public * test3.dao.*.get*(..)) || execution(* test3.dao.*.Get*(..))")
    public void point(){}

    @Before(value = "point()")
    public void before(){
        System.out.println(sdf.format(new Date(System.currentTimeMillis())));
    }

    @After(value = "point()")
    public void after(){
        System.out.println(sdf.format(new Date(System.currentTimeMillis())));
    }
}
