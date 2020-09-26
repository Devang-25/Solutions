package leetcode;

public class MergekSortedLists {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + "->" + next;
        }
    }


    public static void main(String[] args) {
        final int[][] lists = {{1, 4, 5}, {}, {2, 6}};
        ListNode[] nodes = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            ListNode node = null;
            for (int j = lists[i].length - 1; j >= 0; j--) {
                if (j == lists[i].length - 1) {
                    node = new ListNode(lists[i][j]);
                } else {
                    node = new ListNode(lists[i][j], node);
                }
            }
            nodes[i] = node;
        }
        for (int i = 0; i < nodes.length; i++) {
            System.out.println(nodes[i]);
        }
        final ListNode listNode = new MergekSortedLists().mergeKLists(nodes);
        System.out.println(listNode);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null;
        ListNode current = null;

        int minIndex;
        while ((minIndex = findMinIndex(lists)) != -1) {
            System.out.println(minIndex);
            final ListNode minNode = lists[minIndex];
            if (current == null) {
                head = minNode;
                current = head;
            } else {
                current.next = minNode;
                current = current.next;
            }
            lists[minIndex] = lists[minIndex].next;
            System.out.println(lists[minIndex]);
        }
        return head;
    }

    private int findMinIndex(ListNode[] lists) {
        int minIndex = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                if (lists[i].val < min) {
                    min = lists[i].val;
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }

}
