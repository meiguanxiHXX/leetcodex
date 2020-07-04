import java.util.*;

public class L347Collection {

  static class Solution {

    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer, Integer> m = new HashMap<>();
      for (int i = 0; i < nums.length; i++) {
        int count = m.getOrDefault(nums[i], 0);
        count++;
        m.put(nums[i], count);
      }

      /*
      * compareTo和compare: this<other(或者o1<o2)返回-1是正序，返回1是倒序
      * */
      List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(m.entrySet());
      Collections.sort(entries, (o1, o2) -> {
        if (o1.getValue() > o2.getValue()) {
          return -1;
        }
        if (o1.getValue() < o2.getValue()) {
          return 1;
        }
        return 0;
      });

      List<Integer> arrayList = new ArrayList<>();
      for (Map.Entry<Integer, Integer> entry : entries) {
        arrayList.add(entry.getKey());
      }

      List<Integer> ans = arrayList.subList(0, k);
      return ans.stream().mapToInt(i -> i).toArray();
    }
  }

}
