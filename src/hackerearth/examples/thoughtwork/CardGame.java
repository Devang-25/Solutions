package hackerearth.examples.thoughtwork;

import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p1 = in.nextInt();
        ArrayList<Long> p1Cards = new ArrayList<>(p1);
        for (int i = 0; i < p1; i++) {
            p1Cards.add(in.nextLong());
        }
        int p2 = in.nextInt();
        long maxCard = Long.MIN_VALUE;
        for (int i = 0; i < p2; i++) {
            long v = in.nextLong();
            if (v > maxCard) {
                maxCard = v;
            }
        }
        final long max = maxCard + 1;
        long sum = p1Cards.stream().filter(v -> v < max).mapToLong(v -> max - v).sum();
        System.out.println(sum);


    }
}
