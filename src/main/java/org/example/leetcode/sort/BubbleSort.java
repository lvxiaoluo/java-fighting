package org.example.leetcode.sort;

import java.util.Arrays;

/**
 * @author lvle
 * @date 2022-04-11 23:23
 * 冒泡算法
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] nums = { 6, 3, 8, 2, 9, 1 };
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void bubbleSort(int[] nums){
        for (int i=0;i< nums.length - 1;i++){
            for (int j=0;j< nums.length-i-1;j++){
                if (nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
    }
}
