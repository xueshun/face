package com.xue.design.strategy;

/**
 * @Author xueshun
 * @Create 2018-03-27 13:36
 */
public class Strategy {
    public static void main(String[] args) {
        String exp = "2+8";
        ICalculator cal = new Plus();
        int result = cal.calculate(exp);
        System.out.println(result);
    }
}
