package datastructures.tree;

import datastructures.btree.BTree;

public class Main {

    public static void main(String[] args) {

        int[] ar = {12, 14, 1, 89, 34, 24, 119, 10, 90, 9, 22,13,11,45,60,65,80,82,85,117};
        BTree tree = new BTree(3);
        for (int i : ar) {
            tree.insert(i);
            System.out.println(tree);
        }
        /*String s[] = {"mandeep", "herji", "mandy", "palvi", "pearl", "manmeet", "komal", "gul", "ravi", "mansi", "love", "bir", "preet", "lite"};
        Collection<Pair<Integer, String>> col = new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
        col.add(new Pair<Integer, String>(a[i], s[i]));
        }
        SimpleRegxDemo srd = new SimpleRegxDemo();
        RegexEngine rexEg=new RegexEngine("\\s?");
        //ab*|(c*d)mk*(d|i*)*|ef|gk..cdmkd
        rexEg.match("");*/
        //http://videos.howstuffworks.com/computer/home-network-videos-playlist.htm#video-964
        //SimpleRegxDemo r = new SimpleRegxDemo();
        // r.fixIceCream();
            /*ExpressionEvaluator bt=new ExpressionEvaluator();
        String eq=bt.getExpressionFromConsole();
        System.out.println(eq);
        bt.getValuesFromConsole();
        System.out.println(bt.evaluatePostFixExpression());*/
        //System.out.println(binaryTree.getDeepestNode().val);
            /*GTreeInterface treeInterface = new RedBlackTree();
        int a[] = {12, 24, 1, 8, 54, 28, 76, 41, 9, 110, 20};
        int sum=0;
        for (int i : a) {
        treeInterface.insert(i);
        treeInterface.inOrder();
        }
        treeInterface.inOrder();*/


    }
}
