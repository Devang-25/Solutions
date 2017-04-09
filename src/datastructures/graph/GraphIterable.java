/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.graph;

import java.util.Collection;
import java.util.Iterator;

import datastructures.disjointsets.Vertex;

/**
 *
 * @author gopimac
 */
public interface GraphIterable {

    Iterator<Edge> getadjacentEdgeIterator(int v);

    Iterator<Integer> getVertexIterator();

    Vertex getVertex(int id);

    void removeEdge(Edge e);

    int V();

    int E();
    Collection<? extends Edge> getEdges();
}
