//设计一个算法，找出数组中最小的k个数。以任意顺序返回这k个数均可。 
//
// 示例： 
//
// 输入： arr = [1,3,5,7,2,4,6,8], k = 4
//输出： [1,2,3,4]
// 
//
// 提示： 
//
// 
// 0 <= len(arr) <= 100000 
// 0 <= k <= min(100000, len(arr)) 
// 
//
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 242 👎 0

package org.example.leetcode.editor.cn;

import com.alibaba.fastjson.JSON;

public class SmallestKLcci{
    public static void main(String[] args) {
         Solution solution = new SmallestKLcci().new Solution();
        int[] ints = solution.smallestK(new int[]{1, 3, 5, 7, 2, 4, 6, 8}, 5);
        System.out.println(JSON.toJSONString(ints));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int[] smallestK(int[] arr, int k) {
            quickSort(arr,0,arr.length-1);
            int[] result = new int[k];
            for(int i=0;i<k;i++){
                result[i] = arr[i];
            }
            return result;
        }

        public void quickSort(int[] arr,int startIndex,int endIndex){
            if(startIndex >= endIndex){
                return;
            }
            int mid = partition(arr,startIndex,endIndex);
            quickSort(arr,startIndex,mid-1);
            quickSort(arr,mid+1,endIndex);
        }

        public int partition(int[] arr,int startIndex,int endIndex){
            int pivot = arr[startIndex];
            int left = startIndex;
            int right = endIndex;
            while(left != right){
                while(left<right && arr[right]>pivot){
                    right--;
                }
                while(left<right && arr[left]<=pivot){
                    left++;
                }
                if(left<right){
                    int p = arr[left];
                    arr[left] = arr[right];
                    arr[right] = p;
                }
            }
            arr[startIndex] = arr[left];
            arr[left] = pivot;
            return left;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}