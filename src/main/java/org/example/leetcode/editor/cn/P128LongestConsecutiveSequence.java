//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,0,1,2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// Related Topics 并查集 数组 哈希表 👍 2457 👎 0

package org.example.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class P128LongestConsecutiveSequence{
    public static void main(String[] args) {
         Solution solution = new P128LongestConsecutiveSequence().new Solution();
         
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 最长连续序列
     * 时间复杂度 O(n)
     */
    class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> setNum = new HashSet<>();
        for(int num : nums){
            setNum.add(num);
        }
        int longStreak = 0;
        for(int num : nums){
            if(!setNum.contains(num-1)){
                int currentNum = num;
                int current_streak = 1;
                while(setNum.contains(currentNum+1)){
                    currentNum = currentNum+1;
                    current_streak = current_streak +1;
                }
                longStreak = Math.max(longStreak,current_streak);
            }
        }
        return longStreak;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}