package leetcode;

public class RotateList {


    public static void main(String[] args) {
        final ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(listNode);
        final ListNode rotated = new RotateList().rotateRight(listNode, 2);
        System.out.println(rotated);


    }

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
            return val + "->" + ((next != null) ? next.toString() : "");
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (k == 0) {
            return head;
        }
        ListNode cur = head;
        int l = 0;
        while (cur.next != null) {
            l++;
            cur = cur.next;
        }
        ListNode last = cur;
        l++;
        System.out.println(l);
        int offset = l - k % l;
        cur = head;
        int pos = 1;
        while (pos != offset) {
            cur = cur.next;
            pos++;
        }
        last.next = head;
        head = cur.next;
        cur.next = null;
        return head;
    }

}
