//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，
// 并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9778 👎 0


package org.example.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lvle
 * @desc java:两数之和
 */
public class P1TwoSum {
    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution();
        //TO TEST
//        int[] ints = solution.twoSum(new int[]{2, 7, 11, 15}, 9);
        int[] ints = solution.twoSum(new int[]{3,2,4},6);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> tempMap = new HashMap<>(16);
            for (int i = 0; i < nums.length; i++) {
                if (!tempMap.containsKey(nums[i])) {
                    tempMap.put(nums[i], i);
                }
                if (tempMap.containsKey(target - nums[i]) && i != tempMap.get(target - nums[i])) {
                    return new int[]{tempMap.get(target - nums[i]), i};
                }

            }
            return new int[]{};
        }
    }



    //leetcode submit region end(Prohibit modification and deletion)
    //method2
    //两层for循环遍历即可
}