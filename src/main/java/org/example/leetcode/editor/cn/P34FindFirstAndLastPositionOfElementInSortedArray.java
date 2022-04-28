//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1644 👎 0


package org.example.leetcode.editor.cn;
/**
  * @author lvle
  * @desc java:在排序数组中查找元素的第一个和最后一个位置
  */
public class P34FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new P34FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        //TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] searchRange(int[] nums, int target) {
      int leftIdx = binarySearch(nums,target,true);
      int rightIdex = binarySearch(nums,target,false) -1;
      if (leftIdx<=rightIdex && rightIdex < nums.length && nums[leftIdx] == target && nums[rightIdex] == target){
          return new int[]{leftIdx,rightIdex};
      }
      return new int[]{-1,-1};
    }

    public int binarySearch(int[] nums,int target,boolean lower){
        int l = 0;
        int r = nums.length -1;
        int ans = nums.length;
        while (l<=r){
            int mid = l + (r - l)/2;
            if ( nums[mid] > target || (lower && nums[mid] >= target)){
                ans = mid;
                r = mid -1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}