/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.graph;

/**
 *
 * @author gopimac
 */
public class Edge implements Comparable<Edge> {

    private int v, w;
    private int weight;

    public int getWeight() {
        return weight;
    }

    public Edge(int v, int w) {
        if (v == w) {
            throw new IllegalArgumentException("Self Loop creation prohibited");
        }
        this.v = v;
        this.w = w;
    }

    public Edge(int v, int w, int wieght) {
        this.v = v;
        this.w = w;
        this.weight = wieght;
    }

    public int getV() {
        return v;
    }

    public int getW() {
        return w;
    }

    @Override
    public String toString() {
        return v + "-" + w+";"+this.weight;
    }

    public int compareTo(Edge o) {
        if (this.weight < o.weight) {
            System.out.println(this.weight +" is less than "+o.weight);
            return -1;
        }
        return 1;
    }
}
