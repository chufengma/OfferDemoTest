package com.example;

/**
 * Created by chufengma on 15/12/5.
 */
public class ReviceArrayMin_8 extends BaseTest {

    /**
     * 1. 描述
     *    旋转数组的最小数字。一个递增数组， {1，2，3，4，5，10，12}
     *    旋转为：{4，5，10，12，1，2，3}
     *    求最小值
     *
     * 2.思路
     *    利用二分查找的思想，取中间值比较，如果中间值比最后值大则取一半，接着比较。
     *    要注意特殊情况：1，数组元素为2的时候，即可停止寻找。
     *                  2，存在{2，2，2，0，2} ， {2，0，2，2，2} 当low,middle,high都相等时候，只能循序查找
     *
     *
     * **/

    public static int[] array = new int[]{4, 5 ,10 ,12, 1, 2, 3};

    public static void start() {
        int low = 0;
        int high = array.length - 1;

        // 顺序数组时候，返回最低数
        int middle = low;

        while(array[low] >= array[high]) {
            // 当没有中点时候，返回较小数
            if (high - low == 1) {
                middle = high;
                break;
            }
            // 计算中点
            middle = (low + high) / 2;

            // 特殊情况
            if (array[low] == array[middle] && array[low] == array[high]) {
                order(low, high);
                return;
            }

            if (array[middle] >= array[low]) {
                low = middle;
            } else if (array[middle] <= array[high]) {
                high = middle;
            }
        }
        out(array[middle] + "--by middle search");
    }

    public static void order(int low , int high) {
        int min = array[low];
        for(int i = low; i<= high;i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        out(min + "---by order");
    }

}
