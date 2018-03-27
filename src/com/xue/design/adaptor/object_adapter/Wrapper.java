package com.xue.design.adaptor.object_adapter;

import com.xue.design.adaptor.class_adapter.Source;
import com.xue.design.adaptor.class_adapter.Targetable;

/**
 * 对象的适配器模式
 *    基本思路和类适配器模式相同，只是将Adapter类修改，这次不集成Source类，而是持有Source类的实例
 *    已达到兼容的问题
 * @Author xueshun
 * @Create 2018-03-27 11:32
 */
public class Wrapper implements Targetable {

    private Source source;

    public Wrapper(Source source) {
        super();
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("this is the targetable method");
    }
}
