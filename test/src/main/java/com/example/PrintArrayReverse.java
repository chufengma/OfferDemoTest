package com.example;

/**
 * Created by chuyifeng on 2015/11/12.
 */
public class PrintArrayReverse extends BaseTest {

    /**
     * 输入一个链表，从尾到头打印链表每个节点的值。
     * 1.递归打印
     **/
    public static void start() {
        // 模仿链表数据
        int[] table = new int[]{3, 4, 9, 10, 12};
        print(table, 0);
    }

    public static void print(int[] table, int current) {
        if (current == table.length) {
            return;
        } else {
            print(table, ++current);
            out(table[--current] + "");
        }
    }

}
