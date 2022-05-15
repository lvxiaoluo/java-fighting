//给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 10⁶ 
// 
// Related Topics 数组 数学 枚举 数论 👍 887 👎 0


package org.example.leetcode.editor.cn;

import java.util.Arrays;

/**
  * @author lvle
  * @desc java:计数质数
  */
public class P204CountPrimes {
    public static void main(String[] args) {
        Solution solution = new P204CountPrimes().new Solution();
        //TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

   public int countPrimes(int n){
       int[] primes = new int[n];
       Arrays.fill(primes,1);
       int ans = 0;
       for (int i=2;i<n;i++){
           if (primes[i]==1){
               ans+=1;
               if ((long)i*i<n){
                   for (int j = i*i;j< n;j=j+i){
                       primes[j] =0;
                   }
               }
           }
       }
       return ans;
   }


    public int countPrimes1(int n) {
        int ans = 0;
        for (int i=2;i< n;i++){
            ans+= isPrime(i) ? 1 : 0;
        }
        return ans;
    }
    public boolean isPrime(int x){
        for (int i=2;i*i <= x;i++){
            if (x%i==0){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}