/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.graph;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author gopimac
 */
public class GraphIterator implements Iterator<Edge> {

    private GraphIterable graph;
    private Iterator<Integer> i;
    private Iterator<Edge> j;
    private int currentVertex;
    private Edge currentEdge;

    public GraphIterator(GraphIterable g) {
        this.graph = g;
        i = graph.getVertexIterator();
        if (i.hasNext()) {
            currentVertex = i.next();
            j = graph.getadjacentEdgeIterator(currentVertex);
        }
    }

    public boolean hasNext() {
        if (j.hasNext()) {
            return true;
        } else if (i.hasNext()) {
            return true;
        }
        return false;
    }

    public Edge next() {
        if (j.hasNext()) {
            currentEdge = j.next();
            return currentEdge;
        } else if (i.hasNext()) {
            currentVertex = i.next();
            j = graph.getadjacentEdgeIterator(currentVertex);
            if (j.hasNext()) {
                currentEdge = j.next();
                return currentEdge;
            }
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        graph.removeEdge(currentEdge);
    }
}
