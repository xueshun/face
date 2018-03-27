package com.xue.design.factory.impl;

/**
 * @Author xueshun
 * @Create 2018-03-27 11:11
 */
public class Test {
    public static void main(String[] args) {
        Provider provider = new SendMailFactory();
        Sender produce = provider.produce();
        produce.send();
    }
}
