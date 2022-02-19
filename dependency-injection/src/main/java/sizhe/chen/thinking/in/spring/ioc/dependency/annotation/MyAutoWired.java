package sizhe.chen.thinking.in.spring.ioc.dependency.annotation;

import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.*;

/**
 * 自定义注解
 *
 * @Author: sizhe.chen
 * @Date: Create in 3:22 下午 2022/2/13
 * @Description:
 * @Modified:
 * @Version:
 */
@Target({ElementType.CONSTRUCTOR, ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Autowired
public @interface MyAutoWired {
    boolean required() default true;
}
