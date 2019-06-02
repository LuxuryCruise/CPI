package com.chenqi.practice.modules.web.service.thread.cyclicBarrier;

import com.chenqi.practice.modules.web.service.thread.ServiceCommon;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierThread implements Runnable{

    private String threadName;

    private CyclicBarrier cyclicBarrier;

    public CyclicBarrierThread(String threadName,CyclicBarrier cyclicBarrier){
        this.threadName = threadName;
        this.cyclicBarrier = cyclicBarrier;

    }

    @Override
    public void run()  {
        System.out.println(threadName + "开始执行！");
        ServiceCommon.sleepForSecond(0.5f);
        System.out.println(threadName + "执行结束！");
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }


}
