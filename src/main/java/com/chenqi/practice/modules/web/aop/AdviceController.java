package com.chenqi.practice.modules.web.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AdviceController {

    @ExceptionHandler(value = {Exception.class})
    public void test1(){

        System.out.println("异常处理类！");

    }

}
