package datastructures.btree;

public class BTree {

    private BNode root = null;
    private int maxSize, t, minSize;

    class BNode {

        private node start = new node(Integer.MIN_VALUE);
        private node end = new node(Integer.MAX_VALUE);
        private int size = 0;
        private boolean isLeaf = true;

        private BNode(int key) {
            start.next = end;
            end.previous = start;
            this.insert(key);
        }

        private BNode(node node) {
            start.next = node;
            end.previous = node;
            node.previous = start;
            node.next = end;
            start.rightBNode = node.leftBNode;
            end.leftBNode = node.rightBNode;
            size = 1;
            this.isLeaf = false;
            System.out.println("BNode with size 1 created");
        }

        private BNode(node firstNode, node lastNode, int size, boolean isLeaf) {
            start.next = firstNode;
            firstNode.previous = start;
            end.previous = lastNode;
            lastNode.next = end;
            start.rightBNode = firstNode.leftBNode;
            lastNode.rightBNode = end.leftBNode;
            this.size = size;
            System.out.println("New BNode created with size " + size);
            this.isLeaf = isLeaf;
        }

        private node findMedian() {
            node i = start.next;
            node fastI = start.next;
            while (fastI.next != end) {
                i = i.next;
                fastI = fastI.next;
                if (fastI.next != end) {
                    fastI = fastI.next;
                }
            }
            return i;
        }

        class node {

            int key;
            node next;
            node previous;
            BNode leftBNode;
            BNode rightBNode;

            public node(int key) {
                this.key = key;
            }

            private node() {
            }

            @Override
            public String toString() {
                return " " + key + ((this.leftBNode != null) ? "{" + this.leftBNode + "}" : "");
            }
        }

        @Override
        public String toString() {
            StringBuilder b = new StringBuilder();
            node i = this.start.next;
            String s = "SIZE[" + size + "]";
            String leaf = "LEAF[" + isLeaf + "]";
            b.append(s);
            b.append(leaf);
            while (i != end) {
                b.append(i);
                i = i.next;
            }
            b.append((end.leftBNode != null) ? "{" + end.leftBNode + "}" : "");
            return b.toString();
        }

        public final int insert(int val) {
            node i = this.start.next;
            while (i != null) {
                if (val < i.key) {
                    BNode childNode = i.leftBNode;
                    if (childNode != null) {
                        System.out.println(i.key + " has a left bNode down \n jumping down");
                        if (childNode.getSize() == maxSize) {
                            node fixedUpNode = childNode.splitFixUp();
                            this.isLeaf = false;
                            System.out.println("Fixed up node details: " + fixedUpNode);
                            this.sandwich(i.previous, i, fixedUpNode);
                            if (val < fixedUpNode.key) {
                                i = fixedUpNode;
                            }
                            size++;
                        }
                        System.out.println(i);
                        return i.leftBNode.insert(val);
                    }
                    this.sandwich(i.previous, i, new node(val));
                    size++;
                    return 1;
                }
                i = i.next;
                System.out.println("step right");
            }
            return 0;
        }

        public int getSize() {
            return this.size;
        }

        int delete(int key) {
            node i = this.start.next;
            while (i != null) {
                if (key == i.key) {
                    if (this.isLeaf) {
                        if (this.size > minSize) {
                            node left = i.previous;
                            node right = i.next;
                            left.next = right;
                            right.previous = left;
                            return 1;
                        } else {//means node does hv min size and can't be reduced further..

                        }
                    } else {
                        if (i.leftBNode.getSize() > minSize) {
                            node predecessor = i.leftBNode.end.previous;
                            i.key = predecessor.key;
                            i.leftBNode.delete(predecessor.key);
                        } else if (i.rightBNode.getSize() > minSize) {
                            node successor = i.rightBNode.start.next;
                            i.key = successor.key;
                            i.rightBNode.delete(successor.key);
                        } else {
                            node pre = i.previous;
                            node suc = i.next;
                            BNode leftChild = i.leftBNode;
                            BNode rightChild = i.rightBNode;
                            node leftLastChild = leftChild.end.previous;
                            node rightFirstChild = rightChild.start.next;
                            leftLastChild.next = rightFirstChild;
                            rightFirstChild.previous = leftLastChild;
                            leftLastChild.rightBNode = rightFirstChild.leftBNode;
                            BNode bNode = new BNode(leftChild.start.next, rightChild.end.previous, maxSize, rightChild.isLeaf);
                            pre.rightBNode = bNode;
                            suc.leftBNode = bNode;
                        }
                        return 1;
                    }
                } else if (key < i.key) {
                    if (this.isLeaf) {
                        return 0;
                    }
                    return i.leftBNode.delete(key);
                }
                i = i.next;
            }
            return 0;
        }

        node splitFixUp() {
            System.out.println("Calling split fixup");
            if (this.size == maxSize) {
                node median = this.findMedian();
                System.out.println("in split func:Median is :" + median);
                BNode y = new BNode(this.start.next, median.previous, (this.size - 1) / 2, this.isLeaf);
                BNode z = new BNode(median.next, this.end.previous, (this.size - 1) / 2, this.isLeaf);
                node parent = new node(median.key);
                parent.leftBNode = y;
                parent.rightBNode = z;
                return parent;
            }
            System.out.println("Split fix up failed");
            return null;
        }

        private void sandwich(node left, node right, node toBeSandwitched) {
            //tobeSandwitched is set between left and right node..
            left.next = toBeSandwitched;
            toBeSandwitched.previous = left;
            right.previous = toBeSandwitched;
            toBeSandwitched.next = right;
            left.rightBNode = toBeSandwitched.leftBNode;
            right.leftBNode = toBeSandwitched.rightBNode;
        }
    }

    public BTree(int t) {
        this.t = t;
        this.minSize = t - 1;
        this.maxSize = 2 * t - 1;
    }

    public BTree(int ar[], int maxSizeOfNode) {
        for (int i : ar) {
            this.insert(i);
        }
        this.maxSize = maxSizeOfNode;
    }

    public final void insert(int key) {
        System.out.println("BTree:Insert" + key);
        if (this.root == null) {
            System.out.println("This is the first node of the tree");
            this.root = new BNode(key);
            return;
        }
        if (this.root.getSize() == this.maxSize) {
            //if bnode's max, then it must be split.
            BNode temp = new BNode(this.root.splitFixUp());
            System.out.println(temp);
            this.root = temp;
        }
        //then we move on.
        this.root.insert(key);
    }

    @Override
    public String toString() {
        return this.root.toString();
    }

    public void delete(int key) {
        if (this.root == null) {
            return;
        }
        this.root.delete(key);
    }
}
