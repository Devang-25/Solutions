/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.ternerySearchTree;

/**
 *
 * @author gopimac
 */
/*yet to be tested.*/
public class TernarySearchTree {

    class node {

        char data;
        boolean isEnd;
        node leftNode, eqNode, rightNode;

        node(char data, boolean isEnd) {
            this.data = data;
            this.isEnd = isEnd;
        }
    }

    node insert(node root, char[] word, int index) {
        if (root == null) {
            node temp = new node(word[index], false);
        }
        if (word[index] < root.data) {
            //index will be incremented only when the matching occurs....
            root.leftNode = this.insert(root.leftNode, word, index);
        } else if (word[index] == root.data) {
            if (index + 1 == word.length) {
                root.isEnd = true;
            } else {
                root.eqNode = this.insert(root.eqNode, word, ++index);
            }
        } else {
            root.rightNode = this.insert(root.rightNode, word, index);
        }
        return root;
    }

    boolean searchWord(node root, char[] word, int index) {
        if (root == null) {
            return false;
        }
        if (word[index] < root.data) {
            return this.searchWord(root.leftNode, word, index);
        }
        if (word[index] > root.data) {
            return this.searchWord(root.rightNode, word, index);
        }
        if (root.isEnd && index+1 == word.length) {
            return true;
        }
        return this.searchWord(root.eqNode, word, ++index);
    }

    boolean searchWordIterative(node root, char[] word, int index) {
        while (root != null) {
            if (word[index] < root.data) {
                root = root.leftNode;
            } else if (word[index] > root.data) {
                root = root.rightNode;
            } else {
                if (root.isEnd && index+1 == word.length) {
                    return true;
                } else {
                    root = root.eqNode;
                    index++;
                }
            }
        }
        return false;
    }
}
