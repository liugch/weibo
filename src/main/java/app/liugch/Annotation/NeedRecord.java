package app.liugch.Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)//声明注释保留时长
@Target(ElementType.METHOD)//声明可以使用此注解的元素级别类型（如类、方法变量等）
public @interface NeedRecord {
}
