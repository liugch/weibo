package test3.dao;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2017/2/20.
 */


public class AOPTest {


    @Test
    public void test() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop/spring-aop.xml");

        ADao adao = (ADao) applicationContext.getBean("bean1");
        adao.listAAA();
        adao.GetA2();
    }

    @Test
    public void test2() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("aop/spring-aop.xml");

        AopService aopService = (AopService) applicationContext.getBean("aopService");

        aopService.run();

    }
}
