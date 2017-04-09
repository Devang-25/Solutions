package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenTree {
    private static int forest = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        int root = 1;
        boolean isVisited[] = new boolean[n + 1];
        getVertices(graph, isVisited, root);
        System.out.println(forest);
    }

    private static int getVertices(List<ArrayList<Integer>> graph, boolean isVisited[], int root) {
        isVisited[root] = true;
        if (isLeaf(graph, root)) {
            return 1;
        }
        int vertices = 0;
        for (int child : graph.get(root)) {
            if (!isVisited[child]) {
                int childVerticesCount = getVertices(graph, isVisited, child);
                if (childVerticesCount % 2 == 0) {
                    System.out.println(child);
                    //has even vertices and can be removed to a separate forest.
                    forest++;
                } else {
                    vertices += childVerticesCount;
                }
            }
        }
        System.out.println("Count at "+root+"="+(vertices+1));
        return vertices + 1;
    }

    private static boolean isLeaf(List<ArrayList<Integer>> graph, int root) {
        return graph.get(root).size() == 1;
    }
}
