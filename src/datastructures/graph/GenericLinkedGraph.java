/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.graph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import datastructures.disjointsets.Vertex;

public class GenericLinkedGraph implements GraphIterable {

    LinkedList<Edge> edgeLinkedList = new LinkedList<Edge>();
    private Map<Integer, Vertex> idMapper = new HashMap<Integer, Vertex>();
    private Map<Vertex, LinkedList<Edge>> map = null;
    public boolean isDirected = true;

    public GenericLinkedGraph(boolean isDirected) {
        this.isDirected = isDirected;
        map = new HashMap<Vertex, LinkedList<Edge>>();
    }

    public int V() {
        return this.map.size();
    }

    public int E() {
        int edges = 0;
        Collection<? extends List<Edge>> c = map.values();
        for (List<Edge> l : c) {
            edges += l.size();
        }
        return edges;
    }

    public boolean directed() {
        return this.isDirected;
    }

    public boolean insert(Edge e) {
        if (!this.insertEdge(e)) {
            return false;
        }
        if (!this.isDirected) {
            return this.insertEdge(new Edge(e.getW(), e.getV(), e.getWeight()));
        }
        return true;
    }

    private boolean insertEdge(Edge e) {
        int W = e.getW();
        Vertex v = this.idMapper.get(e.getV());
        Vertex w = this.idMapper.get(W);
        if (v == null | w == null) {
            throw new NullPointerException("no such vertex exists");
        }
        LinkedList<Edge> edgeList = this.map.get(v);
        for (Edge i : edgeList) {
            if (i.getW() == W) {
                System.out.println(i.getW());
                throw new UnsupportedOperationException("Duplicate Edges not allowed:Edge already exists");
            }
        }
        edgeList.add(e);
        v.incrementOutDegree();
        w.incrementInDegree();
        edgeLinkedList.add(e);
        return true;
    }
//this method has only been implemented for directed graph...

    public boolean remove(Edge e) {
        Vertex v = this.idMapper.get(e.getV());
        Vertex w = this.idMapper.get(e.getW());
        if (v == null) {
            throw new NullPointerException("no such vertex exists");
        }
        List<Edge> edgeList = this.map.get(v);
        for (Edge i : edgeList) {
            if (i.getW() == e.getW()) {
                edgeList.remove(i);
                v.decrementOutDegree();
                w.decrementInDegree();
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String ret = "";
        Set<Vertex> set = this.map.keySet();
        for (Vertex i : set) {
            ret += i + " : " + this.map.get(i) + "\n";
        }
        return ret;
    }

    public boolean insert(int v) {
        if (idMapper.containsKey(v)) {
            return false;
        }
        LinkedList<Edge> list = new LinkedList<Edge>();
        Vertex vi = new Vertex(v);
        idMapper.put(v, vi);
        map.put(vi, list);
        return true;
    }

    public Iterator<Integer> getVertexIterator() {
        return this.idMapper.keySet().iterator();
    }

    public Iterator<Edge> getadjacentEdgeIterator(int v) {
        if (!idMapper.containsKey(v)) {
            throw new NullPointerException("no such vertex exists");
        }
        return this.map.get(idMapper.get(v)).iterator();
    }

    public Iterator<Edge> getIterator() {
        return new GraphIterator(this);
    }

    public Vertex getVertex(int id) {
        if (this.idMapper.containsKey(id)) {
            return this.idMapper.get(id);
        }
        return null;
    }

    public void removeEdge(Edge e) {
        this.remove(e);
    }

    public Collection<? extends Edge> getEdges() {
        return this.edgeLinkedList;
    }
}
