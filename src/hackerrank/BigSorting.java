package hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BigSorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n = in.nextInt();
        ArrayList<String> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(in.next());
        }
        Collections.sort(arr, (s1, s2) -> {
            if (s1.length() < s2.length()) {
                return -1;
            } else if (s1.length() == s2.length()) {
                int i = 0;
                while (i < s1.length()) {
                    if (s1.charAt(i) < s2.charAt(i)) {
                        return -1;
                    }
                    if (s1.charAt(i) > s2.charAt(i)) {
                        return 1;
                    }
                    i++;
                }
                return 0;
            }
            return 1;
        });
        StringBuilder b = new StringBuilder();
        arr.stream().forEach(x -> b.append(x + "\n"));
        System.out.print(b.toString());
    }
}
