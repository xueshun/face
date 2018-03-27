package com.xue.design.factory.multi;

import com.xue.design.factory.general.Sender;

/**
 * @Author xueshun
 * @Create 2018-03-27 11:00
 */
public class FactoryTest {
    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produceMail();
        sender.Send();
    }
}
