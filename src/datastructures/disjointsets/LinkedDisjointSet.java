/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.disjointsets;


/**
 *
 * @author gopimac
 */
public class LinkedDisjointSet implements DisjointSet{

    Vertex head, tail;

    public LinkedDisjointSet(Vertex V) {
        head = tail = this.makeSet(V);
    }

    private Vertex makeSet(Vertex V) {
        V.representative = V;
        return V;
    }

    public Vertex findSet(Vertex V) {
        return V.representative;
    }

    public void union(Vertex V) {
        Vertex rep = this.findSet(V);
        tail.next = rep;
        while (rep != null) {
            rep.representative = head;
            tail = rep;
            rep = rep.next;
        }

    }

    @Override
    public String toString() {
        String str = "{ ";
        Vertex v = this.head;
        while (v != null) {
            str += v.getVertexId() + ",";
            v = v.next;
        }
        str += "}";
        return str;
    }
}
