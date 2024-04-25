import java.util.Arrays;

public class TSP {
    static final int INF = Integer.MAX_VALUE / 2;

    static int tsp(int[][] graph) {
        int n = graph.length;
        int[][] dp = new int[n][1 << n];

        // Initialize dp[][] with INF
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }

        // Base case: starting city to itself with empty subset
        dp[0][1] = 0;

        // Fill the dp[][] table using bottom-up approach
        for (int mask = 1; mask < (1 << n); mask++) {
            for (int u = 0; u < n; u++) {
                if ((mask & (1 << u)) == 0) continue; // Skip if city u is not in the subset represented by mask
                for (int v = 0; v < n; v++) {
                    if ((mask & (1 << v)) != 0) continue; // Skip if city v is already visited
                    dp[v][mask | (1 << v)] = Math.min(dp[v][mask | (1 << v)], dp[u][mask] + graph[u][v]);
                }
            }
        }

        // Find the minimum distance to return to the starting city
        int minDistance = INF;
        for (int v = 1; v < n; v++) {
            minDistance = Math.min(minDistance, dp[v][(1 << n) - 1] + graph[v][0]);
        }

        return minDistance;
    }

    public static void main(String[] args) {
        int[][] graph = {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        System.out.println("Shortest possible route length: " + tsp(graph));
    }
}
