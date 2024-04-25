public class KnapsackDynamicProgramming {
    static int knapsack(int capacity, int weights[], int values[], int n) {
        int dp[][] = new int[n + 1][capacity + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (weights[i - 1] <= j)
                    dp[i][j] = Math.max(values[i - 1] + dp[i - 1][j - weights[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }

        return dp[n][capacity];
    }

    public static void main(String args[]) {
        int values[] = {120, 60, 100};
        int weights[] = {30, 10, 20};
        int capacity = 50;
        int n = values.length;
        System.out.println("Maximum value that can be obtained: " + knapsack(capacity, weights, values, n));
    }
}
