//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 
// 👍 963 👎 0


package org.example.leetcode.editor.cn;

/**
  * @author lvle
  * @desc java:合并两个有序数组
  */
public class P88MergeSortedArray {
    public static void main(String[] args) {
        Solution solution = new P88MergeSortedArray().new Solution();
//        int[] nums1 = new int[]{1,2,3};
//        int m = 3;
//        int[] nums2 = new int[]{2,5,6};
//        int n = 3;

        int[] nums1 = new int[]{1};
        int m = 1;
        int[] nums2 = new int[]{};
        int n = 0;
        solution.merge(nums1, m,nums2,n);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=0,p2=0;
        int[] sorted = new int[m+n];
        System.out.println(sorted);
        int curr = 0;
        while (p1< m || p2 < n){
            if (p1==m){
                curr = nums2[p2++];
            } else if (p2==n){
                curr = nums1[p1++];
            } else if (nums1[p1]<nums2[p2]) {
                curr = nums1[p1++];
            } else {
                curr = nums2[p2++];
            }
            sorted[p2+p1-1]=curr;
        }
        for (int i : sorted) {
            System.out.print(i);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}