package com.xue.design.factory.multi;

import com.xue.design.factory.general.MailSender;
import com.xue.design.factory.general.Sender;
import com.xue.design.factory.general.SmsSender;

/**
 * 多个工厂模式
 *   该模式是对普通工厂模式的改进，在普通工厂方法模式中，如果传递字符串出错，则不能正确创建对象，
 *   而多个工厂方法模式是提供多个工厂方法，分别创建对象
 * @Author xueshun
 * @Create 2018-03-27 10:57
 */
public class SendFactory {

    public Sender produceMail(){
        return new MailSender();
    }

    public Sender produceSms(){
        return new SmsSender();
    }
}
