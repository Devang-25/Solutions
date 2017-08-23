package interviewbits;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Highest {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(0, -1, 3, 100, 70, 50);
        int max = max3(arr);
        System.out.println(max);
    }

    public static int max3(List<Integer> a) {
        Collections.sort(a);
        int max1 = a.get(a.size() - 1);
        int max2 = a.get(a.size() - 2);
        int max3 = a.get(a.size() - 3);
        int min1 = a.get(0);
        int min2 = a.get(1);
        return Math.max(max1 * max2 * max3, min1 * min2 * max1);

    }
}
