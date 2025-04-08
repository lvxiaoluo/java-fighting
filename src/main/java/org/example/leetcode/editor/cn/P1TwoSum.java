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
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
  * @author lvle
  * @desc java:两数之和
  */

@Slf4j
public class P1TwoSum {
    public static void main(String[] args) {
        Solution solution = new P1TwoSum().new Solution();
        //TO TEST
        //时间复杂度 O(N) 空间复杂度O(N)
        int target = 6;
//        int[] arr = new int[]{3,3};
        int[] arr = new int[]{3,2,4};
        int[] resultArr = solution.twoSum(arr, target);
        int[] ints = solution.twoSumTest(arr, target);
        log.info("resultArr :{}", JSON.toJSONString(resultArr));
        log.info("ints :{}", JSON.toJSONString(ints));
    }

    @Test
    public void twoSumTest(){
        Solution solution = new P1TwoSum().new Solution();
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] resultArr = solution.twoSum(nums, target);
        log.info("runTwoSum target:{} resultArr:{}",target,resultArr);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 求两数之和
         * @param nums 数组
         * @param target 目标值
         * @return
         * 时间复杂度 O(N)
         * 空间复杂度 O(N)
         */
        public int[] twoSum(int[] nums,int target){
            int length = nums.length;
            Map<Integer,Integer> tempMap = new HashMap<>();
            for (int i =0;i<length;i++){
                if (!tempMap.containsKey(nums[i])){
                    tempMap.put(nums[i],i);
                }
                if (tempMap.containsKey(target-nums[i]) && i != tempMap.get(target-nums[i])){
                    return new int[]{tempMap.get(target-nums[i]),i};
                }
            }
            return new int[]{};
        }

        //method2
        //两层for循环遍历即可
        //时间负责度
        public int[] twoSumM2(int[] nums, int target) {
            int n = nums.length;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[]{i, j};
                    }
                }
            }
            return new int[]{};
        }

        public int[] twoSumTest(int[] nums, int target) {
            Map<Integer,Integer> map = new HashMap<>();
            int length = nums.length;
            for(int idx=0;idx <length;idx++){
                if(!map.containsKey(nums[idx])){
                    map.put(nums[idx],idx);
                }
                if(map.containsKey(target - nums[idx]) && idx != map.get(target - nums[idx])){
                    return new int[]{idx,map.get(target-nums[idx])};
                }
            }
            return  new int[]{};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}