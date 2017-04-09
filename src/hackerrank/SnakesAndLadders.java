package hackerrank;

import java.util.LinkedList;
import java.util.Scanner;

public class SnakesAndLadders {
    static class QueueEntry {
        int vertex;
        int steps;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int move[] = new int[101];
            for (int i = 0; i < 101; i++)
                move[i] = -1;
            int ladders = in.nextInt();
            for (int i = 0; i < ladders; i++) {
                move[in.nextInt()] = in.nextInt();
            }

            int snakes = in.nextInt();
            for (int i = 0; i < snakes; i++) {
                move[in.nextInt()] = in.nextInt();
            }
            System.out.println(minDices(move));
        }
    }

    static int minDices(int move[]) {
        boolean[] visited = new boolean[101];
        LinkedList<QueueEntry> q = new LinkedList<>();
        visited[1] = true;
        QueueEntry s = new QueueEntry();
        s.vertex = 1;
        q.push(s);

        QueueEntry qe = null;
        while (!q.isEmpty()) {
            qe = q.getFirst();
            int v = qe.vertex;
            if (v == 100) {
               break;
            }
            q.removeFirst();
            for (int next = v + 1; next <= (v + 6) && next <=100; next++) {
                if (!visited[next]) {
                    QueueEntry a = new QueueEntry();
                    a.steps = (qe.steps + 1);
                    visited[next] = true;
                    if (move[next] != -1)
                        a.vertex = move[next];
                    else
                        a.vertex = next;
                    q.addLast(a);
                }
            }
        }
        if(q.isEmpty()){
            return -1;
        }
        return qe.steps;
    }

}
