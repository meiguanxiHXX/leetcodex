import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class L219 {

  static class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
      Map<Integer, List<Integer>> m = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        if (m.containsKey(nums[i])) {
          List<Integer> list = m.get(nums[i]);
          list.add(i);
          continue;
        }
        List<Integer> list = new ArrayList<>();
        list.add(i);
        m.put(nums[i], list);
      }
      for (Map.Entry<Integer, List<Integer>> e : m.entrySet()) {
        List<Integer> value = e.getValue();
        if (value.size() == 1) {
          continue;
        }
        for (int i = 0; i < value.size() - 1; i++) {
          if (Math.abs(value.get(i + 1) - value.get(i)) <= k) {
            return true;
          }
        }
      }
      return false;
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] a = {1, 2, 3, 1};
    System.out.println(solution.containsNearbyDuplicate(a, 3));
  }

}
