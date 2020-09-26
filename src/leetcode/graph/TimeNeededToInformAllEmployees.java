package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeNeededToInformAllEmployees {
    public static void main(String[] args) {
//n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
        final int result = new TimeNeededToInformAllEmployees().numOfMinutes(15, 0, new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6}, new int[]{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0});
        System.out.println(result);
    }

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        Map<Integer, List<Employee>> subOrdinates = new HashMap<>();
        for (int i = 0; i < manager.length; i++) {
            subOrdinates.putIfAbsent(manager[i], new ArrayList<>());
            subOrdinates.get(manager[i]).add(new Employee(i, informTime[i]));
        }
        return process(subOrdinates, headID) + informTime[headID];
    }

    private int process(Map<Integer, List<Employee>> subOrdinatesMap, int headID) {
        final List<Employee> subOrdinates = subOrdinatesMap.getOrDefault(headID, new ArrayList<>());
        return subOrdinates.stream().mapToInt(x -> process(subOrdinatesMap, x.id) + x.delay).max().orElse(0);
    }


    class Employee {
        int id;
        int delay;

        public Employee(int id, int delay) {
            this.id = id;
            this.delay = delay;
        }
    }

}
