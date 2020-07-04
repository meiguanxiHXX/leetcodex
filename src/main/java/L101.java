public class L101 {

  class Solution {

    public boolean isSymmetric(TreeNode root) {
      if (root == null) {
        return true;
      }

      return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode leftNode, TreeNode rightNode) {
      if (leftNode == null && rightNode == null) {
        return true;
      }

      if (leftNode == null || rightNode == null) {
        return false;
      }

      if (leftNode.val != rightNode.val) {
        return false;
      }

      boolean left = dfs(leftNode.left, rightNode.right);
      boolean right = dfs(leftNode.right, rightNode.left);
      return left && right;
    }
  }

}
