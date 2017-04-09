package hackerrank;

import java.util.*;

public class MinimumAverageWaitingTime {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Order> pQ = new PriorityQueue<>((Order x, Order y) -> {
            if (x.arrivalTime < y.arrivalTime) {
                return -1;
            } else if (x.arrivalTime > y.arrivalTime) {
                return 1;
            } else if (x.pizzaTime < y.pizzaTime) {
                return -1;
            } else if (x.pizzaTime > y.pizzaTime) {
                return 1;
            } else {
                return -1;
            }
        });

        for (int i = 0; i < n; i++) {
            pQ.add(new Order(in.nextInt(), in.nextInt()));
        }
        System.out.println(pQ);
        int total_time = 0;
        int time = pQ.peek().arrivalTime;
        while (!pQ.isEmpty()) {
            Order c = pick_order(pQ, time);
            if (c == null) {
                break;
            }
            System.out.println(c);
            int timeForOrder = time + c.pizzaTime - c.arrivalTime;
            System.out.println(timeForOrder);
            total_time += timeForOrder;
            time += c.pizzaTime;
        }
        System.out.println(total_time / n);
    }

    private static Order pick_order(PriorityQueue<Order> pQ, int current_time) {
        System.out.println(pQ+"-"+current_time);
        List<Order> orders = new ArrayList<>();
        while (!pQ.isEmpty()) {
            Order o = pQ.remove();
            if (o.arrivalTime > current_time) {
                pQ.add(o);
                break;
            }else{
                orders.add(o);
            }
        }
        System.out.println("Selected Orders :"+orders);
        if (orders.isEmpty()) {
            return null;
        }
        Order bestOrder = orders.stream().min((x, y) -> x.pizzaTime - y.pizzaTime).get();
        for (Order ord : orders) {
            if (ord.pizzaTime != bestOrder.pizzaTime) {
                pQ.add(ord);
            }
        }
        System.out.println(pQ);
        return bestOrder;
    }

    private static class Order {
        final int arrivalTime;
        final int pizzaTime;

        private Order(int arrivalTime, int pizzaTime) {
            this.arrivalTime = arrivalTime;
            this.pizzaTime = pizzaTime;
        }

        @Override
        public String toString() {
            return this.arrivalTime + ":" + this.pizzaTime;
        }
    }
}
