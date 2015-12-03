package com.example;

public class TestMain extends BaseTest {

    public static void main(String[] args) {
        // PrintArrayReverse_4.start();
        // RebuildTree_6.start();

//        TwoStackToQueue_7 twoStackToQueue_7 = new TwoStackToQueue_7();
//        twoStackToQueue_7.appendTail(3);
//        twoStackToQueue_7.appendTail(4);
//        twoStackToQueue_7.appendTail(18);
//        twoStackToQueue_7.appendTail(25);
//        twoStackToQueue_7.appendTail(30);
//
//        out(twoStackToQueue_7.deleteHead() + "");
//        out(twoStackToQueue_7.deleteHead() + "");
//        out(twoStackToQueue_7.deleteHead() + "");
//        out(twoStackToQueue_7.deleteHead() + "");
//        out(twoStackToQueue_7.deleteHead() + "");

        Sorts.quickSort(0, Sorts.arrays.length - 1);
        for(int i : Sorts.arrays) {
            out(i + "");
        }
    }

}
