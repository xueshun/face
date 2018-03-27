package com.xue.design.observer;

/**
 * @Author:xueshun
 * @Date:Create in 13:46 2018/3/27
 **/
public interface Subject {

    /**
     * 增加观察者
     * @param observer
     */
    public void add(Observer observer);

    /**
     * 删除观察者
     * @param observer
     */
    public void del(Observer observer);

    /**
     * 通知观察者
     */
    public void notifyObservers();

    /**
     * 自身操作
     */
    public void operation();
}
