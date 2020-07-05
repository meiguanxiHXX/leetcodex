package leetcode98;


import java.util.ArrayList;
import java.util.List;

public class ValidateBinarySearchTree {


    //    输入:
    //    2
    //   / \
    //  1   3
    //输出: true
    public boolean isValidBST(TreeNode root) {
        List<Integer> sortedTreeNodeValue = new ArrayList<>();
        inorder(root, sortedTreeNodeValue);
        return isSorted(sortedTreeNodeValue);

    }

    private boolean isSorted(List<Integer> sortedTreeNodeValue) {
        for (int i = 0; i < sortedTreeNodeValue.size() - 1; i++) {
            if (sortedTreeNodeValue.get(i) >= sortedTreeNodeValue.get(i + 1)) {
                return false;
            }
        }
        return true;
    }


    private void inorder(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }
        inorder(node.left, ans);
        ans.add(node.val);
        inorder(node.right, ans);
    }

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(4);
        ValidateBinarySearchTree tree = new ValidateBinarySearchTree();
        System.out.println(tree.isValidBST(treeNode));
    }
}
