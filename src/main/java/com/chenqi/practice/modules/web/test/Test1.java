package com.chenqi.practice.modules.web.test;

import com.alibaba.fastjson.JSON;
import com.chenqi.practice.modules.web.common.CommonFun;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

    @Test
    public void test1(){
        List<Integer> data = new ArrayList<>();
            for(int i=1 ; i<=10;i++){
                data.add(i);
            }
        String s = JSON.toJSONString(data);

        CommonFun.printCollctions(data);

        int sum = data.stream().mapToInt(Integer::intValue).sum();

        return;
    }

}
