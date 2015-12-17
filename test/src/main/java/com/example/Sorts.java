package com.example;

/**
 * Created by yifeng on 15/12/3.
 */
public class Sorts extends BaseTest {

    /**
     * ---------------------------------------------------------------
     *冒泡排序

     * 前后依次比较,这样每一轮最大(最小)的的数便会出现在右边(左边)
     * time : O (n^2)
     *
     * ---------------------------------------------------------------
     *插入排序
     *
     * 将一个数插入到已经排好序的序列中(联想到抓扑克牌)
     * 适合元素较少的时候
     * time : O (n^2) 最优情况 不需要移动, 最差情况,需要移动 n*(n-1)/2 元素
     * mem :  O (1)
     * <p/>
     * 归并排序
     *
     *  time : O (n^2) 最优情况 不需要移动, 最差情况,需要移动 n*(n-1)/2 元素
     *  mem :  O (1)
     *
     * ---------------------------------------------------------------
     *归并排序
     *  拆分成若干个俩个元素的序列,这俩个元素可以大小.
     *
     *
     *  time : O(nlog2n)
     *  mem :  O(n)
     *
     * ---------------------------------------------------------------
     *快速排序
     *
     *  time : 最好 O(nlgn)  最差 O(n*n) 平均O(nlong)
     *
     *
     *  若从空间复杂度来考虑：首选堆排序，其次是快速排序，最后是归并排序。
     *  若从稳定性来考虑，应选取归并排序，因为堆排序和快速排序都是不稳定的。
     *  若从平均情况下的排序速度考虑，应该选择快速排序。
     * ---------------------------------------------------------------
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
        for(int i = 1; 2 * i  < arrays.length / 2; i *= 2) {
            mergePass(i);
        }
    }

    public static void mergePass(int gap) {
        int i = 0;
        for(; (i + 4 * gap - 1) < arrays.length ; i = i + 4 * gap) {
            merge(i, i + 2 * gap - 1, i + 4 * gap - 1);
        }
        if (i < arrays.length) {
            merge(0, i - 1, arrays.length - 1);
        }
    }

    public static void merge(int low, int middle, int high) {
        int[] tmpArray = new int[high - low + 1];
        int pos = 0;
        int tmpLow = low;
        int tmpHigh = high;

        while(tmpLow < tmpHigh) {
            if (arrays[tmpLow] > arrays[tmpHigh]) {
                tmpArray[pos] = arrays[tmpLow];
                tmpLow++;
            } else {
                tmpArray[pos] = arrays[tmpHigh];
                tmpHigh--;
            }
            pos++;
        }

        for(pos = 0 ;low <= high; low++, pos++) {
            arrays[low] = tmpArray[pos];
        }
    }

    public static int[] quickSort(int low, int high) {
        if (low >= high) {
            return arrays;
        }
        int value = arrays[low];
        int tmpLow = low;
        int tmpHigh = high;
        while(tmpLow < tmpHigh) {
            while(tmpLow < tmpHigh && arrays[tmpHigh] < value) {
                tmpHigh--;
            }
            arrays[tmpLow] = arrays[tmpHigh];

            while(tmpLow < tmpHigh && arrays[tmpLow] > value) {
                tmpLow++;
            }
            arrays[tmpHigh] = arrays[tmpLow];
        }
        arrays[tmpLow] = value;

        quickSort(low, tmpLow - 1);
        quickSort(tmpHigh + 1, high);
        return arrays;
    }



}
