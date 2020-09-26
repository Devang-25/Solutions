package leetcode;

import java.util.*;

public class PossibleBipartition {

    public static void main(String[] args) {
        final boolean possible = new PossibleBipartition().possibleBiPartition(5, new int[][]{{1, 2}, {3, 4}, {4, 5}, {3, 5}});
        System.out.println(possible);
    }

    public boolean possibleBiPartition(int N, int[][] dislikes) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < dislikes.length; i++) {
            graph.putIfAbsent(dislikes[i][0] - 1, new ArrayList<>());
            graph.putIfAbsent(dislikes[i][1] - 1, new ArrayList<>());
            graph.get(dislikes[i][0] - 1).add(dislikes[i][1] - 1);
        }

        int[] group = new int[N];
        Arrays.fill(group, -1);
        for (int i = 0; i < N; i++) {
            if (group[i] == -1) {
                group[i] = 0;
                if (!possible(graph, i, group)) {
                    return false;
                }
            }
        }
        return true;

    }

    private boolean possible(HashMap<Integer, List<Integer>> graph, int v, int[] group) {
        final List<Integer> edges = graph.getOrDefault(v, new ArrayList<>());
        boolean possible = true;
        for (int e : edges) {
            if (group[e] == -1) {
                group[e] = ((group[v] == 0) ? 1 : 0);
                possible &= possible(graph, e, group);
            } else {
                if (group[e] == group[v]) {
                    return false;
                }
            }
        }
        return possible;
    }
}
