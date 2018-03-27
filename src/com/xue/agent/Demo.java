package com.xue.agent;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/**
 * 写一个ArrayList的动态代理
 *
 * @Author xueshun
 * @Create 2018-03-26 20:43
 */
public class Demo {
    // ArraiList代理类的测试
    public static void main(String[] ages) {
        MyArrayListInterface myArrayList = ArrayListProxy.getArrayListProxy();
        myArrayList.add("AAAAA");
        System.out.println(myArrayList.get(0));
    }

    // 定义一个ArrayList的代理类
    static class ArrayListProxy {

        // 定义一个返回ArrayListProxy对象的方法
        public static MyArrayListInterface getArrayListProxy() {
            MyArrayListInterface myArrayListProxy = (MyArrayListInterface) Proxy
                    .newProxyInstance(MyArrayListInterface.class.getClassLoader(),
                            new Class[]{MyArrayListInterface.class},
                            new InvocationHandler() {
                                // 定义一个MyArrayList对象
                                private List myArrayList = new MyArrayList();

                                @Override
                                public Object invoke(Object proxy,
                                                     Method method, Object[] args)
                                        throws Throwable {
                                    // 定义记住此时时间的变量
                                    long start = System.currentTimeMillis();
                                    // 执行al的对应方法
                                    Object objReturn = method.invoke(
                                            myArrayList, args);
                                    // 输出被调用方法执行的所需时间
                                    System.out.println(method.getName() + "方法运行时间:" + (System
                                            .currentTimeMillis()
                                            - start) + "毫秒");
                                    return objReturn;// 返回被调用方法执行结果
                                }
                            });
            return myArrayListProxy;
        }
    }
}

// 定义一个实现MyArrayListInterface的类MyArrayList
class MyArrayList extends ArrayList implements MyArrayListInterface {
}

// 定义一个接口,同时继承ArrayList类实现的全部接口
interface MyArrayListInterface<E> extends Serializable, Cloneable, Iterable<E>,
        Collection<E>, List<E>, RandomAccess {
}


