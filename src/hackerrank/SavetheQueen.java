package hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// TODO incorrect implementation.
class SavetheQueen {

    /*
     * Complete the 'solve' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY a
     */


    public static void main(String[] args) {
        solve(3, Arrays.asList(1000, 100, 100, 100));
    }

    public static void solve(int n, List<Integer> a) {
        // Print your result
        int elapsedTime = 0;
        a.sort(Comparator.reverseOrder());
        //deployment
        PriorityQueue<Integer> deployed = new PriorityQueue<>(a.subList(0, n));
        PriorityQueue<Integer> bench = new PriorityQueue<>(Comparator.reverseOrder());
        bench.addAll(a.subList(n, a.size()));
        while (deployed.size() >= n) {
            int undeployed = 1;
            Integer min = deployed.poll();
            while (!deployed.isEmpty()) {
                if (min.equals(deployed.peek())) {
                    deployed.poll();
                    undeployed++;
                } else {
                    break;
                }
            }
            elapsedTime += min;
            if (bench.size() < undeployed) {
                break;
            }
            for (int i = 1; i <= undeployed; i++) {
                deployed.add(bench.poll());
            }
        }
        System.out.println(elapsedTime);


    }

}
