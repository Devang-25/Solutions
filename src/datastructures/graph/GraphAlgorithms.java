package datastructures.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

import datastructures.disjointsets.DisjointSet;
import datastructures.disjointsets.LinkedDisjointSet;
import datastructures.disjointsets.TreeDisjointSet;
import datastructures.disjointsets.Vertex;
import datastructures.priorityqueue.Pair;

public class GraphAlgorithms {

    public static void DFS(GraphIterable graph) {
        System.out.println("DFS");
        HashSet<Integer> visitedSet1 = new HashSet<Integer>();
        Iterator<Integer> vIter = graph.getVertexIterator();
        LinkedList<Integer> stack = new LinkedList<Integer>();
        if (vIter.hasNext()) {
            stack.push(vIter.next());
        } else {
            System.out.println("graph is empty");
            return;
        }
        while (!stack.isEmpty()) {
            int vertex = stack.pop();
            if (!visitedSet1.contains(vertex)) {
                visitedSet1.add(vertex);
                System.out.println(graph.getVertex(vertex));
                Iterator<Edge> edgeIter = graph.getadjacentEdgeIterator(vertex);
                while (edgeIter.hasNext()) {
                    int w = edgeIter.next().getW();
                    if (!visitedSet1.contains(w)) {
                        stack.push(w);
                    }
                }
            }
        }
    }

    public static int[] topologicalSort(GraphIterable graph) {
        LinkedList<Vertex> indegreeList = new LinkedList<Vertex>();
        int sortedList[] = new int[graph.V()];
        Iterator<Integer> i = graph.getVertexIterator();
        int iter = 0;
        while (i.hasNext()) {
            Vertex v = graph.getVertex(i.next());
            indegreeList.add(v);
        }
        while (!indegreeList.isEmpty()) {
            ListIterator<Vertex> lI = indegreeList.listIterator();
            while (lI.hasNext()) {
                Vertex v = lI.next();
                if (v.getInDegree() == 0) {
                    Iterator<Edge> eI = graph.getadjacentEdgeIterator(v.getVertexId());
                    while (eI.hasNext()) {
                        graph.getVertex(eI.next().getW()).decrementInDegree();
                    }
                    sortedList[iter++] = v.getVertexId();
                    lI.remove();
                }
            }
        }
        return sortedList;
    }

    public static Collection<DisjointSet> findConnectedComponents(GraphIterable graph) {
        Iterator<Integer> i = graph.getVertexIterator();
        Map<Integer, DisjointSet> mapping = new HashMap<Integer, DisjointSet>();
        while (i.hasNext()) {
            int id = i.next();
            mapping.put(id, new TreeDisjointSet(graph.getVertex(id)));
        }
        i = graph.getVertexIterator();
        while (i.hasNext()) {
            int id = i.next();
            Vertex v = graph.getVertex(id);
            System.out.println("For id: " + id);
            Iterator<Edge> eI = graph.getadjacentEdgeIterator(id);
            while (eI.hasNext()) {
                Edge e = eI.next();
                int diD = e.getW();
                System.out.println("dest: " + diD);
                Vertex dest = graph.getVertex(diD);
                DisjointSet set = mapping.get(id);
                DisjointSet set2 = mapping.get(diD);
                if (set.findSet(v) != set2.findSet(dest)) {
                    set.union(dest);
                    mapping.remove(diD);
                    mapping.put(diD, set);
                }
            }
        }
        Set<DisjointSet> set = new HashSet<DisjointSet>(mapping.values());
        return set;
    }
    private static LinkedList<LinkedList<Integer>> pathList = null;
    private static Set<Integer> visitedSet = null;
    private static LinkedList<Integer> curPath = null;

    public static List<? extends List<Integer>> simplePath(GraphIterable graph, int s, int d) {
        Vertex source = graph.getVertex(s);
        curPath = new LinkedList<Integer>();
        pathList = new LinkedList<LinkedList<Integer>>();
        Vertex destination = graph.getVertex(d);
        if (source == null || destination == null) {
            throw new NoSuchElementException();
        }
        visitedSet = new HashSet<Integer>(graph.V());
        find(graph, source, destination);
        return pathList;
    }

