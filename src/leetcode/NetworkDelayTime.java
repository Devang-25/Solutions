package leetcode;

public class NetworkDelayTime {


    public static void main(String[] args) {
        final int i = new NetworkDelayTime().networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 2}, {1, 3, 2}}, 3, 1);
        System.out.println(i);
    }


    int minDistance(int V, int dist[], Boolean sptSet[]) {

        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    public int networkDelayTime(int[][] times, int V, int src) {
        src = src-1;
        int[][] graph = new int[V][V];

        for (int[] time : times) {
            graph[time[0] - 1][time[1] - 1] = time[2];
        }

        int[] dist = new int[V];

        Boolean[] sptSet = new Boolean[V];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }


        dist[src] = 0;


        for (int count = 0; count < V - 1; count++) {

            int u = minDistance(V, dist, sptSet);

            sptSet[u] = true;

            for (int v = 0; v < V; v++)


                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }


        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(dist[i], max);
        }
        return max;
    }


}
