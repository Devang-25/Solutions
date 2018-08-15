package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ClimbingLeaderboard {
    // Complete the climbingLeaderboard function below.
    static List<Integer> climbingLeaderBoard(Integer[] scores, Integer[] alice) {
        List<Integer> positions = Arrays.asList(alice).stream().map(a -> search(scores, a, 0, scores.length - 1)).map(x -> x + 1).collect(Collectors.toList());
        return positions;
    }

    private static int search(Integer scores[], int v, int i, int j) {
        System.out.println(i + "," + j + "," + v);
        if (i == j) {
            if (v >= scores[i]) {
                return i;
            }
            return i + 1;
        }
        int mid = (i + j) / 2;
        if (v > scores[mid]) {
            return search(scores, v, i, mid);
        } else if (v < scores[mid]) {
            return search(scores, v, mid + 1, j);
        } else {
            return mid;
        }
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        ArrayList<Integer> scores = new ArrayList<>();
        int prev = -1;
        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            if (prev != scoresItem) {
                scores.add(scoresItem);
                prev = scoresItem;
            }
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        Integer[] alice = new Integer[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        List<Integer> result = climbingLeaderBoard(scores.toArray(new Integer[scores.size()]), alice);
        for (int r : result) {
            System.out.println(r);
        }
        scanner.close();
    }
}
