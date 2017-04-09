/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.disjointsets;


/**
 *
 * @author gopimac
 */
public class TreeDisjointSetPlugin implements DisjointSetPlugin {

    private Vertex next;
    private Vertex representative;
    private int rank;
    private Vertex firstChild;
}
