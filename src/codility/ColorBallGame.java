package codility;

import java.util.HashMap;
import java.util.Map;

public class ColorBallGame {

    public static void main(String[] args) {
        System.out.println(new ColorBallGame().solution(-1, 2, new int[]{1, 2, 0, 1, 1, 0, 0, 1}, new int[]{0, 3, 0, 2, 0, 3, 0, 0}));
        System.out.println(new ColorBallGame().solution(-1, 2, new int[]{0, 1, 0, 1, 0, 1}, new int[]{1, 3, 0, 0, 3, 3}));
    }

    public int solution(int N, int Q, int[] B, int[] C) {
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.putIfAbsent(B[i], new HashMap<>());
            Map<Integer, Integer> color = map.get(B[i]);
            color.putIfAbsent(C[B[i]], 0);
            Integer colorCount = color.get(C[B[i]]);
            color.put(C[B[i]], colorCount + 1);
            map.put(B[i], color);
            System.out.println(map);
            if (color.get(C[B[i]]) == Q) {
                return i+1;
            }
        }
        return -1;

    }
}
