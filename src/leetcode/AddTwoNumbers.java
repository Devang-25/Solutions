package leetcode;


public class AddTwoNumbers {


    public static void main(String[] args) {
        ListNode s1 = toList("99");
        ListNode s2 = toList("9");
        print(s1);
        System.out.println();
        print(s2);
        System.out.println();
        final ListNode listNode = new AddTwoNumbers().addTwoNumbers(s1, s2);
        print(listNode);
    }

    private static ListNode toList(String s) {
        ListNode listNode = null;
        for (char c : s.toCharArray()) {
            listNode = new ListNode(Integer.parseInt("" + c), listNode);
        }
        return listNode;
    }

    private static void print(ListNode l) {
        if (l != null) {
            print(l.next);
            System.out.print(l.val);
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode f = null;
        ListNode h = null;
        ListNode i = l1;
        ListNode j = l2;
        int carry = 0;
        while (i != null && j != null) {
            int v = i.val + j.val + carry;
            final ListNode new_ = new ListNode(v % 10);
            carry = v / 10;
            //System.out.println(v+"-> "+carry);
            if (f == null) {
                f = new_;
                h = f;
            } else {
                f.next = new_;
                f = f.next;
            }
            i = i.next;
            j = j.next;
        }
        if (j != null) {
            f = complete(j, carry, f);
        } else {
            f = complete(i, carry, f);
        }
        if (carry != 0) {
            f.next = new ListNode(carry);
        }
        return h;
    }

    private ListNode complete(ListNode i, int carry, ListNode f) {
        while (i != null) {
            int v = i.val + carry;
            carry = v / 10;
            f.next = new ListNode(v % 10);
            f = f.next;
            i = i.next;
        }
        return f;
    }


}



