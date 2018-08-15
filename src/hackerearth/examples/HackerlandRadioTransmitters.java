package hackerearth.examples;

import java.util.Scanner;
import java.util.TreeSet;

public class HackerlandRadioTransmitters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int r = in.nextInt();
        TreeSet<Integer> h = new TreeSet<>();
        for (int i = 1; i <= n; i++) {
            h.add(in.nextInt());
        }
        Integer s;
        if (!h.isEmpty()) {
            s = h.pollFirst();
        } else {
            System.out.println(0);
            return;
        }
        int t = 0;
        while (s != null) {
            Integer tHouse = h.floor(s + r);//the farther house within the range.
            //System.out.println(tHouse);
            t++;
            if (tHouse != null) {
                s = h.ceiling(tHouse + r + 1);//closest house outside the range
                //System.out.println(s);
            } else {
                if (!h.isEmpty()) {
                    s = h.pollFirst();
                } else {
                    s = null;
                }
            }
        }
        System.out.println(t);
    }
}
