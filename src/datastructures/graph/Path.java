/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.graph;

import java.util.LinkedList;

import datastructures.disjointsets.Vertex;

/**
 *
 * @author gopimac
 */
public class Path {

    private LinkedList<Vertex> nodes;
    int totalSum = 0;

    public Path() {
        nodes = new LinkedList<Vertex>();
    }

    public void addVertex(Vertex V, int weight) {
        this.nodes.add(V);
        this.totalSum += weight;
    }

    public int getLength() {
        return this.totalSum;
    }

    public void setLength(int l) {
        this.totalSum = l;
    }

    public Vertex getDestination() {
        return this.nodes.getLast();
    }
}
