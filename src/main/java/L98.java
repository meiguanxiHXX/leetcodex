import java.util.ArrayList;
import java.util.List;

public class L98 {

  static class Solution {

    public boolean isValidBST(TreeNode root) {
      List<Integer> ans = new ArrayList<>();
      dfs(root, ans);

      for (int i = 0; i < ans.size() - 1; i++) {
        if (ans.get(i) >= ans.get(i + 1)) {
          return false;
        }
      }
      return true;
    }

    private void dfs(TreeNode node, List<Integer> ans) {
      if (node == null) {
        return;
      }

      dfs(node.left, ans);
      ans.add(node.val);
      dfs(node.right, ans);
    }

    public static void main(String[] args) {
      TreeNode node = new TreeNode(3);
      node.left = new TreeNode(1);
      node.right = new TreeNode(5);
      node.left.left = new TreeNode(0);
      node.left.right = new TreeNode(2);
      node.right.left = new TreeNode(4);
      node.right.right = new TreeNode(6);
      Solution solution = new Solution();
      System.out.println(solution.isValidBST(node));

    }
  }

}
