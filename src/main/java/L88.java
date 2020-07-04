import java.util.Arrays;
import java.util.stream.Collectors;

public class L88 {

  static class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
      int[] nums3 = new int[m];
      for (int i = 0; i < m; i++) {
        nums3[i] = nums1[i];
      }

      int i = 0;
      int j = 0;
      int k = 0;
      while (i < m && j < n) {
        if (nums3[i] < nums2[j]) {
          nums1[k++] = nums3[i++];
        } else {
          nums1[k++] = nums2[j++];
        }
      }

      for (; i < m; i++) {
        nums1[k++] = nums3[i];
      }
      for (; j < n; j++) {
        nums1[k++] = nums2[j];
      }
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    int[] a = {1, 2, 5, 7, 0, 0, 0};
    int[] b = {2, 3, 6};
    solution.merge(a, 4, b, 3);
    System.out.println(Arrays.stream(a).boxed().collect(Collectors.toList()));
  }

}
