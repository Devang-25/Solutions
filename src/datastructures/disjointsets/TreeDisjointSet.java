/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.disjointsets;


/**
 *
 * @author gopimac
 */
public class TreeDisjointSet implements DisjointSet {

    Vertex head;
    DisjointSetPlugin plugin;
//plugin not supported yet

    private TreeDisjointSet() {
    }

    public TreeDisjointSet(Vertex v) {
        this.head = v;
        v.representative = v;
    }

    //path compression has not been supported yet.
    public Vertex findSet(Vertex v) {
        Vertex i = v;
        while (i.representative != i) {
            i = i.representative;
        }
        return i.representative;
    }

    public void union(Vertex V) {
        Vertex v = this.findSet(V);
        System.out.println("head is " + this.head.getVertexId());
        System.out.println("findset for " + V.getVertexId() + " is " + v.getVertexId());
        this.link(v);
    }

    private void link(Vertex y) {
        System.out.println(this.head.getVertexId() + " 's rank is" + this.head.rank + " , "
                + y.getVertexId() + " 's rank is" + y.rank);
        if (this.head.rank < y.rank) {
            this.head.representative = y;
            this.head.next = y.firstChild;
            y.firstChild = this.head;
            this.head = y;
            System.out.println(this.head.getVertexId());
        } else {
            y.representative = this.head;
            y.next = this.head.firstChild;
            this.head.firstChild = y;
        }
        if (this.head.rank == y.rank) {
            this.head.rank++;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        String temp = "[" + this.head.getVertexId() + "]{";
        str.append(temp);
        Vertex i = this.head;
        while (i.firstChild != null) {
            i = i.firstChild;
        }
        while (i.representative != i) {
            while (i.next != null) {
                str.append(i.getVertexId());
                str.append(",");
                i = i.next;
            }
            str.append(i.getVertexId());
            str.append(",");
            i = i.representative;
            //str.append(i.getVertexId());
            //str.append(",");
        }
        //str.deleteCharAt(str.length() - 1);
        str.append("}");
        return str.toString();
    }
}
