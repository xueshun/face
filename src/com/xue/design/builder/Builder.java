package com.xue.design.builder;

import com.xue.design.factory.impl.MailSender;
import com.xue.design.factory.impl.Sender;
import com.xue.design.factory.impl.SmsSender;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xueshun
 * @Create 2018-03-27 11:19
 */
public class Builder {
    private List<Sender> list = new ArrayList<Sender>();

    public void produceMailSender(int count){
        for (int i = 0; i < count; i++) {
            list.add(new MailSender());
        }
    }

    public void produceSmsSender(int count){
        for (int i = 0; i < count; i++) {
            list.add(new SmsSender());
        }
    }

    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.produceMailSender(10);
    }
}
