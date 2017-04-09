package hackerrank;

import java.util.PriorityQueue;
import java.util.Scanner;

public class JesseAndCookies {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        PriorityQueue<Long> pQ = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            pQ.add(in.nextLong());
        }
        int operations = 0;
        while (!pQ.isEmpty() && pQ.peek() < k) {
            long a = pQ.poll();
            if (pQ.isEmpty()) {
                break;
            } else {
                pQ.add(a + 2 * pQ.poll());
                operations++;
            }
        }
        if (pQ.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(operations);
        }

    }
}
