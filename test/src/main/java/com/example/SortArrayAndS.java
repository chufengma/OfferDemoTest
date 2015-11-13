package com.example;

/**
 * Created by chuyifeng on 2015/11/12.
 */
public class SortArrayAndS extends BaseTest {
    /**
     * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
     * 1.暴力循环求和
     * 2.low high 逼近
     *
     * 假设数组是乱序的，而且规定数组中的元素全部为非负整数，同样给定一个数sum，在数组中找出任意两个数，使二者的和为sum。
     * 1.开辟sum长度的标志位数组（boolean[]）.hash的方式.
     *
     * **/
    public static void sortArrayAndS() {
        int[] array = new int[]{1,4,6,8,12,123,145,221,555,1134,6664};
        int s = 229;
        // O (n*n)
        outLine("O(n * n)");
        boolean find = false;
        for(int i = 0; i<array.length; i++) {
            int currentIndex = array.length - 1;
            while(array[currentIndex] + array[i] > s) {
                currentIndex--;
                if (currentIndex == 0) {
                    break;
                }
            }
            if (array[currentIndex] + array[i] == s) {
                find = true;
                System.out.println("find :" + array[i] + ":" + array[currentIndex]);
            }
        }

        if (!find) {
            System.out.println("not find -1, -1");
        }

        // O (n)
        outLine("O(n)");
        int low = 0;
        int high = array.length - 1;
        find = false;
        while(low < high) {
            if (array[low] + array[high] == s) {
                find = true;
                out(array[low] + ":" + array[high]);
                break;
            }
            if (array[low] + array[high] > s) {
                high--;
                continue;
            }
            if (array[low] + array[high] < s) {
                low++;
                continue;
            }
        }
        if (!find) {
            out("not find -1, -1");
        }

        // O(n) 无序
        outLine("chaos O(n)");
        int[] chaosArray = new int[] {321,112,4453,52,56,234,646,22,1,2,55,2,5,3,355};
        int chaosS = 55;

        boolean[] position = new boolean[chaosS];
        for(int i=0 ; i<chaosArray.length; i++) {
            if (chaosArray[i] >= chaosS){
                continue;
            }
            if (position[chaosArray[i]] == true) {
                out(chaosArray[i] + ":" + (chaosS - chaosArray[i]));
                break;
            } else {
                position[chaosS - chaosArray[i]] = true;
            }
        }
    }
}