    private static void find(GraphIterable graph, Vertex s, Vertex d) {
        System.out.println("Enter find:" + s);
        visitedSet.add(s.getVertexId());
        if (s == d) {
            System.out.println("success :" + curPath);
            LinkedList<Integer> newPath = (LinkedList<Integer>) curPath.clone();
            pathList.addLast(curPath);
            curPath = newPath;
            System.out.println("Exit find:" + s + " with success");
            return;
        }
        Iterator<Edge> edgeI = graph.getadjacentEdgeIterator(s.getVertexId());
        System.out.println("For vertex id " + s.getVertexId());
        while (edgeI.hasNext()) {
            Edge e = edgeI.next();
            System.out.println("processing edge:" + e + " from cur source" + s);
            Vertex v = graph.getVertex(e.getW());
            if (!visitedSet.contains(e.getW())) {
                System.out.println(visitedSet);
                visitedSet.add(e.getW());
                System.out.println(visitedSet);
                curPath.addLast(e.getW());
                find(graph, v, d);
                curPath.removeLast();
                visitedSet.remove(e.getW());
                System.out.println(visitedSet);
            }
        }
        System.out.println("Exit find:" + s);
    }
    static HashMap<Integer, Integer> map = null;

    public static Set<Map.Entry<Integer, Integer>> connectedComponents(GraphIterable graph) {
        Iterator<Integer> i = graph.getVertexIterator();
        int count = 0;
        map = new HashMap<Integer, Integer>(graph.V());
        while (i.hasNext()) {
            int v = i.next();
            if (!map.containsKey(v)) {
                connectedComponent(graph, v, count);
                count++;
            }
        }
        return map.entrySet();
    }

    private static void connectedComponent(GraphIterable graph, int v, int ccId) {
        map.put(v, ccId);
        Iterator<Edge> eI = graph.getadjacentEdgeIterator(v);
        while (eI.hasNext()) {
            Edge e = eI.next();
            int w = e.getW();
            if (!map.containsKey(w)) {
                connectedComponent(graph, w, ccId);
            }
        }
    }
    private static Map<Integer, Boolean> colorStore = null;

    public static boolean isGraphColorabilityPossible(GraphIterable graph) {
        Iterator<Integer> i = graph.getVertexIterator();
        colorStore = new HashMap<Integer, Boolean>(graph.V());
        boolean color = true;
        while (i.hasNext()) {
            int vertex = i.next();
            if (!colorStore.containsKey(vertex)) {
                if (!dfsC(graph, vertex, !color)) {
                    return false;
                }
            }

        }
        return true;
    }

