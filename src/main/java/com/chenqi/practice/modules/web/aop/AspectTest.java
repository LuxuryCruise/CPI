package com.chenqi.practice.modules.web.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Aspect
@Component
public class AspectTest {


    /**
     * 此处的切点是注解的方式，也可以用包名的方式达到相同的效果
     * '@Pointcut("execution(* com.chenqi.practice.modules.*.*(..))")'
     */
    @Pointcut(value = "@annotation(com.chenqi.practice.modules.web.annotation.AnnotationTest)")
    public void aspectTest(){
        System.out.println("aspectTest方法执行！");
    }




    @Around(value = "aspectTest()")
    public Object aroundTest(ProceedingJoinPoint joinPoint)throws Throwable{
        System.out.println("aroundTest方法执行,proceed()之前！");

        Object result = joinPoint.proceed();

        System.out.println("aroundTest方法执行,proceed()之后！");

        return result;

    }

    @Before(value = "aspectTest()")
    public void beforeTest(){
        System.out.println("beforeTest方法执行！");
    }

    @After(value = "aspectTest()")
    public void afterTest(){
        System.out.println("afterTest方法执行！");
    }

    /**
     * 处理完请求，返回内容
     * @param ret
     */
    @AfterReturning(returning = "ret", pointcut = "aspectTest()")
    public void doAfterReturning(Object ret) {
        System.out.println("doAfterReturning方法的返回值 : " + ret);
    }

    /**
     * 后置异常通知
     */
    @AfterThrowing("aspectTest()")
    public void throwss(JoinPoint jp){
        System.out.println("方法异常时执行.....");
    }


    private Annotation[] getAnnotation(ProceedingJoinPoint joinPoint){
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        return method.getDeclaredAnnotations();
    }


}
