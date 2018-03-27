package com.xue.design.factory.general;

/**
 * @Author xueshun
 * @Create 2018-03-27 10:43
 */
public class MailSender implements Sender{
    @Override
    public void Send() {
        System.out.println("this is mail sender");
    }
}
