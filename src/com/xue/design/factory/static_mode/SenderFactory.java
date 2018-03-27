package com.xue.design.factory.static_mode;

import com.xue.design.factory.general.MailSender;
import com.xue.design.factory.general.Sender;
import com.xue.design.factory.general.SmsSender;

/**
 * 静态工厂模式
 *    将上面的多个工厂模式里的方法设置为静态，不需要创建实例，直接使用即可
 * @Author xueshun
 * @Create 2018-03-27 11:03
 */
public class SenderFactory {
    public static Sender produceMail(){
        return new MailSender();
    }

    public static Sender produceSms(){
        return new SmsSender();
    }

    public static void main(String[] args) {
        Sender sender = SenderFactory.produceMail();
        sender.Send();
    }
}
