package com.xue.design.observer;

/**
 * @Author xueshun
 * @Create 2018-03-27 13:52
 */
public class ObserverTest {

    public static void main(String[] args) {
        Subject sub = new MySubject();
        sub.add(new Observer1());
        sub.add(new Observer2());
        sub.operation();
    }
}
