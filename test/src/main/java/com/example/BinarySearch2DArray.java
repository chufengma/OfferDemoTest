package com.example;

/**
 * Created by chuyifeng on 2015/11/12.
 */
public class BinarySearch2DArray extends BaseTest {

    /**
     * 说明：
     *
     * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     *
     *
     *
     * 采用二分查找法，时间复杂度为O(max(m,n))。
     * 先将给定的值key与二维数组右上角的元素比较，若相等，则返回true，
     * 若key小于它，则最后一列的元素肯定都大于key，此时可以删除掉最后一列，而若key大于它，则第一行的元素肯定都小于key，此时可以删除掉第一行，
     * 依次向下比较，如果比较到了左下角的元素，还没有发现等于key的，则返回fasle。
     *
     * **/
    public static void start() {
        int[][] array = new int[][] {{1, 3, 4, 7 ,10, 23},
                                     {2, 4, 7, 8, 11, 24},
                                     {3, 5, 8, 9, 12, 25},
                                     {4, 6, 9, 10, 13, 26}};

        int s = 4;
        int x = 0;
        int y = 5;
        boolean find = false;
        while (x >= 0 && y >= 0 && x < 4 && y < 6) {
            if (array[x][y] == s) {
                find = true;
                out("find x :" + x + ",y:" + y+",a[x][y]:" + array[x][y]);
                y--;
                x++;
            } else if (array[x][y] > s) {
                y--;
            } else if (array[x][y] < s) {
                x++;
            }
        }
        if (!find) {
            out("not find!");
        }
    }

}
