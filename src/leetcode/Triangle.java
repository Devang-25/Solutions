package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Collections.singletonList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        final int result = new Triangle().minimumTotal(triangle);
        System.out.println(result);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 1; i <= triangle.size(); i++) {
            final ArrayList<Integer> elements = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                elements.add(0);
            }
            dp.add(elements);

        }
        dp.get(0).set(0, triangle.get(0).get(0));
        for (int i = 1; i < triangle.size(); i++) {
            final List<Integer> row = triangle.get(i);

            for (int j = 0; j < row.size(); j++) {
                dp.get(i).set(j, triangle.get(i).get(j) + Math.min(getValue(dp, i - 1, j - 1), getValue(dp, i - 1, j)));
            }
        }
        return Collections.min(dp.get(triangle.size() - 1));
    }

    private int getValue(List<List<Integer>> dp, int i, int j) {
        if (j >= dp.get(i).size() || j < 0) {
            return Integer.MAX_VALUE;
        }
        return dp.get(i).get(j);
    }
}
