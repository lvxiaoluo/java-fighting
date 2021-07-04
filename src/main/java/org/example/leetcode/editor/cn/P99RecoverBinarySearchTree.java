//给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。 
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 
// 👍 475 👎 0


package org.example.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/**
  * @author lvle
  * @desc java:恢复二叉搜索树
  */
public class P99RecoverBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P99RecoverBinarySearchTree().new Solution();
        //TO TEST
        // [1,3,null,null,2]
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.right = null;
        node.left.left = null;
        node.left.right = new TreeNode(2);


//        [3,1,4,null,null,2]
        TreeNode node1 = new TreeNode(3);
        node1.left = new TreeNode(1);
        node1.right = new TreeNode(4);
        node1.left.left = null;
        node1.left.right = null;
        node1.right.left = new TreeNode(2);
        node1.right.right = null;
        printTree(node1);
        solution.recoverTree_1(node1);
        printTree(node1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    private static void printTree(TreeNode node){
        if (node == null){
            return;
        }
        System.out.print(node.val);
        printTree(node.left);
        printTree(node.right);
        System.out.println();
    }
    class Solution {
        public void recoverTree(TreeNode root) {

        }

        public void recoverTree_1(TreeNode root) {
            List<TreeNode> list = new ArrayList<>();
            convert(root, list);
            TreeNode x = null;
            TreeNode y = null;
            for (int i = 0; i < list.size()-1; i++) {
                if (list.get(i).val > list.get(i + 1).val) {
                    y = list.get(i + 1);
                    if (x == null) {
                        x = list.get(i);
                    }
                }
            }
            if (x != null && y != null) {
                int tmp = x.val;
                x.val = y.val;
                y.val = tmp;
            }
        }

        private void convert(TreeNode node, List<TreeNode> list) {
            if (node == null) {
                return;
            }
            convert(node.left, list);
            list.add(node);
            convert(node.right, list);
        }

    }

}
class TreeNode {
    TreeNode() {}
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

