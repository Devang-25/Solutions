package leetcode;

import java.util.*;
import java.util.stream.Collectors;


public class NestedIterator implements Iterator<Integer> {


    public static void main(String[] args) {
        Object[] l = new Object[]{1, 2, new Object[]{4, new Object[]{5}, 6}, new Object[]{}, new Object[]{}, new Object[]{3, 4}};
        final NestedIterator nestedIterator = new NestedIterator(make(l));
        while (nestedIterator.hasNext()) {
            System.out.println(nestedIterator.next());
        }
    }

    private static List<NestedInteger> make(Object[] l) {
        return Arrays.stream(l).map(x -> {
            if (x instanceof Integer) {
                return new NestedInteger() {
                    @Override
                    public boolean isInteger() {
                        return true;
                    }

                    @Override
                    public Integer getInteger() {
                        return (Integer) x;
                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return null;
                    }
                };
            } else {
                return new NestedInteger() {
                    @Override
                    public boolean isInteger() {
                        return false;
                    }

                    @Override
                    public Integer getInteger() {
                        return null;
                    }

                    @Override
                    public List<NestedInteger> getList() {
                        return make((Object[]) x);
                    }
                };
            }
        }).collect(Collectors.toList());
    }

    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        if (nestedList == null)
            return;

        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            NestedInteger top = stack.peek();
            if (top.isInteger()) {
                return true;
            } else {
                stack.pop();
                for (int i = top.getList().size() - 1; i >= 0; i--) {
                    stack.push(top.getList().get(i));
                }
            }
        }

        return false;
    }
}

interface NestedInteger {

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
