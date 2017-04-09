package geek.examples;

public class CountPairsFormedByDistinctElementSubArrays {
    private static int c = 0;

    public static void main(String[] args) {
        int n = 1000;
        int contextUnique[] = new int[n];
        for (int i = 0; i < contextUnique.length; i++) {
            contextUnique[i] = -1;
        }
        int arr[] = {1, 4, 2, 4, 3, 2};
        int j = 1;
        int i = 0;
        contextUnique[arr[0]] = 0;
        while (j != arr.length) {
            if (contextUnique[arr[j]] == -1) {
                contextUnique[arr[j]] = j;
            } else {
                c+=(j-i);
                i = contextUnique[arr[j]] + 1;
                contextUnique[arr[j]] = -1;
            }
            j++;
        }
        c+=(j-1-i);
        System.out.println(c);
    }
}
