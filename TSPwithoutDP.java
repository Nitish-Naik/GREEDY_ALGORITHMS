import java.util.Arrays;

public class TSPwithoutDP {
    static int[][] graph;

    static int tsp(int[] path, int pos, int mask) {
        int n = graph.length;
        if (mask == (1 << n) - 1) { // All cities visited
            return graph[path[pos]][0]; // Return to the starting city
        }

        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) { // City i not visited
                int newMask = mask | (1 << i);
                int newPath[] = Arrays.copyOf(path, n);
                newPath[pos + 1] = i;
                int distance = graph[path[pos]][i] + tsp(newPath, pos + 1, newMask);
                minDistance = Math.min(minDistance, distance);
            }
        }

        return minDistance;
    }

    public static void main(String[] args) {
        graph = new int[][] {
            {0, 10, 15, 20},
            {10, 0, 35, 25},
            {15, 35, 0, 30},
            {20, 25, 30, 0}
        };

        int n = graph.length;
        int[] path = new int[n];
        path[0] = 0; // Start from city 0
        int minDistance = tsp(path, 0, 1); // Start with mask indicating city 0 is visited

        System.out.println("Shortest possible route length: " + minDistance);
    }
}
