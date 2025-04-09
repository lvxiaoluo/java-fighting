//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
// 示例 1:
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 示例 2:
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 示例 3:
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 示例 4:
//输入: s = ""
//输出: 0
// 提示：
// 0 <= s.length <= 5 * 104
// s 由英文字母、数字、符号和空格组成
// Related Topics 哈希表 双指针 字符串 Sliding Window
// 👍 4675 👎 0


package org.example.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author lvle
 * @desc java:无重复字符的最长子串
 */
public class P3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();
        //TO TEST
        int length = solution.lengthOfLongestSubstring("abcdddtesat");
        String str = solution.lengthOfLongestSubStr("abcdddtesat");
        System.out.println(length);
        System.out.println(str);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            int ans = 0;
            String s1 ="";
            s1.toCharArray();
            Map<Character,Integer> map = new HashMap<>();
            int start=0;
            for (int end = 0; end < n;end++){
                char c = s.charAt(end);
                if (map.containsKey(c)){
                    start = Math.max(map.get(c), start);
                }
                ans = Math.max(ans, end - start + 1);
                map.put(c, end+1);
            }
            return ans;
        }

        public String lengthOfLongestSubStr(String s) {
            int n = s.length(),ans = 0;
            Map<Integer, Integer> maxMap = new HashMap<>();
            Map<Character,Integer> map = new HashMap<>();

            for (int start=0,end = 0; end < n;end++){
                char c = s.charAt(end);
                if (map.containsKey(c)){
                    start = Math.max(map.get(c), start);
                }
                ans = Math.max(ans, end - start + 1);
                map.put(c, end+1);
                maxMap.put(start, end);
            }


            int start=0,end =0;
            int diff = 0;
            Set<Map.Entry<Integer, Integer>> entries = maxMap.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                Integer k = entry.getKey();
                Integer v = entry.getValue();
                if (v-k > diff){
                    diff = v - k;
                    start = k;
                    end = v;
                }
            }
            System.out.println(start + " | " + end);
            return s.substring(start, end+1);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}