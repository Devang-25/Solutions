package leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerateParentheses {

    private final Map<Integer, List<String>> preComputed = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(10));
    }

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        if (n == 2) {
            return Collections.singletonList("()");
        }
        if (preComputed.containsKey(n)) {
            return preComputed.get(n);
        }
        final List<String> results = generateParenthesis(n - 2).stream().flatMap(x -> Stream.of("(" + x + ")", "()" + x)).collect(Collectors.toList());
        preComputed.put(n, results);
        return results;
    }
}
