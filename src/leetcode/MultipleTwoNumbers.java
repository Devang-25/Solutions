package leetcode;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class MultipleTwoNumbers {


    public static void main(String[] args) {
        System.out.println(new MultipleTwoNumbers().multiple("99", "99"));
    }

    private String multiple(String s1, String s2) {
        if (s1.equals("0")|| s2.equals("0")) {
            return "0";
        }
        final ListNode A = toList(s1);
        ListNode f = new ListNode(0);
        final char[] chars = s2.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            int factor = Integer.parseInt(chars[i] + "");
            ListNode row_ = new MultipleTwoNumbers().multipleTwoNumbers(A, factor, chars.length - 1 - i);
            f = new MultipleTwoNumbers().addTwoNumbers(row_, f);
        }
        ListNode p = f;
        List<String> str = new ArrayList<>();
        while (p != null) {
            str.add(p.val + "");
            p = p.next;
        }
        Collections.reverse(str);
        return String.join("", str);
    }

    private static ListNode toList(String s) {
        ListNode listNode = null;
        for (char c : s.toCharArray()) {
            listNode = new ListNode(Integer.parseInt("" + c), listNode);
        }
        return listNode;
    }

    public ListNode multipleTwoNumbers(ListNode l1, int factor, int l) {
        ListNode f = null;
        ListNode h = null;
        ListNode i = l1;
        int carry = 0;
        for (int j = 0; j < l; j++) {
            if (f == null) {
                f = new ListNode(0);
                h = f;
            } else {
                f.next = new ListNode(0);
                f = f.next;
            }
        }
        while (i != null) {
            int v = i.val * factor + carry;
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
        }
        if (carry != 0) {
            f.next = new ListNode(carry);
            f = f.next;
        }
        return h;
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
        if (j == null) {
            while (i != null) {
                int v = i.val + carry;
                carry = v / 10;
                f.next = new ListNode(v % 10);
                f = f.next;
                i = i.next;
            }
        } else {
            while (j != null) {
                int v = j.val + carry;
                carry = v / 10;
                f.next = new ListNode(v % 10);
                f = f.next;
                j = j.next;
            }
        }
        if (carry != 0) {
            f.next = new ListNode(carry);
        }
        return h;
    }

}
