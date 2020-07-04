public class L605 {
  static class Solution {

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
      if (n == 0) {
        return true;
      }
      if (flowerbed.length == 1) {
        return flowerbed[0] == 0;
      }
      int start = 0;
      int k = 0;
      for (int i = 0; i < n; i++) {
        for (int j = start; j < flowerbed.length; j++) {
          if (flowerbed[j] == 1) {
            continue;
          }
          if (j == 0) {
            if (flowerbed[j + 1] == 0) {
              k++;
              flowerbed[j] = 1;
              start = j + 1;
              break;
            }
            continue;
          }
          if (j == flowerbed.length - 1) {
            if (flowerbed[j - 1] == 0) {
              k++;
              flowerbed[j] = 1;
              start = j + 1;
              break;
            }
            continue;
          }
          if (flowerbed[j - 1] == 0 && flowerbed[j + 1] == 0) {
            k++;
            flowerbed[j] = 1;
            start = j + 1;
            break;
          }
        }
      }
      return n == k;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] a = {0, 1, 0, 1, 0, 1, 0, 0};
    System.out.println(s.canPlaceFlowers(a, 1));
  }
}
