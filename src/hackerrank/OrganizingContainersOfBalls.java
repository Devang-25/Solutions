package hackerrank;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OrganizingContainersOfBalls {

    // Complete the organizingContainers function below.
    static String organizingContainers(Integer[][] container) {
        List<Long> containerSizes = Arrays.stream(container)
                .map(balls -> Arrays.stream(balls).mapToLong(x -> x.longValue()).sum())
                .sorted()
                .collect(Collectors.toList());
        List<Long> colorCounts = Arrays.stream(transpose(container))
                .map(balls -> Arrays.stream(balls)
                        .mapToLong(x -> x.longValue())
                        .sum())
                .sorted().collect(Collectors.toList());
        //System.out.println(containerSizes);
        //System.out.println(colorCounts);
        if (colorCounts.size() != containerSizes.size()) {
            return "Impossible";
        }

        for (int i = 0; i < colorCounts.size(); i++) {
            if (!colorCounts.get(i).equals(containerSizes.get(i))) {
                return "Impossible";
            }
        }
        return "Possible";
    }

    private static Integer[][] transpose(Integer[][] arr) {
        Integer t[][] = new Integer[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                t[j][i] = arr[i][j];
            }
        }
        return t;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            Integer[][] container = new Integer[n][n];

            for (int i = 0; i < n; i++) {
                String[] containerRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < n; j++) {
                    int containerItem = Integer.parseInt(containerRowItems[j]);
                    container[i][j] = containerItem;
                }
            }

            String result = organizingContainers(container);
            System.out.println(result);
        }

        scanner.close();
    }
}
