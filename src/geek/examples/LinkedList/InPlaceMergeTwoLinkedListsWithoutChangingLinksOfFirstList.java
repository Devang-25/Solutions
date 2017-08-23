package geek.examples.LinkedList;

public class InPlaceMergeTwoLinkedListsWithoutChangingLinksOfFirstList {
    public static void main(String[] args) {
        Node l1 = createNode(new int[]{2, 4, 7, 8, 10});
        display(l1);
        Node i=l1;
        Node l2 = createNode(new int[]{1, 3, 12});
        display(l2);
        Node j=l2;
        while (i != null && j != null) {
            if (i.data > j.data) {
                swap(i, j);
                if (j.next != null && j.data > j.next.data) {
                    Node x = j;
                    j = j.next;
                    Node prev = x.next;
                    while (prev.next != null && x.data > prev.next.data) {
                        prev = prev.next;
                    }
                    x.next = prev.next;
                    prev.next = x;
                }
            }
            i = i.next;
        }
        display(l1);
        display(l2);
    }

    private static void display(Node x) {
        System.out.println("display");
        while (x != null) {
            System.out.print(x.data + "->");
            x = x.next;
        }
        System.out.println("#");
    }

    private static void swap(Node i, Node j) {
        int val = i.data;
        i.data = j.data;
        j.data = val;
    }

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static Node createNode(int arr[]) {
        Node s = new Node(arr[0]);
        Node start=s;
        for (int i = 1; i < arr.length; i++) {
            s.next = new Node(arr[i]);
            s = s.next;
        }
        return start;
    }
}
