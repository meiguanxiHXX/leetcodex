import java.util.HashMap;
import java.util.Map;

public class L1 {

  static class Solution {

    public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> m = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        int n = target - nums[i];
        if (m.containsKey(n)) {
          return new int[]{i, m.get(n)};
        }

        m.put(nums[i], i);
      }
      return new int[]{};
    }
  }

}
