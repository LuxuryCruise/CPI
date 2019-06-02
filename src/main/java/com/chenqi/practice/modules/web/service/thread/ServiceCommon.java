package com.chenqi.practice.modules.web.service.thread;

public class ServiceCommon {

    public static void sleepForSecond(float second){
        try {
            Thread.sleep((long) (second*1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
