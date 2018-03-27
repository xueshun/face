package com.xue.design.strategy;

/**
 * @Author xueshun
 * @Create 2018-03-27 13:35
 */
public class Plus extends AbstractCalculator implements ICalculator {
    @Override
    public int calculate(String exp) {
        int[] arrayInt = split(exp, "\\+");
        return arrayInt[0] + arrayInt[1];
    }
}
