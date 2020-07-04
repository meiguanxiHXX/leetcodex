public class L398 {

  static class Solution {

    int[] nums;

    public Solution(int[] nums) {
      this.nums = nums;
    }

    public int pick(int target) {
      int ans = 0;
      int count = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] == target) {
          count++;
          double p = 1D / count;
          if (Math.random() < p) {
            ans = i;
          }
        }
      }
      return ans;
    }
  }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
}
