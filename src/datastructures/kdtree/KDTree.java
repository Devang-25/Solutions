package datastructures.kdtree;

public class KDTree {
    private final int k;

    public KDTree(int k) {
        this.k = k;
    }

    public Node insert(Node root, int point[], int depth) {
        if (root == null) {
            return new Node(point);
        }

        int cd = depth % k;
        if (point[cd] < root.point[cd]) {
            root.left = insert(root.left, point, depth + 1);
        } else {
            root.right = insert(root.right, point, depth + 1);
        }
        return root;
    }

    public Node insert(Node root, int point[]) {
        return insert(root, point, 0);
    }


    class Node {
        int point[]; //k dimensional data.
        Node left;
        Node right;

        public Node(int[] point) {
            this.point = point;
            left = null;
            right = null;
        }
    }


    private boolean areSame(int pointA[], int pointB[]) {
        for (int i = 0; i < k; ++i)
            if (pointA[i] != pointB[i])
                return false;
        return true;
    }

    boolean search(Node root, int point[], int depth) {
        if (root == null) {
            return false;
        }

        if (areSame(root.point, point)) {
            return false;
        }

        int cd = depth % k;
        if (point[cd] < root.point[cd])
            return search(root.left, point, depth + 1);
        return search(root.right, point, depth + 1);
    }


}
