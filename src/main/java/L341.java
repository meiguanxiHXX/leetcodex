import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class L341 {

  // This is the interface that allows for creating nested lists.
  // You should not implement it, or speculate about its implementation
  public interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
  }

  public static class NestedIterator implements Iterator<Integer> {

    List<Integer> a;
    int pos;

    public NestedIterator(List<NestedInteger> nestedList) {
      a = new ArrayList<>();
      dfs(nestedList);
      pos = 0;
    }

    private void dfs(List<NestedInteger> nestedList) {
      for (int i = 0; i < nestedList.size(); i++) {
        NestedInteger nestedInteger = nestedList.get(i);
        if (nestedInteger.isInteger()) {
          a.add(nestedInteger.getInteger());
          continue;
        }
        dfs(nestedInteger.getList());
      }
    }

    @Override
    public Integer next() {
      return a.get(pos++);
    }

    @Override
    public boolean hasNext() {
      return pos < a.size();
    }
  }

}