    private static boolean dfsC(GraphIterable graph, int vertex, boolean color) {
        Iterator<Edge> eI = graph.getadjacentEdgeIterator(vertex);
        colorStore.put(vertex, color);
        while (eI.hasNext()) {
            Edge e = eI.next();
            int w = e.getW();
            if (!colorStore.containsKey(w)) {
                if (!dfsC(graph, w, !color)) {
                    return false;
                }
            } else {
                if (colorStore.get(w) == color) {
                    System.out.println("Color of " + vertex + " is " + color + "\t color of " + w + " is " + colorStore.get(w));
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBiPartite(GraphIterable graph) {
        return GraphAlgorithms.isGraphColorabilityPossible(graph);
    }

    public static Pair<List<Integer>, List<Integer>> getBiParttiteComponents(GraphIterable graph) {
        //return null if the graph is not bipartite at all
        //in O(n), we can determine if the graph is bipartite
        //if it is, we move on to next level.
        if (!GraphAlgorithms.isBiPartite(graph)) {
            return null;
        }
        List<Integer> groupA = new ArrayList<Integer>();
        List<Integer> groupB = new ArrayList<Integer>();
        Set<Entry<Integer, Boolean>> entrySet = colorStore.entrySet();
        for (Map.Entry<Integer, Boolean> e : entrySet) {
            if (e.getValue()) {
                groupA.add(e.getKey());
            } else {
                groupB.add(e.getKey());
            }
        }
        Pair<List<Integer>, List<Integer>> pair = new Pair<List<Integer>, List<Integer>>(groupA, groupB);
        return pair;
    }
    private static Map<Integer, Integer> order, low;
    private static List<Edge> bridgeList = null;

    public static List<Edge> getBridges(GraphIterable graph) {
        bridgeList = new LinkedList<Edge>();
        System.out.println("Enter getBridges");
        order = new HashMap<>(graph.V());
        low = new HashMap<>(graph.V());
        Iterator<Integer> vertices = graph.getVertexIterator();
        while (vertices.hasNext()) {
            int vertex = vertices.next();
            low.put(vertex, Integer.MAX_VALUE);
            order.put(vertex, ord);
            ord++;
            System.out.println("Current Vertex is" + vertex);
            process(graph, vertex, vertex);
        }
        return bridgeList;
    }
    private static int ord = 0;

    private static List<Edge> process(GraphIterable graph, int V, int parent) {
        Iterator<Edge> eI = graph.getadjacentEdgeIterator(V);
        while (eI.hasNext()) {
            Edge edge = eI.next();
            int w = edge.getW();
            if (!order.containsKey(w)) {
                order.put(w, ord);
                System.out.println("Current Vertex is" + w + " with order: " + ord);
                ord++;
                low.put(w, Integer.MAX_VALUE);
                process(graph, w, V);
                if (low.get(w) == Integer.MAX_VALUE) {
                    low.put(w, order.get(w));
                }

                if (low.get(w) < low.get(V)) {
                    low.put(V, low.get(w));
                }
                if (order.get(w) == low.get(w)) {
                    System.out.println("Bridge located at" + w + "-" + V);
                    bridgeList.add(new Edge(w, V));
                }
                System.out.println("Parent Vertex is" + V + " with low: " + low.get(V));
                System.out.println("Current Vertex is" + w + " with low: " + low.get(w));
            } else {
                //it means it has already been visited.
                if (w != parent) {
                    if (low.get(V) > order.get(w)) {
                        low.put(V, order.get(w));
                    }
                }
            }

        }
        return bridgeList;
    }
//has not been tested yet

    private static class EdgeComparator implements Comparator<Edge> {

        public int compare(Edge o1, Edge o2) {
            if (o1.getWeight() < o2.getWeight()) {
                //System.out.println(o1 +"is smaller than "+o2);
                return -1;
            }
            if (o1.getWeight() == o2.getWeight()) {
                return 0;
            } else {
                //System.out.println(o1 +"is larger than "+o2);
                return 1;
            }
        }
    }

    public static GraphIterable getMSTPrim(GraphIterable graph) {
        TreeSet<Edge> edgeSet = new TreeSet<Edge>(new EdgeComparator());
        Set<Integer> mstIncluded = new HashSet<Integer>(graph.V());
        GenericLinkedGraph mst = new GenericLinkedGraph(false);
        Iterator<Integer> vIter = graph.getVertexIterator();
        while (vIter.hasNext()) {
            mst.insert(vIter.next());
        }
        Map<Integer, Edge> dMap = new HashMap<Integer, Edge>();//what better could be..
        vIter = graph.getVertexIterator();
        int v = 0;
        if (vIter.hasNext()) {//just a formality
            v = vIter.next();
            System.out.println(v + " is our first vertex");
            mstIncluded.add(v);
        }

        while (mstIncluded.size() < graph.V()) {
            Iterator<Edge> eIter = graph.getadjacentEdgeIterator(v);
            while (eIter.hasNext()) {
                Edge e = eIter.next();
                int w = e.getW();
                if (!mstIncluded.contains(w)) {
                    System.out.println(w + " is not in mst yet");
                    if (!dMap.containsKey(w)) {
                        //our problem cud be fixed here
                        System.out.println(e + " is added to edgeset");
                        edgeSet.add(e);
                        dMap.put(w, e);
                    } else {
                        Edge already = dMap.get(w);
                        System.out.println(already + " is already in the dMap being compared to " + e);
                        if (e.compareTo(already) < 0) {
                            dMap.remove(w);
                            dMap.put(w, e);
                            System.out.println("but " + e + " is smaller than " + already);
                            edgeSet.add(e);
                            edgeSet.remove(already);
                        } else {
                            System.out.println(e + " is discarded");
                        }
                    }
                }
            }
            Edge lowest = edgeSet.pollFirst();
            System.out.println(lowest);
            int vIncluded = lowest.getW();
            mstIncluded.add(vIncluded);
            mst.insert(lowest);
            v = vIncluded;
        }
        return mst;
    }

    public static GraphIterable getMSTKrushkal(GraphIterable graph) {
        PriorityQueue<Edge> pQ = new PriorityQueue<Edge>(graph.E(), new EdgeComparator());
        Iterator<Integer> i = graph.getVertexIterator();
        GenericLinkedGraph mst = new GenericLinkedGraph(false);
        pQ.addAll(graph.getEdges());
        Map<Integer, DisjointSet> mapping = new HashMap<Integer, DisjointSet>();
        while (i.hasNext()) {
            int id = i.next();
            mst.insert(id);
            mapping.put(id, new LinkedDisjointSet(graph.getVertex(id)));
        }
        int edgesMax = 2 * (mst.V() - 1);
        while (mst.E() < edgesMax) {
            System.out.println(mst.E()+":"+edgesMax);
            Edge smallest = pQ.poll();
            System.out.println(smallest);
            int v = smallest.getV();
            int w = smallest.getW();
            DisjointSet setA = mapping.get(v);
            DisjointSet setB = mapping.get(w);
            System.out.println("v belongs to " + setA.findSet(graph.getVertex(v)));
            System.out.println("w belongs to " + setB.findSet(graph.getVertex(w)));
            if (setA != setB) {
                mapping.get(v).union(graph.getVertex(w));
                mst.insert(smallest);
                mapping.remove(w);
                mapping.put(w, mapping.get(v));
            } else {
                System.out.println("cycle problem");
            }
        }
        return mst;
    }
}
