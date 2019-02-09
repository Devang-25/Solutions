package hackerrank;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class HashTablesIceCreamParlor {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int trips = in.nextInt();
        for (int i = 1; i <= trips; i++) {
            int money = in.nextInt();
            int ice_creams = in.nextInt();
            HashMap<Integer, List<Integer>> creams = new HashMap<>(ice_creams + 1);
            for (int c = 1; c <= ice_creams; c++) {
                int cost = in.nextInt();
                if (cost < money) {
                    creams.putIfAbsent(cost, new ArrayList<>());
                    List<Integer> value = creams.get(cost);
                    value.add(c);
                    creams.putIfAbsent(cost, value);
                }
            }
            for (int c : creams.keySet()) {
                if (creams.containsKey(money - c)) {
                    int x = creams.get(c).get(0);
                    int y = creams.get(money - c).stream().filter(v -> !v.equals(x)).findFirst().get();
                    System.out.println(Math.min(x, y) + " " + Math.max(x, y));
                    break;
                }
            }
        }
    }
}
