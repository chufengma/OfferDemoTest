package com.example;

import com.example.Struct.Tree;

import java.util.Arrays;

/**
 * Created by yifeng on 15/12/3.
 */
public class RebuildTree_6 extends BaseTest{

    /**
     * 1. 描述
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并输出它的后序遍历序列。
     *
     * 2.思路
     * 前序遍历第一个元素为root,后面为左子树和右字数.中序遍历为中间为root,左边为左子树,右边为右子树.
     * 只要找到root元素在中序中的位置,则可利用递归依次找出.
     *
     * **/
    public static Tree createTree(int[] frontArray, int[] middleArray) {
        if (frontArray.length == 0|| middleArray.length == 0) {
            return null;
        }

        // find the root
        Tree root = new Tree();
        root.value = frontArray[0];

        int i = 0;
        boolean find = false;
        for(; i < middleArray.length ;i++) {
            if (frontArray[0] == middleArray[i]) {
                find = true;
                break;
            }
        }

        if (!find) {
            return root;
        }

        // init left & right
        // find sub tree root
        // link to sub tree root
        int[] leftTree = new int[i];
        for(int j = 0; j < i ; j++) {
            leftTree[j] = middleArray[j];
        }
        int[] leftTreeFront = new int[leftTree.length];
        for(int m = 0 ; m < leftTreeFront.length ; m++) {
            leftTreeFront[m] = frontArray[1 + m];
        }
        root.left = createTree(leftTreeFront, leftTree);

        int[] rightTree = new int[middleArray.length - i  - 1];
        for(int k = i + 1; k < middleArray.length ; k++) {
            rightTree[k - i - 1] = middleArray[k];
        }
        int[] rightTreeFront = new int[rightTree.length];
        for(int u = 0; u < rightTree.length ; u++) {
            rightTreeFront[u] = frontArray[i + u + 1];
        }
        root.right = createTree(rightTreeFront, rightTree);

        return root;
    }

    public static void printTree(Tree tree) {
        if (tree == null) {
            return;
        }
        out(tree.value + "");
        printTree(tree.left);
        printTree(tree.right);
    }

    public static void start() {
        int[] frontArray = new int[]{1,2,4,7,3,5,6,8};
        int[] middleArray = new int[]{4,7,2,1,5,3,8,6};
        Tree tree = createTree(frontArray, middleArray);
        printTree(tree);
    }

}
