package com.example;

/**
 * Created by yifeng on 15/12/17.
 */
public class TimesHalfsNum_29 extends BaseTest {

    /*数组中有一个数字出现的次数超过数组长度的一半，
      请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
      由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。*/

    /******************************/
    // 思路1, 利用快速排序先排序,然后取中位数
    /******************************/
    // 思路2, 遍历数组, 利用一个key, 一个times的方式, 初始化为第一个数,次数为1.如果下一个数组为key,则times+1,否则times-1.
    // 当times=0的时候,改变key指,并重新将times复位1
    /******************************/
    static int array[] = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};

    public static void sortAndMiddle() {
        quickSort(0, array.length - 1);
        out("-start--" + array[array.length / 2 + 1] + "");
    }

    public static void loopAndKeyValue() {
        int key = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (key == array[i]) {
                times++;
            } else {
                times--;
            }
            if (times == 0) {
                key = array[i];
                times = 1;
            }
        }
        out("key:" + key + ", times:" + times);
    }

    public static void quickSort(int low, int high) {
        if (low >= high) {
            return;
        }
        int pos = array[low];
        int posLow = low;
        int posHight = high;
        while (low < high) {
            while (low < high && array[high] > pos) {
                high--;
            }
            array[low++] = array[high];
            while (low < high && array[low] < pos) {
                low++;
            }
            array[high--] = array[low];
        }
        array[low] = pos;
        quickSort(posLow, low - 1);
        quickSort(high + 1, posHight);
    }

}
