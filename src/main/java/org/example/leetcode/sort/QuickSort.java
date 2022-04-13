package org.example.leetcode.sort;

import java.util.Arrays;

/**
 * @author lvle
 * @date 2022-04-11 23:48
 * 快排
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] array = {8, 1, 4, 9, 3, 5, 2, 7, 0, 6};
        // System.out.println(Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] arr,int startIndex,int endIndex){
        if (startIndex >= endIndex){
            return;
        }
        int pivotIndex = partition(arr,startIndex,endIndex);
        quickSort(arr,startIndex,pivotIndex -1);
        quickSort(arr,pivotIndex+1,endIndex);
    }

    private static int partition(int[] arr,int startIndex,int endIndex){
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right){
            while (left < right && arr[right] > pivot){
                right--;
            }
            while (left < right && arr[left] <= pivot){
                left++;
            }
            if (left<right){
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        arr[startIndex] = arr[left];
        arr[left] = pivot;
        return left;
    }
}
