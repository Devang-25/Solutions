package leetcode.graph;

import java.util.*;

public class CloneGraph {

    private HashMap<Node, Node> adjList = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        if (adjList == null) {
            adjList = new HashMap<>();
        }
        adjList.put(node, new Node(node.val, new ArrayList<>()));

        for (Node neighbor : node.neighbors) {
            if (adjList.containsKey(neighbor)) {
                adjList.get(node).neighbors.add(adjList.get(neighbor));
            } else {
                adjList.get(node).neighbors.add(cloneGraph(neighbor));
            }
        }

        return adjList.get(node);
    }
}

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
