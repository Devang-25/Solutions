/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.stack.expressions;

import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 *
 * @author gopimac
 */
public class Stack {

    LinkedList<String> list = new LinkedList<>();

    void push(String  c) {
        list.addFirst(c);
    }

   String pop() {
        return list.removeFirst();
    }

   String top() throws NoSuchElementException{
       return list.element();
   }
   boolean isEmpty(){
       return list.isEmpty();
   }
}
