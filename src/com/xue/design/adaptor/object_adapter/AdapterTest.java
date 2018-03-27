package com.xue.design.adaptor.object_adapter;

import com.xue.design.adaptor.class_adapter.Source;
import com.xue.design.adaptor.class_adapter.Targetable;

/**
 * @Author xueshun
 * @Create 2018-03-27 11:34
 */
public class AdapterTest {
    public static void main(String[] args) {
        Source source = new Source();
        Targetable targetable = new Wrapper(source);
        targetable.method1();
        targetable.method2();
    }
}
