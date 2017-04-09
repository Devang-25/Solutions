/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.lists;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author gopimac
 */
public class DoublyLinkedList {

    class Node {

        int data;
        Node next;
        Node previous;

        Node(int data) {
            this.data = data;
            this.next = this.previous = null;
        }

        private Node() {
        }
    }
    private Node head, tail;

    public DoublyLinkedList() {
        head = new Node(0);
        tail = null;
    }

    public DoublyLinkedList(int array[]) {
        head = new Node(0);
        tail = null;
        for (int i : array) {
            this.insertAtEnd(i);
        }
    }

    boolean insertAtBegin(int data) {
        Node temp = new Node(data);
        if (tail == null) {
            this.head.next = temp;
            temp.previous = this.head;
            this.tail = temp;
        } else {
            Node first = this.head.next;
            temp.next = first;
            first.previous = temp;
            this.head.next = temp;
            temp.previous = this.head;
        }
        this.head.data++;
        return true;
    }

    public void insertAtBeg(Collection<Integer> list) {
        Iterator<Integer> i = list.iterator();
        while (i.hasNext()) {
            this.insertAtBegin(i.next());
        }
    }

    @Override
    public String toString() {
        Node current = this.head.next;
        String arr = "{ " + this.head.data + " }\t";
        while (current != null) {
            arr += current.data + "\t";
            current = current.next;
        }
        return arr;
    }

    final boolean insertAtEnd(int data) {
        if (tail == null) {
            this.insertAtBegin(data);
        } else {
            Node temp = new Node(data);
            temp.previous = this.tail;
            this.tail.next = temp;
            this.head.data++;
            this.tail = temp;
        }
        return true;
    }

    boolean insert(int data, int position) {
        if (position == 1) {
            this.insertAtBegin(data);
        } else if (position > this.head.data) {
            this.insertAtEnd(data);
        } else {
            int i = 1;
            Node cN = this.head;
            while (i < position) {
                cN = cN.next;
                i++;
            }
            System.out.println(i);
            Node temp = new Node(data);
            cN.next.previous = temp;
            temp.next = cN.next;
            temp.previous = cN;
            cN.next = temp;
            this.head.data++;
        }
        return true;
    }

    boolean deleteAtFirst() {
        if (this.tail == null) {
            return false;
        }
        //if(this.head.next=tail)
        if (this.head.data == 1) {
            this.head.next = null;
            this.tail = null;
            this.head.data = 0;
        } else {
            Node toBeDeleted = this.head.next;
            this.head.next = toBeDeleted.next;
            toBeDeleted.next.previous = this.head;
            this.head.data--;
        }
        return true;
    }

    boolean deleteAtLast() {
        if (tail == null) {
            return false;
        }
        if (this.head.data == 1) {
            this.deleteAtFirst();
        } else {
            Node toBeLast = this.tail.previous;
            toBeLast.next = null;
            this.tail = toBeLast;
            this.head.data--;
        }
        return true;
    }

    boolean deleteElement(int data) {
        Node current = this.head.next;
        if (current.data == data) {
            this.deleteAtFirst();
            return true;
        }
        if (tail.data == data) {
            this.deleteAtLast();
            return true;
        }
        current = current.next;
        while (current != null) {
            if (current.data == data) {
                current.next.previous = current.previous;
                current.previous.next = current.next;
                this.head.data--;
                return true;
            }
            current = current.next;
        }
        System.out.println("element not found " + data);
        return false;
    }

    boolean deleteAtPos(int pos) {
        if (pos <= 0) {
            return false;
        }
        if (pos == 1) {
            this.deleteAtFirst();
            return true;
        }
        if (pos == this.head.data) {
            this.deleteAtLast();
            return true;
        }
        if (pos > this.head.data) {
            System.out.println("Invalid position");
            return false;
        }
        Node current = this.head.next;
        int i = 1;
        while (i < pos) {
            current = current.next;
            i++;
        }
        current.next.previous = current.previous;
        current.previous.next = current.next;
        this.head.data--;
        return true;
    }
    //find the nth node from the end of a linkedList
    /*assuming it is a single linked list*/

    int findNth(int n) {
        Node nthNode, temp;
        nthNode = temp = this.head.next;
        int i = 0;
        while (i < n && temp != null) {
            temp = temp.next;
            i++;
        }
        System.out.println(i);
        if (temp == null) {
            System.out.println("too few elements ");
            throw new NoSuchElementException("too few elements");
        }
        while (temp != null) {
            temp = temp.next;
            nthNode = nthNode.next;
        }
        System.out.println("::" + nthNode.data);
        return nthNode.data;
    }

    public void swapElements() {
        Node i = this.head.next;
        while (i != null && i.next != null) {
            Node a = i;
            Node b = i.next;
            if (b.next != null) {
                b.next.previous = a;
                a.next = b.next;
            } else {
                a.next = null;
            }
            b.next = a;
            b.previous = a.previous;
            a.previous.next = b;
            a.previous = b;
            i = i.next;
        }
    }

    //for a given k ,reverse blocks of k nodes in a list
    void reverseFirstK(int k) {
        if (k < 0 || k > this.head.data) {
            return;//do nothing
        }
        int i = 1;
        Node cur = this.head;
        while (i <= k) {
            cur = cur.next;
            i++;
        }
        System.out.println(cur.data);
        Node l = this.head.next;
        System.out.println(l.data);
        this.head.next = cur.next;
        cur.next.previous = this.head;
        cur.next=null;
        while (l != null) {
            Node f=l.next;
            l.next = this.head.next;
            this.head.next.previous = l;
            this.head.next = l;
            l.previous = this.head;
            l=f;
        }
    }
}
