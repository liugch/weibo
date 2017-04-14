package app.liugch.Aspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/2/21.
 */
@Component
@Aspect
public class LogAspect {

    @AfterReturning("@annotation(app.liugch.Annotation.NeedRecord)")//这里指向注解类
    public void Record(JoinPoint joinPoint) {//切点入参。
        System.out.println("日志记录:用户" + joinPoint.getArgs()[0] + "在" + new SimpleDateFormat("yyyy-MM-dd hh:mm;ss").format(new Date()) + "调用了" + joinPoint.getSignature() + "方法");
    }

}