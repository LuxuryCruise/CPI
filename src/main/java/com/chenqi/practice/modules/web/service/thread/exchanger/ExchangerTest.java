package com.chenqi.practice.modules.web.service.thread.exchanger;

import com.alibaba.fastjson.JSON;
import com.chenqi.practice.modules.web.common.CommonFun;
import com.chenqi.practice.modules.web.service.thread.ThreadTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerTest extends ThreadTest {

    private Exchanger<List<Integer>> exchanger = new Exchanger<>();

    @Test
    public void test(){
        super.initThreadPool(2);
        DataProducer producer = new DataProducer(exchanger);
        DataConsumer consumer = new DataConsumer(exchanger);
        super.getExecutorService().submit(producer);
        super.getExecutorService().submit(consumer);

    }



    class DataConsumer implements Runnable{
        private Exchanger exchanger;
        public DataConsumer(Exchanger exchanger){
            this.exchanger = exchanger;
        }

        private List<Integer> dataIn = new ArrayList<>();
        private List<Integer> dataOut = new ArrayList<>();
        @Override
        public void run() {
            System.out.println("consumer执行！");
            try {
                dataOut = (List<Integer>) this.exchanger.exchange(dataIn);

                //求和能够正常执行
                int sum = 0;
                for (int i : dataOut){
                    sum += i;
                }
                //求和不能执行
//                int sum = dataOut.stream().mapToInt(Integer::intValue).sum();

                System.out.println("总和：" + sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //无法正常的实现jsonString的转换
//            String jsonString = JSON.toJSONString(data);
//            System.out.println("获取的数据为：" + dataOut.size());




        }
    }

    class DataProducer implements Runnable{
        private Exchanger exchanger;
        public DataProducer(Exchanger exchanger){
            this.exchanger = exchanger;
        }

        private List<Integer> dataIn = new ArrayList<>();
        @Override
        public void run() {
            System.out.println("producer执行！");
            for(int i=1 ; i<=10;i++){
                dataIn.add(i);
            }
            try {
                this.exchanger.exchange(dataIn);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }
    }


}
