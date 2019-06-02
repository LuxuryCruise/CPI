package com.chenqi.practice.modules.web.bo.test;

import com.chenqi.practice.modules.web.bo.BuilderTestBo;
import org.junit.Test;

public class BoTest {

    @Test
    public void test1(){
        BuilderTestBo bo = BuilderTestBo.builder().name("哈哈").age(1).build();

        System.out.println(bo.toString());

    }


}
