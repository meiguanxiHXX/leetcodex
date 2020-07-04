public class L83 {

  static class Solution {

    public ListNode deleteDuplicates(ListNode head) {
      ListNode p1 = head;
      ListNode p2 = head;
      while (p1 != null) {
        while (p2 != null && p1.val == p2.val) {
          p2 = p2.next;
        }
        p1.next = p2;
        p1 = p1.next;
      }
      return head;
    }
  }

}
