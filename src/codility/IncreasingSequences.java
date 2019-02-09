package codility;

public class IncreasingSequences {

    public static void main(String[] args) {
        System.out.println(new IncreasingSequences().solution(new int[]{5, 3, 7, 7, 10}, new int[]{1, 6, 6, 9, 9}));
        System.out.println(new IncreasingSequences().solution(new int[]{5, -3, 6, 4, 8}, new int[]{2, 6, -5, 1, 0}));
        System.out.println(new IncreasingSequences().solution(new int[]{1, 5, 6}, new int[]{-2, 0, 2}));
        System.out.println(new IncreasingSequences().solution(new int[]{5, 3, 7,7,10}, new int[]{2,6,6,9,9}));
    }

    public int solution(int[] A, int[] B) {
        int steps = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1] || B[i] < B[i - 1]) {
                if (B[i] > A[i - 1] && A[i] > B[i - 1]) {
                    int t = A[i];
                    B[i] = A[i];
                    A[i] = t;
                    steps++;
                } else {
                    return -1;
                }
            }
        }
        return steps;
    }


}
