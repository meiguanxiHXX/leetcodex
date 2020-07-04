import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class L94InOrderTraversal {

//  static class Solution {
//
//    public List<Integer> inorderTraversal(com.leetcode.TreeNode root) {
//      List<Integer> ans = new ArrayList<>();
//      dfs(ans, root);
//      return ans;
//    }
//
//    private void dfs(List<Integer> ans, com.leetcode.TreeNode node) {
//      if (node == null) {
//        return;
//      }
//      dfs(ans, node.left);
//      ans.add(node.val);
//      dfs(ans, node.right);
//    }
//  }

  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> ans = new ArrayList<>();
    Stack<TreeNode> s = new Stack<>();
    TreeNode node = root;
    while (node != null || !s.empty()) {
      while (node != null) {
        s.push(node);
        node = node.left;
      }
      if (!s.empty()) {
        node = s.pop();
        ans.add(node.val);
        node = node.right;
      }
    }
    return ans;
  }
}
