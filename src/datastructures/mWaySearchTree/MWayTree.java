/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.mWaySearchTree;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author gopimac
 */
public class MWayTree {

    private Nodelet parentNodlet;

    private Nodelet getMax() {
        return this.root.nodeletsList.get(this.root.nodeletsList.size() - 1);
    }

    private class Node {

        List<Nodelet> nodeletsList;
        private int keySize = 2;
        Nodelet parentNodelet = null;

        Node(int keyVal, Nodelet parentNodelet) {
            this.parentNodelet = parentNodelet;
            nodeletsList = new LinkedList<>();
            nodeletsList.add(new Nodelet(keyVal));
        }

//fix the key size problem
        //make the tree generic..
//test it further
        //reduce redundancy
        //hide unnecessary details.
        @Override
        public String toString() {
            String ret = "";
            for (Nodelet ndl : this.nodeletsList) {
                ret += ndl.keyVal + ", ";
            }
            for (Nodelet ndl : this.nodeletsList) {
                ret += ndl;
            }
            return ret;
        }

        boolean deleteNodelet(int v) {
            ListIterator<Nodelet> i = nodeletsList.listIterator();
            while (i.hasNext()) {
                Nodelet nl = i.next();
                if (v == nl.keyVal) {
                    MWayTree lTree = nl.getLeftTree();
                    MWayTree rTree = nl.getRightTree();
                    //////////////////////////////////////////
                    if (lTree == null && rTree == null) {
                        i.remove();
                        return true;
                    } else if (lTree != null) {
                        /////////////////////////////////////////
                        if (this.nodeletsList.size() == 1) {
                            if (this == this.parentNodelet.rTree.root) {
                                this.parentNodelet.rTree = lTree;
                                lTree.root.parentNodelet = this.parentNodelet;
                                return true;
                            }
                            this.parentNodelet.lTree = lTree;
                            return true;
                        }
                        /////////////////////////////////////////
                        Nodelet n = lTree.getMax();
                        nl.keyVal = n.keyVal;
                        lTree.delete(n.keyVal);
                    } else if (rTree != null) {
                        /////////////////////////////////////////
                        if (this.nodeletsList.size() == 1) {
                            if (this == this.parentNodelet.lTree.root) {
                                this.parentNodelet.lTree = rTree;
                                rTree.root.parentNodelet = this.parentNodelet;
                                return true;
                            }
                            this.parentNodelet.rTree = rTree;
                            return true;
                        }
                        /////////////////////////////////////////
                        Nodelet n = rTree.getMin();
                        nl.keyVal = n.keyVal;
                        rTree.delete(n.keyVal);
                    }
                }
                /////////////////////////////////////
                if (v < nl.keyVal) {
                    MWayTree mTree = nl.getLeftTree();
                    if (mTree != null) {
                        return mTree.delete(v);
                    }
                }
            }
            ///////////////////////////////////////
            return false;
        }

        private boolean search(int v) {
            ListIterator<Nodelet> i = nodeletsList.listIterator();
            while (i.hasNext()) {
                Nodelet nl = i.next();
                ////////////////
                if (v == nl.keyVal) {
                    return true;
                }
                ////////////////
                if (v < nl.keyVal) {
                    MWayTree mTree = nl.getLeftTree();
                    if (mTree != null) {
                        return mTree.search(v);
                    }
                    return false;
                }
            }
            return false;
        }

        boolean insert(int val) {
            ListIterator<Nodelet> i = this.nodeletsList.listIterator();
            Nodelet prev = null, nl = null;
            //////////////////////
            while (i.hasNext()) {
                nl = i.next();
                System.out.println(nl.keyVal);
                //check if the value matches with the key
                if (val == nl.keyVal) {
                    //yes we don't need to insert duplicate..
                    return false;
                }
                //=======================
                if (val < nl.keyVal) {
                    System.out.println(val + "is smaller than encountered " + nl.keyVal);
                    MWayTree tree = nl.getLeftTree();
                    //------------------------
                    if (tree == null) {
                        //do we hv to explore downwards??
                        if (this.nodeletsList.size() < 4) {
                            //can we insert the key here ??
                            Nodelet newNodelet = new Nodelet(val);
                            newNodelet.setLeftTree((prev != null) ? prev.getRightTree() : null);
                            newNodelet.setRightTree(nl.getLeftTree());
                            this.nodeletsList.add(i.previousIndex(), newNodelet);
                            return true;
                        } else {
                            //no,,make it a child..
                            System.out.println("cannot be accomodated here");
                            MWayTree temp = new MWayTree(5, nl);
                            temp.insert(val);
                            nl.setLeftTree(temp);
                            return true;
                        }
                    } //---------------------
                    else {
                        //way down there...search subtree..
                        return tree.insert(val);
                    }
                }
                //==============================
                prev = nl;
            }
            //am at the last,,so be added..
            MWayTree tree = nl.getRightTree();
            if (tree != null) {
                return tree.insert(val);
            }
            if (this.nodeletsList.size() < 4) {
                Nodelet newNodelet = new Nodelet(val);
                newNodelet.setLeftTree(prev.getRightTree());
                newNodelet.setRightTree(null);
                this.nodeletsList.add(newNodelet);
            } else {
                MWayTree temp = new MWayTree(5, nl);
                temp.insert(val);
                nl.setRightTree(temp);
            }
            return true;
        }
    }

    private class Nodelet {

        int keyVal;
        MWayTree lTree, rTree;

        Nodelet(int keyVal) {
            this.keyVal = keyVal;
            this.lTree = this.rTree = null;
        }

        MWayTree getLeftTree() {
            return this.lTree;
        }

        MWayTree getRightTree() {
            return this.rTree;
        }

        void setLeftTree(MWayTree lt) {
            this.lTree = lt;
        }

        void setRightTree(MWayTree rt) {
            this.rTree = rt;
        }

        @Override
        public String toString() {
            String ret = "";
            if (this.lTree != null) {
                ret += "{ " + this.lTree + " }";
            }
            //might be repetion of values here..
            if (this.rTree != null) {
                ret += "{" + this.rTree + "}";
            }
            return ret;
        }
    }
    Node root = null;
    private int keySize = 2;

    MWayTree(int keySize, Nodelet parentNodelet) {
        this.keySize = keySize;
        this.parentNodlet = parentNodelet;
    }

    public MWayTree(int keySize) {
        this.keySize = keySize;
    }

    public MWayTree(int list[]) {
        for (int i : list) {
            insert(i);
        }
    }

    private boolean search(int keyVal) {
        if (this.root == null) {
            //tree is empty
            return false;
        }
        return this.root.search(keyVal);
    }

    public boolean insert(int keyVal) {
        if (this.root == null) {
            System.out.println("Inserting " + keyVal + " root null");
            //tree is empty
            this.root = new Node(keyVal, this.parentNodlet);
            return true;
        }
        System.out.println("Inserting " + keyVal + " root not null now ");
        return this.root.insert(keyVal);
    }

    @Override
    public String toString() {
        Node r = this.root;
        return r.toString();
    }

    public boolean delete(int val) {
        return this.root.deleteNodelet(val);
    }

    private Nodelet getMin() {
        return this.root.nodeletsList.get(0);
    }
}
