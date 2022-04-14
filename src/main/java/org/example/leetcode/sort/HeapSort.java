package org.example.leetcode.sort;

import java.util.Arrays;

/**
 * @author lvle
 * @date 2022-04-14 22:50
 */
public class HeapSort {
    // 建堆
    public static void creatHeap(int[] arr, int n) {
        // 因为数组是从0开始的
        for (int i = (n - 1) / 2; i >= 0; i--) {
            percolateDown(arr, i, n);
        }
    }

    // 插入
    private static void insertHeap(int[] array, int data, int n) {
        array[n] = data;
        percolatrUp(array, n);
    }

    // 删除栈顶元素
    private static void deleteHeap(int[] arr, int n) {
        arr[0] = arr[n];
        arr[n] = -1;
        percolateDown(arr, 0, n - 1);
    }

    // 上浮
    private static void percolatrUp(int[] array, int n) {
        int data = array[n];
        int father = (n - 1) / 2;
        while (data < array[father] && father >= 0) {
            array[n] = array[father];
            array[father] = data;
            n = father;
            father = (n - 1) / 2;
        }
        array[father] = data;
    }

    // 下滤
    private static void percolateDown(int[] arr, int i, int n) {
        int father = arr[i];
        int child = 2 * i + 1;
        // 遍历整个该根结点的子树
        while (child <= n) {
            // 定位左右结点小的那一个
            if (child + 1 <= n && arr[child + 1] < arr[child]) {
                child += 1;
            }
            // 若根结点比子结点小，说明已经是个小堆
            if (father < arr[child]) {
                break;
            }
            // 互换根结点和子结点
            arr[i] = arr[child];
            arr[child] = father;
            // 重新定位根结点和子结点
            i = child;
            child = i * 2 + 1;
        }
    }

    public static void main(String[] args) {
        int[] array = {15, 13, 12, 5, 20, 1, 8, 9};

        creatHeap(array, array.length - 1);
        System.out.println(Arrays.toString(array));

//        deleteHeap(array, array.length - 1);
//        System.out.println(Arrays.toString(array));
//
//        deleteHeap(array, array.length - 2);
//        System.out.println(Arrays.toString(array));
//
//        insertHeap(array, 3, array.length - 2);
//        System.out.println(Arrays.toString(array));
    }
}
