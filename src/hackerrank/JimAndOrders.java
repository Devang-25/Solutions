package hackerrank;

import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

public class JimAndOrders {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        TreeSet<Order> set = new TreeSet<>(new OrderComparator());
        for (int i = 0; i < n; i++) {
            Order order = new Order(i + 1, in.nextInt(), in.nextInt());
            set.add(order);
        }
        for (Order o : set) {
            System.out.print(o.fanId + " ");
        }
    }

    private static class Order {
        int t;
        int d;
        int fanId;

        Order(int fanId, int t, int d) {
            this.fanId = fanId;
            this.t = t;
            this.d = d;
        }
    }

    private static class OrderComparator implements Comparator<Order> {
        @Override
        public int compare(Order o1, Order o2) {
            if (o1.t + o1.d < o2.t + o2.d) {
                return -1;
            } else if (o1.t + o1.d == o2.t + o2.d) {
                if (o1.fanId < o2.fanId) {
                    return -1;
                }
                return 1;
            }
            return 1;
        }
    }
}
