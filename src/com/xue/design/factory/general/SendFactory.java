package com.xue.design.factory.general;

/**
 * @Author xueshun
 * @Create 2018-03-27 10:44
 */
public class SendFactory {

    private final static String MAIL = "mail";
    private final static String SMS = "sms";

    public Sender produce(String type){
        if(SendFactory.MAIL.equals(type)){
            return new MailSender();
        }else if(SendFactory.SMS.equals(type)){
            return new SmsSender();
        }else {
            System.out.println("请输入正确的类型");
            return null;
        }
    }
}
