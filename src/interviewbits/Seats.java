package interviewbits;

import java.util.ArrayList;
import java.util.List;

public class Seats {
    public static void main(String[] args) {
        int seats = seats("....x..xx...x..");
        System.out.println(seats);
    }

    public static int seats(String a) {
        List<Integer> positions = new ArrayList<>();
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == 'x') {
                positions.add(i);
            }
        }
        int n = positions.size();
        int median;
        System.out.println(positions);
        if (n % 2 == 0) {
            median = (positions.get(n / 2 - 1) + positions.get(n / 2)) / 2;
        } else {
            median = positions.get(n / 2);
        }
        System.out.println(median);
        int start = median - (n % 2 == 0 ? n / 2-1 : n / 2);
        System.out.println(start);
        int sum = 0;
        for (int p : positions) {
            sum += Math.abs(p - start);
            start++;
        }
        return sum;
    }
}
