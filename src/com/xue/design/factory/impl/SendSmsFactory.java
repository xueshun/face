package com.xue.design.factory.impl;

/**
 * @Author xueshun
 * @Create 2018-03-27 11:10
 */
public class SendSmsFactory implements Provider{

    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
