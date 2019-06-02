package com.chenqi.practice.modules.web.controller;

import com.chenqi.practice.modules.web.annotation.AnnotationTest;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/aspectTestController")
public class AspectTestController {


    @AnnotationTest
    @RequestMapping(value = "/test1.do",method = RequestMethod.GET)
    @ApiOperation(value = "注解测试方法，无返回值！")
    public void test1(){
        System.out.println("注解测试方法，无返回值！");
    }


//    @AnnotationTest
    @RequestMapping(value = "/test2.do",method = RequestMethod.GET)
    @ApiOperation(value = "注解测试方法，有返回值！")
    public String test2(){
        System.out.println("注解测试方法，有返回值！");

        return "test2方法返回值！";
    }


}
