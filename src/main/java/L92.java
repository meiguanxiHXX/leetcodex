public class L92 {

  static class Solution {

    public ListNode reverseBetween(ListNode head, int m, int n) {
      if (head == null) {
        return head;
      }
      if (m == n) {
        return head;
      }

      int k = n - m;
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode p1 = dummy;
      while (m > 1) {
        p1 = p1.next;
        m--;
      }
      ListNode subHead = p1.next;
      ListNode p2 = subHead;
      while (k > 0) {
        p2 = p2.next;
        k--;
      }
      ListNode subTail = p2;
      ListNode subTailNext = p2.next;

      ListNode newSubHead = reverseSubList(subHead, subTail);
      p1.next = newSubHead;
      subHead.next = subTailNext;
      return dummy.next;

    }

    private ListNode reverseSubList(ListNode head, ListNode tail) {
      if (head == null) {
        return head;
      }
      ListNode p1 = null;
      ListNode p2 = head;
      ListNode p3 = null;
      while (p2 != tail) {
        p3 = p2.next;
        p2.next = p1;
        p1 = p2;
        p2 = p3;
      }
      p2.next = p1;
      return tail;
    }
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    ListNode p1 = head;
    p1.next = new ListNode(2);
    p1 = p1.next;
    p1.next = new ListNode(3);
    p1 = p1.next;
    p1.next = new ListNode(4);
    p1 = p1.next;
    p1.next = new ListNode(5);
    p1 = p1.next;

    Solution solution = new Solution();
    ListNode listNode = solution.reverseBetween(head, 2, 4);
    while (listNode != null) {
      System.out.println(listNode.val);
      listNode = listNode.next;
    }

  }

}
