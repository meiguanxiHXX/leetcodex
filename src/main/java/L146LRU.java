import java.util.HashMap;
import java.util.Map;

public class L146LRU {

  static class LRUCache {

    private static class Pair {

      int key;
      int value;

      public Pair(int key, int value) {
        this.key = key;
        this.value = value;
      }
    }

    private static class ListNode {

      Pair val;
      ListNode next;
      ListNode pre;

      ListNode(int key, int value) {
        val = new Pair(key, value);
      }
    }

    private int cacheSize;
    private int currentSize = 0;
    private ListNode head;
    private ListNode tail;
    private Map<Integer, ListNode> m = new HashMap<>();

    public LRUCache(int capacity) {
      cacheSize = capacity;
    }

    public int get(int key) {
      if (!m.containsKey(key)) {
        return -1;
      }

      ListNode node = m.get(key);
      touch(node);
      return node.val.value;
    }

    public void put(int key, int value) {
      if (m.containsKey(key)) {
        ListNode node = m.get(key);
        node.val.value = value;
        touch(node);
        return;
      }

      ListNode node = new ListNode(key, value);
      if (currentSize < cacheSize) {
        if (head == null) {
          head = node;
          tail = head;
        } else {
          node.pre = tail;
          tail.next = node;
          tail = tail.next;
        }

        m.put(key, node);
        currentSize++;
      } else {
        if (head == null) {
          return;
        }

        node.pre = tail;
        tail.next = node;
        tail = tail.next;
        int removeKey = head.val.key;
        head = head.next;
        head.pre = null;

        m.remove(removeKey);
        m.put(key, node);
      }

    }

    private void touch(ListNode node) {
      if (currentSize == 1) {
        return;
      }

      ListNode pre = node.pre;
      ListNode next = node.next;
      if (next != null) {
        next.pre = pre;
      } else {
        return;
      }
      if (pre != null) {
        pre.next = next;
      } else {
        head = next;
      }
      node.pre = tail;
      tail.next = node;
      tail = tail.next;
    }
  }

  /**
   * Your LRUCache object will be instantiated and called as such: LRUCache obj = new LRUCache(capacity); int param_1 =
   * obj.get(key); obj.put(key,value);
   */

  public static void main(String[] args) {
    LRUCache lruCache = new LRUCache(3);
    lruCache.put(2, 2);
    lruCache.put(3, 3);
    System.out.println(lruCache.get(3));
    System.out.println(lruCache.get(2));
    lruCache.put(4, 4);
    System.out.println(lruCache.get(2));
    System.out.println(lruCache.get(3));
    System.out.println(lruCache.get(4));
    lruCache.put(2, 2);
    lruCache.put(4, 4);
    lruCache.put(3, 3);
    lruCache.put(5, 5);
    System.out.println(lruCache.get(2));
    System.out.println(lruCache.get(3));
    System.out.println(lruCache.get(4));
    System.out.println(lruCache.get(5));
  }

}
