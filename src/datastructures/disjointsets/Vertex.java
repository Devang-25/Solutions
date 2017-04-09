/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.disjointsets;


/**
 *
 * @author gopimac
 */
public class Vertex {
//parametrization depends on the need.

    private int vertexId;
    private int inDegree = 0, outDegree = 0;
    Vertex next;
    Vertex representative;
    int rank;
    Vertex firstChild;
    DisjointSetPlugin plugin;

    public DisjointSetPlugin getPlugin() {
        return plugin;
    }

    public void setPlugin(DisjointSetPlugin plugin) {
        this.plugin = plugin;
    }
    private Vertex() {
    }

    public int getInDegree() {
        return inDegree;
    }

    public void setInDegree(int inDegree) {
        this.inDegree = inDegree;
    }

    public int getOutDegree() {
        return outDegree;
    }

    public void setOutDegree(int outDegree) {
        this.outDegree = outDegree;
    }

    public Vertex(int id) {
        this.vertexId = id;
    }

    public int getVertexId() {
        return vertexId;
    }

    public void incrementInDegree() {
        this.inDegree++;
    }

    public void decrementInDegree() {
        this.inDegree--;
    }

    public void incrementOutDegree() {
        this.outDegree++;
    }

    public void decrementOutDegree() {
        this.outDegree--;
    }

    @Override
    public String toString() {
        return "" + vertexId + "[" + inDegree + "," + outDegree + "]";
    }
}
