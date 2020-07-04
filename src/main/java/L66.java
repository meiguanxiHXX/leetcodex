import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class L66 {

  static class Solution {

    public int[] plusOne(int[] digits) {
      int sum = digits[digits.length - 1] + 1;
      int c = 0;
      if (sum >= 10) {
        digits[digits.length - 1] = sum - 10;
        c = 1;
      } else {
        digits[digits.length - 1] = sum;
        c = 0;
      }
      for (int i = digits.length - 2; i >= 0; i--) {
        sum = digits[i] + c;
        if (sum >= 10) {
          digits[i] = sum - 10;
          c = 1;
        } else {
          digits[i] = sum;
          c = 0;
        }
      }

      if (c == 0) {
        return digits;
      }
      List<Integer> ans = new ArrayList<>();
      ans.add(1);
      ans.addAll(Arrays.stream(digits).boxed().collect(Collectors.toList()));
      return ans.stream().mapToInt(i -> i).toArray();
    }
  }

  public static void main(String[] args) {
    int[] digits={9,9,9};
    Solution solution=new Solution();
    System.out.println(Arrays.toString(solution.plusOne(digits)));
  }

}
