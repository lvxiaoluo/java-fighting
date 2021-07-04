//给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 902 👎 0


package org.example.leetcode.editor.cn;

import org.example.leetcode.editor.cn.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
  * @author lvle
  * @desc java:二叉树的中序遍历
  */
public class P94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
        solution.list = new ArrayList<>();
        //1 null 2
        TreeNode root1 = new TreeNode(1);
        root1.setRight(new TreeNode(2));
        List<Integer> integers = solution.inorderTraversal(root1);
        System.out.println(integers);

        solution.list = new ArrayList<>();
        //1,null,2,3
        TreeNode root2 = new TreeNode(1);
        root2.setRight(new TreeNode(2));
        root2.getRight().setLeft(new TreeNode(3));
        List<Integer> integers1 = solution.inorderTraversal(root2);
        System.out.println(integers1);

        solution.list = new ArrayList<>();
        //1 2
        TreeNode root3 = new TreeNode(1);
        root3.setLeft(new TreeNode(2));
        List<Integer> integers2 = solution.inorderTraversal(root3);
        System.out.println(integers2);
        //TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

    /**
     * 递归
     */
    class Solution {

    List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            return null;
        }
        inorderTraversal(root.getLeft());
        //中序
        System.out.println(root.getVal());
        list.add(root.getVal());
        inorderTraversal(root.getRight());
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}