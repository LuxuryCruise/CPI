package com.chenqi.practice.modules.web.service.thread.countDownLatch;

import com.chenqi.practice.modules.web.service.thread.ThreadTest;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest extends ThreadTest {

    /** 入参表示线程数 */
    private final CountDownLatch latch = new CountDownLatch(super.getThreadNum());

    @Test
    public void test() throws InterruptedException {

        CountDownLatchThread countDownLatchThread;
        for(int i=0 ; i< super.getThreadNum() ; i++){
            countDownLatchThread = new CountDownLatchThread("线程"+i,latch);
            super.getExecutorService().submit(countDownLatchThread);
        }
        System.out.println("主线程开始等待！");
        latch.await();
        System.out.println("主线程执行完成！");


    }

}
