import java.util.ArrayList;
import java.util.List;

public class L1431 {

  static class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
      int max = candies[0];
      for (int i = 1; i < candies.length; i++) {
        if (max < candies[i]) {
          max = candies[i];
        }
      }

      List<Boolean> ans = new ArrayList<>(candies.length);
      for (int i = 0; i < candies.length; i++) {
        if ((candies[i] + extraCandies) >= max) {
          ans.add(Boolean.TRUE);
        } else {
          ans.add(Boolean.FALSE);
        }
      }
      return ans;
    }
  }

}
