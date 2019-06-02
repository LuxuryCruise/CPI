package com.chenqi.practice.modules.web.service.thread.countDownLatch;

import com.chenqi.practice.modules.web.service.thread.ServiceCommon;

import java.util.concurrent.CountDownLatch;

/**
 * @description:  用作多线程的演示，打印控制台信息演示效果
 * @auther: chenqi
 * @date: 2019/6/2 16:03
 */
public class CountDownLatchThread implements Runnable{

    private String threadName;

    private CountDownLatch countDownLatch;

    public CountDownLatchThread(String printMsg, CountDownLatch countDownLatch){
        this.threadName = printMsg;
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        System.out.println(threadName + "开始执行！");
        ServiceCommon.sleepForSecond(0.5f);
        System.out.println(threadName + "执行结束！");
        countDownLatch.countDown();
    }



}
