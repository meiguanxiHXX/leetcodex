public class L206ReverseList {

  static class Solution {

    public ListNode reverseList(ListNode head) {
      ListNode p1 = null;
      ListNode p2 = head;
      ListNode p3 = null;
      while (p2 != null) {
        p3 = p2.next;
        p2.next = p1;
        p1 = p2;
        p2 = p3;
      }
      return p1;
    }
  }

}
