package hackerrank;

import java.util.*;

public class JourneyToTheMoon {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int I = in.nextInt();
        int membership[] = new int[N];
        for (int i = 0; i < membership.length; i++) {
            membership[i] = i;
        }
        for (int i = 0; i < I; i++) {
            int A = in.nextInt();
            int B = in.nextInt();
            if (A > B) {
                int t = A;
                A = B;
                B = t;
            }
            int headA = head(membership, A);
            int headB = head(membership, B);
            membership[headB] = headA;
        }
        for (int i = 0; i < membership.length; i++) {
            membership[i] = head(membership, i);
        }
        System.out.println(Arrays.toString(membership));
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < membership.length; i++) {
            if (!map.containsKey(membership[i])) {
                map.put(membership[i], 0);
            }
            map.put(membership[i], map.get(membership[i]) + 1);
        }
        System.out.println(map);
        long count = 0;
        List<Integer> list = new ArrayList<>(map.values());
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                count += list.get(i) * list.get(j);
            }
        }
        System.out.println(count);


    }

    private static int head(int[] membership, int a) {
        int current = a;
        while (membership[current] != current) {
            current = membership[current];
        }
        return current;
    }
}
