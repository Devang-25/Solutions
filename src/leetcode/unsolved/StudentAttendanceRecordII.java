package leetcode.unsolved;


import java.util.HashMap;
import java.util.Map;

public class StudentAttendanceRecordII {

    public static void main(String[] args) {
        final int result = new StudentAttendanceRecordII().checkRecord(2);
        System.out.println(result);
    }


    public int checkRecord(int n) {
        if (n == 0) {
            return 0;
        }
        Map<String, Integer> cache = new HashMap<>();
        return ways(0, n - 1, 1, 2, cache);
    }

    private int ways(int s, int e, int A, int L, Map<String, Integer> cache) {
        if (s > e) {
            return 0;
        }
        if (s == e) {
            return 1 + A + (L == 2 ? 1 : 0);
        }

        final String key = s + "-" + e + "-" + A + "-" + L;
        if (cache.containsKey(key)) {
            return cache.get(s + "-" + e + "-" + A + "-" + L);
        }
        int ways = 0;
        for (int i = s; i <= e; i++) {
            if (A == 1) {
                ways += ways(s, i - 1, 0, L, cache) % 1000000007;
                ways += ways(i + 1, e, 0, L, cache) % 1000000007;
            }
            if (L == 2) {
                ways += ways(s, i - 1, A, 0, cache) % 1000000007;
                ways += ways(i + 2, e, A, 0, cache) % 1000000007;
            }
            ways += ways(s, i - 1, A, L, cache) % 1000000007;
            ways += ways(i + 1, e, A, L, cache) % 1000000007;
        }
        cache.put(key, ways);
        return ways;
    }


}
