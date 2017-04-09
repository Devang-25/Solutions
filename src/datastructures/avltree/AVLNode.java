package datastructures.avltree;

public class AVLNode<T extends Comparable<T>> extends Node<T, AVLNode<T>> {

    int height;

    public int getHeight() {
        return height;
    }
}
