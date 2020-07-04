import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L345 {

  static class Solution {

    public String reverseVowels(String s) {
      Set<Character> characters = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u','A','E','I','O','U'));
      char[] chars = s.toCharArray();
      int i = 0;
      int j = chars.length - 1;
      while (i < j) {
        if (characters.contains(chars[i]) && characters.contains(chars[j])) {
          char t = chars[i];
          chars[i] = chars[j];
          chars[j] = t;
          i++;
          j--;
          continue;
        }
        if (characters.contains(chars[i])) {
          j--;
          continue;
        }
        if (characters.contains(chars[j])) {
          i++;
          continue;
        }
        i++;
        j--;
      }
      return new String(chars);
    }
  }

  public static void main(String[] args) {
    System.out.println("java.class.path========="+System.getProperties().getProperty("java.class.path"));
    Solution solution=new Solution();
    String a="yobkkjaoioshz";
    System.out.println(solution.reverseVowels(a));
  }

}
