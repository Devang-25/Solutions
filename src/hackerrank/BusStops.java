package hackerrank;

import java.util.*;

public class BusStops {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        TreeSet<Long> set = new TreeSet<>();

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int xItr = 0; xItr < n; xItr++) {
            long xItem = Long.parseLong(xItems[xItr]);
            set.add(xItem);
        }

        String[] wv = scanner.nextLine().split(" ");

        long w = Long.parseLong(wv[0]);

        long v = Long.parseLong(wv[1]);
        long last = set.last();
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < q; i++) {
            long pi = scanner.nextLong();
            int ti = scanner.nextInt();
            int ui = scanner.nextInt();
            Long c1 = set.ceiling(pi);
            double s1 = getTime(c1, w, v, last, pi, ti, ui);
            Long c2 = set.floor(pi);
            double s2 = getTime(c2, w, v, last, pi, ti, ui);
            double min = Math.min(s1, s2);
            System.out.println(Math.min(min, (((double)last-pi)/ui)+ti));

        }
        scanner.close();
    }

    private static double getTime(long xj, long w, long v, long last, long pi, int ti, int ui) {
        double walkTime = Math.abs((xj - pi) / ui);
        double timeArriveAtStop = ti + walkTime;
        double busArrivalOffset = xj / v;
        double busNumber = Math.ceil((timeArriveAtStop - busArrivalOffset) / w);
        double timeToGetOnBus = w * busNumber + busArrivalOffset;
        double timeOnBus = (last - xj) / v;
        return timeOnBus + timeToGetOnBus;
    }
}
