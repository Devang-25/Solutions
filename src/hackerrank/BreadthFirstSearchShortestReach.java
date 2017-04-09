package hackerrank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BreadthFirstSearchShortestReach {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testcases = in.nextInt();
        for (int t = 1; t <= testcases; t++) {
            int n = in.nextInt();
            int m = in.nextInt();
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 1; i <= n + 1; i++) {
                graph.add(new LinkedList<>());
            }
            for (int i = 1; i <= m; i++) {
                int s = in.nextInt();
                int e = in.nextInt();
                graph.get(s).add(e);
                graph.get(e).add(s);
            }
            int s = in.nextInt();
            boolean visited[] = new boolean[n + 1];
            //visited[s] = true;
            int path[] = new int[n + 1];
            for (int i = 0; i < path.length; i++) {
                path[i] = -1;
            }
            LinkedList<Integer> l = new LinkedList<>();
            l.add(s);
            int level = 0;
            l.add(null);
            boolean endEncountered = false;
            while (!l.isEmpty()) {
                Integer current = l.remove();
                if (current == null) {
                    level++;
                    if (!endEncountered) {
                        endEncountered = true;
                        l.add(null);
                    } else {
                        break;
                    }
                } else {
                    visited[current] = true;
                    path[current] = level * 6;
                    for (int neighbour : graph.get(current)) {
                        if (!visited[neighbour]) {
                            visited[neighbour] = true;
                            path[neighbour] = path[current]+6;
                            l.add(neighbour);
                        }
                    }
                }

            }
            for (int i = 1; i < path.length; i++) {
                if (i != s) {
                    System.out.print(path[i] + " ");
                }
            }
            System.out.println();
        }
    }
}
