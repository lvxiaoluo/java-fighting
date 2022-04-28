//你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。 
//
// 给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 5
//输出：2
//解释：因为第三行不完整，所以返回 2 。
// 
//
// 示例 2： 
//
// 
//输入：n = 8
//输出：3
//解释：因为第四行不完整，所以返回 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 数学 二分查找 👍 211 👎 0


package org.example.leetcode.editor.cn;
/**
  * @author lvle
  * @desc java:排列硬币
  */
public class P441ArrangingCoins {
    public static void main(String[] args) {
        Solution solution = new P441ArrangingCoins().new Solution();
        //TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int arrangeCoins(int n) {
        int l = 1;
        int r = n;
        while ( l < r){
            int mid = (r - l +1)/2+l;
            if ((long) mid*(mid+1) < 2 * n){
                l = mid;
            }else{
                r = mid -1;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}