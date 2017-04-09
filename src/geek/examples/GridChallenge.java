package geek.examples;

import java.util.Arrays;
import java.util.Scanner;

public class GridChallenge {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int N = in.nextInt();
            String arr[] = new String[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sort(in.next());
            }
            boolean failed = false;
            for (int i = 1; i < N; i++) {
                for (int j = 0; j < arr[i].length(); j++) {
                    if (arr[i].charAt(j) < arr[i - 1].charAt(j)) {
                        failed = true;
                        break;
                    }
                }
                if (failed) {
                    break;
                }
            }
            if (failed) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }

    private static String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
