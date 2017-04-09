package hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DownToZero {
    static int operations[] = new int[1000002];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int i = 1; i <= q; i++) {
            process(in.nextInt());
        }
    }


    static void process(int n) {
        if (n == 0) {
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        operations[n] = 1;
        while (!q.isEmpty()) {
            int now = q.peek();
            System.out.println("now :"+now);
            q.remove();
            if (operations[now - 1] == 0) {
                //steps that will take to reach from n to now-1 is steps[now]+1
                operations[now - 1] = operations[now] + 1;
                if (now - 1 == 0)
                    break;
                System.out.println(now-1+" added to q");
                q.add(now - 1);
            }
            for (int i = 2; i * i <= now; i++) {
                if (now % i == 0) {
                    int factor = Math.max(i, now / i);
                    System.out.println("for "+i+" max factor is "+factor);
                    if (operations[factor] == 0) {
                        operations[factor] = operations[now] + 1;
                        System.out.println(factor +" Fact added to q");
                        q.add(factor);
                    }
                }
            }
        }
        System.out.println(operations[0] - 1);
    }

}
