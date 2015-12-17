package com.example;

/**
 * Created by chufengma on 15/12/5.
 */
public class Fibonacci_9 extends BaseTest {

    /**
     * 1. Fibonacci 数列。
     *
     *  最常用的方法是递归的方式，但是递归往往效率低下。
     *  比如会重复计算。Fibonacci的递归方式会重复计算很多节点。
     *  因此可以自下而上的循环计算。
     *
     * **/

    public static int digui(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return digui(n - 1) + digui(n - 2);
    }

    public static int loop(int n) {
        int zero = 0;
        int one = 1;
        int sum = 1;
        if (n == 0 ) return zero;
        if (n == 1) return one;
        for(int i = 2; i <= n;i++) {
            sum = one + zero;
            zero = one;
            one = sum;
        }
        return sum;
    }

}
