/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.lists;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author gopimac
 */
public class LinkedList {

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
    Node head, head_;

    public LinkedList() {
    }
//we deliberately create a cycle...

    public void prepareTest() {
        //we create a part consisting of 3 nodes and attach it to a cycle of 6 nodes
        int arr[] = {1, 2, 3, 4};
        int cycArr[] = {5, 6, 7, 8, 9, 10, 11, 12};
        this.head = new Node(arr[0]);
        Node t = this.head;
        for (int i = 1; i < arr.length; i++) {
            t.next = new Node(arr[i]);
            t = t.next;
        }
        Node cycleHead = new Node(cycArr[0]);
        t.next = cycleHead;
        t = cycleHead;
        for (int i = 1; i < cycArr.length; i++) {
            t.next = new Node(cycArr[i]);
            t = t.next;
        }
        t.next = cycleHead;
    }

    public void display() {
        Node current = this.head;
        while (current != null) {
            System.out.print(current.data + "\t");
            System.out.flush();
            current = current.next;
        }
    }

    void checkIfLoopExists() {
        //algorithm 1
        //brute force...
        Node i = this.head;
        Node j = this.head;
        while (i != null) {
            while (j != null) {
                if (i != j) {
                    System.out.println(i.data + "__" + j.data);
                    if (i == j.next) {
                        System.out.println("loop exits: " + j.data);
                        return;
                    }
                }
                j = j.next;
            }
            j = this.head;
            i = i.next;
        }
    }

    //floyd's cycle finding algorithm
    void checkFloydsway() {
        //fast and slow pointer concept...
        //another way to say that..tortoise  and hare race..
        Node fastPointer = this.head.next;
        Node slowPointer = this.head;
        if (fastPointer == slowPointer) {
            System.out.println("loop");
            return;
        }
        while (slowPointer != fastPointer) {
            System.out.println(slowPointer.data + ":" + fastPointer.data);
            fastPointer = fastPointer.next;
            if (fastPointer == slowPointer) {
                System.out.println("1_loop");
                return;
            }
            if (fastPointer == null) {
                System.out.println("end");
                return;
            }
            fastPointer = fastPointer.next;
            if (fastPointer == slowPointer) {
                System.out.println("2_loop");
                return;
            }
            slowPointer = slowPointer.next;
        }
        System.out.println("3_loop");
    }

    //intersecting linkedlists problem..
    void prepareTest2() {
        this.head = null;
        int llist[] = {1, 2};
        int llist_[] = {3, 4, 5};
        int common[] = {6, 7};
        Node t = null;
        this.head = new Node(llist[0]);
        t = head;
        for (int i = 1; i < llist.length; i++) {
            t.next = new Node(llist[i]);
            t = t.next;
        }
        Node t_ = null;
        this.head_ = new Node(llist_[0]);
        t_ = head_;
        for (int i = 1; i < llist_.length; i++) {
            t_.next = new Node(llist_[i]);
            t_ = t_.next;
        }
        Node c = null;
        c = new Node(common[0]);
        t.next = c;
        t_.next = c;
        for (int i = 1; i < common.length; i++) {
            c.next = new Node(common[i]);
            c = c.next;
        }
        c.next = null;
        this.print(this.head);
        System.out.println();
        this.print(this.head_);
    }

    void print(Node cur) {
        while (cur != null) {
            System.out.print(cur.data + "\t");
            cur = cur.next;
        }
    }
//this is the brute force method..

    void checkIfIntersect() {
        Node l = this.head;
        Node l_ = this.head_;
        while (l != null) {
            while (l_ != null) {
                System.out.print(l.data + "__" + l_.data + "\t");
                if (l == l_.next) {
                    System.out.println("\nintersection" + l.data);
                    return;
                }
                l_ = l_.next;
            }
            System.out.println();
            l_ = this.head_;
            l = l.next;
        }
    }
    //using sorting method..

    public void checkSortWay() {
        //incomplete code
        int count = 0;
        Node cur = this.head;
        while (cur != null) {
            count++;
            System.out.print(cur + ":" + cur.hashCode() + "\t");
            cur = cur.next;
        }
        Node arr[] = new Node[count];

        Arrays.sort(arr, new Comparator<Node>() {

            public int compare(Node o1, Node o2) {
                return o1.hashCode() - o2.hashCode();
            }
        });

        cur = this.head_;
        count = 0;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        Node arr_[] = new Node[count];
        Arrays.sort(arr_, new Comparator<Node>() {

            public int compare(Node o1, Node o2) {
                return o1.hashCode() - o2.hashCode();
            }
        });
        int i = 0, j = 0;
        while (i < arr.length && j < arr_.length) {
            if (arr[i].hashCode() < arr_[j].hashCode()) {
                i++;
            } else if (arr[i].hashCode() > arr_[j].hashCode()) {
                j++;
            } else {
                System.out.println(arr[i].data);
                return;
            }
        }
    }
}
