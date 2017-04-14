package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Debug {

public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("aop/schema_aop.xml");
        IBaseBusiness business = (IBaseBusiness ) context.getBean("businessProxy");
        business.delete("猫");
    }

}