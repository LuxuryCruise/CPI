package com.chenqi.practice.modules.web.service.thread.cyclicBarrier;

import com.chenqi.practice.modules.web.service.thread.ThreadTest;
import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest extends ThreadTest {

    /** 入参表示await的数量，因此要加1
     * 指定的线程任务，由最后结束的线程执行
     * */
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(super.getThreadNum() + 1,
            new Thread(() ->{
                System.out.println("执行线程结束！" );
            }));

    @Test
    public void test() throws BrokenBarrierException, InterruptedException {

        CyclicBarrierThread cyclicBarrierThread;

        for(int i=0 ; i< super.getThreadNum() ; i++){
            cyclicBarrierThread = new CyclicBarrierThread("线程"+i , cyclicBarrier);
            super.getExecutorService().submit(cyclicBarrierThread);
        }

        System.out.println("主线程开始等待！");
        cyclicBarrier.await();
        System.out.println("主线程执行完成！");

    }

     ;


}
