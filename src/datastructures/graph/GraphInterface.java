/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.graph;

import java.util.Iterator;

/**
 *
 * @author gopimac
 */
public interface GraphInterface {

    int V();

    int E();

    boolean directed();

    boolean insert(Edge e);

    boolean remove(Edge e);

    boolean insert(int v);

    Iterator<Edge> getIterator();
}
