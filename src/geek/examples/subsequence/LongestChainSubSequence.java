/**
 *
 */
package geek.examples.subsequence;

import java.util.Scanner;
import java.util.function.BiFunction;

/**
 * @author makkg
 */
public class LongestChainSubSequence<T> {

    private BiFunction<T, T, Boolean> condition;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Integer arr[] = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(new LongestChainSubSequence<Integer>((current, that) -> current > that).longestChainSequence(arr, arr.length));
    }

    public LongestChainSubSequence(BiFunction<T, T, Boolean> condition) {
        this.condition = condition;
    }

    int longestChainSequence(T arr[], int n) {
        int lis[] = new int[n], max = 0;
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (condition.apply(arr[i], arr[j]) && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (max < lis[i]) {
                max = lis[i];
            }
        }

        return max;
    }
}
