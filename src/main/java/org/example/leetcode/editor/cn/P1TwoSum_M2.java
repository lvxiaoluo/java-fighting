//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
// Related Topics 数组 哈希表 👍 14121 👎 0


package org.example.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

/**
  * @author lvle
  * @desc java:两数之和
  */
@Slf4j
public class P1TwoSum_M2 {
    public static void main(String[] args) {
        Solution solution = new P1TwoSum_M2().new Solution();
        //TO TEST
        //时间复杂度 O(N) 空间复杂度O(N)
        int[] resultArr = solution.twoSum(new int[]{2, 7, 11,}, 9);
        System.out.println(JSON.toJSONString(resultArr));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] twoSum(int[] nums,int target){
            int length = nums.length;
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (nums[i]+nums[j] == target){
                        return new int[]{i,j};
                    }
                }
            }
            return new int[]{};
        }

        //method2
        //两层for循环遍历即可
//        public int[] twoSumM2(int[] nums, int target) {
//            int n = nums.length;
//            for (int i = 0; i < nums.length; i++) {
//                for (int j = i + 1; j < n; j++) {
//                    if (nums[i] + nums[j] == target) {
//                        return new int[]{i, j};
//                    }
//                }
//            }
//            return new int[]{};
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}