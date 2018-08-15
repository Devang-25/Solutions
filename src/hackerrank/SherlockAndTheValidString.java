package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SherlockAndTheValidString {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        List<Character> cList = new ArrayList<>();
        for (char c : s.toCharArray()) {
            cList.add(c);
        }
        Map<Long, Long> map = cList
                .stream()
                .collect(Collectors.groupingBy(x -> x, Collectors.counting()))
                .entrySet()
                .stream()
                .collect(Collectors.groupingBy(e -> e.getValue(), Collectors.counting()));
        if (map.size() == 1) {
            System.out.println("YES");
        } else if (map.size() == 2 && map.containsKey(1L) && map.get(1L) == 1) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
