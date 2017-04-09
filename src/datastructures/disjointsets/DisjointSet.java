/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.disjointsets;


/**
 *
 * @author gopimac
 */
public interface DisjointSet {

    Vertex findSet(Vertex V);

    void union(Vertex V);
}
