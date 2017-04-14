package test2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 切面 
 * @author Bird 
 * 
 */  
@Aspect
public class MyInterceptor {  
    @Pointcut("execution(* test2.PersonServiceBean.*(..))")
    private void anyMethod(){

    }//定义一个切入点
      
    @Before(value = "execution(* test2.PersonServiceBean.update(..)) && args(name,id)",argNames = "jp,name,id")
    public void doAccessCheck(JoinPoint jp,String name, Integer id){
        System.out.println("update()前置通知"+name+id+jp.toString());

    }

    @AfterReturning("anyMethod()")
    public void doAfter(){  
        System.out.println("后置通知");  
    }  
      
    @After("anyMethod()")
    public void after(){  
        System.out.println("最终通知");  
    }  
      
    @AfterThrowing("anyMethod()")
    public void doAfterThrow(){  
        System.out.println("例外通知");  
    }  
      
    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("进入环绕通知");  
        Object object = pjp.proceed();//执行该方法  
        System.out.println("退出方法");  
        return object;  
    }  
}  