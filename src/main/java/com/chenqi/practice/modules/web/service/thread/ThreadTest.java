package com.chenqi.practice.modules.web.service.thread;

import com.chenqi.practice.modules.web.service.thread.countDownLatch.CountDownLatchTest;
import lombok.Data;

import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

@Data
public abstract class ThreadTest {

    /** 测试的线程数 */
    private int threadNum = 3;

    private ExecutorService executorService = newFixedThreadPool(this.threadNum);

    protected void initThreadPool(int threadNum){
        if(threadNum == this.threadNum){
            return;
        }
        this.threadNum = threadNum;
        this.executorService = newFixedThreadPool(threadNum);
    };


}
