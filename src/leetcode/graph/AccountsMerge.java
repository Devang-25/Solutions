package leetcode.graph;

import java.util.*;
import java.util.stream.Collectors;

public class AccountsMerge {

    public static void main(String[] args) {
        final String[][] accounts = {{"John", "johnsmith@mail.com", "john00@mail.com"}, {"John", "johnnybravo@mail.com"}, {"John", "johnsmith@mail.com", "john_newyork@mail.com"}, {"Mary", "mary@mail.com"}};
        List<List<String>> accountZ = new ArrayList<>();
        for (int i = 0; i < accounts.length; i++) {
            accountZ.add(Arrays.asList(accounts[i]));
        }
        final List<List<String>> lists = new AccountsMerge().accountsMerge(accountZ);
        System.out.println(lists);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 0; j < accounts.size(); j++) {
                if (j != i) {
                    boolean edge = edge(accounts.get(i).subList(1, accounts.get(i).size()), accounts.get(j).subList(1, accounts.get(j).size()));
                    if (edge) {
                        graph.putIfAbsent(i, new HashSet<>());
                        graph.putIfAbsent(j, new HashSet<>());
                        graph.get(i).add(j);
                        //graph.get(j).add(i);
                    }
                } else {
                    graph.putIfAbsent(i, new HashSet<>());
                }
            }
        }
        //System.out.println(graph);
        Set<Integer> visited = new HashSet<>();
        List<List<String>> merged = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            if (!visited.contains(i)) {
                List<String> acc = new ArrayList<>();
                acc.add(accounts.get(i).get(0));
                acc.addAll(new TreeSet<>(connectedComponent(accounts, graph, i, visited)));
                merged.add(acc);
            }
        }
        return merged;
    }

    private List<String> connectedComponent(List<List<String>> accounts, Map<Integer, Set<Integer>> map, int index, Set<Integer> visited) {
        if (!visited.contains(index)) {
            visited.add(index);
            final List<String> emails = accounts.get(index).subList(1, accounts.get(index).size());
            //System.out.println(index + "\t" + emails);
            emails.addAll(map.get(index).stream().flatMap(e -> {
                return connectedComponent(accounts, map, e, visited).stream();
            }).collect(Collectors.toList()));
            return emails;
        }
        return new ArrayList<>();
    }

    private boolean edge(List<String> eL1, List<String> eL2) {
        for (String s : eL1) {
            if (eL2.contains(s)) {
                return true;
            }
        }
        return false;
    }
}
