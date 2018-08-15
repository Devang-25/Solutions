package hackerearth.examples.thoughtwork;

import java.io.IOException;
import java.util.Scanner;

public class CountriesGrouping {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int t = 0; t < testCases; t++) {
            int N = in.nextInt();
            int i = 0;
            boolean invalid = false;
            int c = 0;
            while (i < N) {
                int v = in.nextInt();
                c++;
                int j;
                for (j = i + 1; j < i + v && j < N; j++) {
                    int thisV = in.nextInt();
                    if (thisV != v) {
                        invalid = true;
                        break;
                    }
                }
                if (j - i != v) {
                    invalid = true;
                }
                if (invalid) {
                    break;
                }
                i = i + v;
            }
            if (invalid) {
                System.out.println("Invalid Data");
            } else {
                System.out.println(c);
            }
        }
    }
}
