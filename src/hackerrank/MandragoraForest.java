package hackerrank;

import java.util.Arrays;
import java.util.Scanner;
//https://www.hackerrank.com/challenges/mandragora/editorial
public class MandragoraForest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a = 0; a < t; a++) {
            int n = in.nextInt();
            int[] arr = new int[n];
            for (int arr_i = 0; arr_i < n; arr_i++) {
                arr[arr_i] = in.nextInt();
            }
            Arrays.sort(arr);
            int ans = 0;
            for (int k = 0; k < n; k++) {
                int p = 0;
                for (int i = k; i < n; i++) {
                    p += arr[i] * (k + 1);
                    ans = Math.max(ans, p);
                }
            }
        }
    }
}

/*
* h.sort()

ans = 0
for k in range(n)[::-1]:
    p = 0
    for i in range(k, n):
        p += h[i]

    ans = max(ans, p * (k + 1))

print(ans)
*/


/*
*
* h.sort()

ans = 0
p = 0
for k in range(n)[::-1]:
    p += h[k]

    ans = max(ans, p * (k + 1))

print(ans)
*/
