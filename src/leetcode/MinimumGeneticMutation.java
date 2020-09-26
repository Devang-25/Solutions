package leetcode;

import java.util.*;

public class MinimumGeneticMutation {

    public static void main(String[] args) {
        final int muts = new MinimumGeneticMutation().minMutation("AACCGGTT", "AAACGGTA", new String[]{});
        System.out.println(muts);
    }

    public int minMutation(String start, String end, String[] b) {
        final List<String> bank = new ArrayList<>(Arrays.asList(b));
        if (bank.isEmpty()) {
            return -1;
        }
        bank.add(start);
        Map<String, List<String>> graph = new HashMap<>();
        for (int i = 0; i < bank.size(); i++) {
            for (int j = i + 1; j < bank.size(); j++) {
                final String geneI = bank.get(i);
                graph.putIfAbsent(geneI, new ArrayList<>());
                final String geneJ = bank.get(j);
                graph.putIfAbsent(geneJ, new ArrayList<>());
                if (oneMutation(geneI, geneJ)) {
                    graph.get(geneI).add(geneJ);
                    graph.get(geneJ).add(geneI);
                }
            }
        }
        return shortestPath(graph, start, end);
    }

    private int shortestPath(Map<String, List<String>> graph, String start, String end) {
        Set<String> visited = new HashSet<>();
        Queue<Dist> queue = new LinkedList<>();
        visited.add(start);
        graph.get(start).forEach(n -> queue.add(new Dist(n, 1)));
        while (!queue.isEmpty()) {
            final Dist d = queue.poll();
            if (d.gene.equals(end)) {
                return d.dist;
            }
            if (!visited.contains(d.gene)) {
                visited.add(d.gene);
                graph.get(d.gene).forEach(n -> queue.add(new Dist(n, d.dist + 1)));
            }
        }
        return -1;

    }

    static class Dist {
        String gene;
        int dist;

        public Dist(String gene, int dist) {
            this.gene = gene;
            this.dist = dist;
        }
    }

    private boolean oneMutation(String x, String y) {
        int misMatch = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != y.charAt(i)) {
                misMatch++;
                if (misMatch >= 2) {
                    return false;
                }
            }
        }
        return misMatch == 1;
    }

}
