package com.xue.design.factory.impl;

/**
 * 工厂模式有一个问题就是
 *    类的创建以来工厂类，也就是说，若果想要拓展程序，必须对工厂类进行修改，
 *    这违背了闭包原则，所以从设计角度考虑，有一定的问题，如何解决呢？
 *    就用抽象工厂模式，创建多个工厂模式，这样一旦增加新的功能，直接增加新的工厂类就可以了，不需要修改之前的代码
 * @Author xueshun
 * @Create 2018-03-27 11:11
 */
public class SendMailFactory implements Provider{
    @Override
    public Sender produce() {
        return new MailSender();
    }
}
