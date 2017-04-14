package test2;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAOPTest {
      
    @Test
    public void inteceptorTest(){  
        ApplicationContext ctx = new ClassPathXmlApplicationContext("aop/beanAop.xml");
        PersonServer bean = (PersonServer)ctx.getBean("personServiceBean");  
       bean.update("hehe",99999);
        //bean.save(null);

    }  

}  

