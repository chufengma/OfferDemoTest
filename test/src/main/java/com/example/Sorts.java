package com.example;

/**
 * Created by yifeng on 15/12/3.
 */
public class Sorts extends BaseTest {

    /**
     * 1. 4种排序算法
     * 冒泡排序
     * 前后依次比较,这样每一轮最大(最小)的的数便会出现在右边(左边)
     * time : O (n^2)
     *
     * 插入排序
     * 将一个数插入到已经排好序的序列中(联想到抓扑克牌)
     * 适合元素较少的时候
     * time : O (n^2) 最优情况 不需要移动, 最差情况,需要移动 n*(n-1)/2 元素
     * mem :  O (1)
     * <p/>
     * 归并排序
     *
     * <p/>
     * 快速排序
     *
     *
     **/

    public static int[] arrays = new int[]{3, 4, 1234, 1, 0, 23, 123, 13, 34};

    public static int[] bubbleSort() {
        for (int i = 0; i < arrays.length; i++) {
            for (int j = i + 1; j < arrays.length; j++) {
                if (arrays[i] < arrays[j]) {
                    int tmp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = tmp;
                }
            }
        }
        return arrays;
    }

    public static int[] insertSort() {
        for (int i = 1; i < arrays.length; i++) {
//            /** 1. whether need insert **/
//            int j;
//            boolean find = false;
//            for (j = 0; j < i; j++) {
//                if (arrays[i] > arrays[j]) {
//                    find = true;
//                    break;
//                }
//            }
//            /** 2. if need insert , move all and insert **/
//            if (find) {
//                int m = i;
//                int current = arrays[i];
//                while (m > j) {
//                    arrays[m] = arrays[m - 1];
//                    m--;
//                }
//                arrays[j] = current;
//            }
//               ||
//               ||  simplify version
//               \/

            /** 1. move all until end or big one appear **/
            int j = i;
            int target = arrays[i];
            while(j > 0 && target < arrays[j - 1]) {
                arrays[j] = arrays[j - 1];
                j--;
            }
            /** 2. insert empty position**/
            arrays[j] = target;
        }
        return arrays;
    }

    public static void mergeSort() {
    }


    public static void quickSort() {
    }


}
