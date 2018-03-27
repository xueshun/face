package com.xue.design.observer;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @Author xueshun
 * @Create 2018-03-27 13:48
 */
public abstract class AbstractSubject implements  Subject{

    private Vector<Observer> vector = new Vector<>();

    @Override
    public void add(Observer observer) {
        vector.add(observer);
    }

    @Override
    public void del(Observer observer) {
        vector.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Enumeration<Observer> enumo = vector.elements();
        while (enumo.hasMoreElements()){
            enumo.nextElement().update();
        }
    }


}
