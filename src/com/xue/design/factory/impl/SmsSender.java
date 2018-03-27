package com.xue.design.factory.impl;

/**
 * @Author xueshun
 * @Create 2018-03-27 11:09
 */
public class SmsSender implements Sender{
    @Override
    public void send() {
        System.out.println("this is sms sender");
    }
}
