package com.chenqi.practice.modules.web.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/testController")
public class TestContrller {

    @RequestMapping(value = "/startUpTest.do",method = RequestMethod.GET)
    @ApiOperation(value = "测试接口能否正常访问")
    public String startUpTest(){
        return "api接口成功访问！";
    }



}
