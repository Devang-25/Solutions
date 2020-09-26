package leetcode;

import java.util.*;

public class ReconstructItinerary {
    LinkedList<String> l = new LinkedList<>();

    public static void main(String[] args) {
        List<List<String>> list=new ArrayList<>();
        //{{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}}
        list.add(Arrays.asList("JFK","SFO"));
        list.add(Arrays.asList("JFK","ATL"));
        list.add(Arrays.asList("SFO","ATL"));
        list.add(Arrays.asList("ATL","JFK"));
        list.add(Arrays.asList("ATL","SFO"));
        final List<String> itinerary = new ReconstructItinerary().findItinerary(list);
        System.out.println(itinerary);
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        for (List<String> ticket : tickets) {
            graph.putIfAbsent(ticket.get(0), new PriorityQueue<>());
            graph.get(ticket.get(0)).add(ticket.get(1));
        }

        findItinerary_(graph, "JFK");
        return l;
    }

    private void findItinerary_(Map<String, PriorityQueue<String>> graph, String airport) {

        final PriorityQueue<String> tick = graph.getOrDefault(airport, new PriorityQueue<String>());
        while (!tick.isEmpty()) {
            findItinerary_(graph, tick.poll());
        }
        l.addFirst(airport);
    }
}
