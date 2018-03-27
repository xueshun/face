package com.xue.design.factory.impl;

/**
 * @Author xueshun
 * @Create 2018-03-27 11:08
 */
public class MailSender implements Sender{
    @Override
    public void send() {
        System.out.println("this is mail sender");
    }
}
