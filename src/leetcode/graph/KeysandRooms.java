package leetcode.graph;

import java.util.*;

public class KeysandRooms {

    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Collections.singletonList(3));
        rooms.add(Arrays.asList());
        //[[1,3],[3,0,1],[2],[0]]
        final boolean visited = new KeysandRooms().canVisitAllRooms(rooms);
        System.out.println(visited);
    }


    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < rooms.size(); i++) {
            graph.putIfAbsent(i, new ArrayList<>());
            for (Integer r : rooms.get(i)) {
                graph.get(i).add(r);
            }
        }
        System.out.println(graph);
        final HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        traverse(graph, 0, visited);
        return visited.size() == rooms.size();
    }

    private void traverse(HashMap<Integer, List<Integer>> graph, int v, HashSet<Integer> visited) {
        graph.getOrDefault(v, new ArrayList<>()).stream().filter(x -> !visited.contains(x)).forEach(x -> {
            visited.add(x);
            traverse(graph, x, visited);
        });
    }


}
