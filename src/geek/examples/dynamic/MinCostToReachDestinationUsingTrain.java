package geek.examples.dynamic;

public class MinCostToReachDestinationUsingTrain {
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int costMatrix[][] = {{0, 15, 80, 90},
                {INF, 0, 40, 50},
                {INF, INF, 0, 70},
                {INF, INF, INF, 0}
        };
        int minCost = minCost(costMatrix, 4);
        System.out.println(minCost);
    }

    private static int minCost(int[][] costMatrix, int N) {
        int dist[] = new int[N];
        for (int i = 1; i < dist.length; i++) {
            dist[i] = INF;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= i; j++) {
                int distanceFromHere = dist[j] + costMatrix[j][i];
                if (dist[i] > distanceFromHere) {
                    dist[i] = distanceFromHere;
                }
            }
        }
        return dist[N - 1];
    }


}
