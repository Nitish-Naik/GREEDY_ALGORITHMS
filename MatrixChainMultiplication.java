import java.util.Arrays;

public class MatrixChainMultiplication {
    static int[][] dp;
    static int[][] split;

    static int matrixChainOrder(int[] dimensions) {
        int n = dimensions.length - 1;
        dp = new int[n + 1][n + 1];
        split = new int[n + 1][n + 1];

        // Initialize dp[][] with zeros
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
            Arrays.fill(split[i], -1);
        }

        return memoizedMatrixChain(dimensions, 1, n);
    }

    static int memoizedMatrixChain(int[] dimensions, int i, int j) {
        if (i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int cost = memoizedMatrixChain(dimensions, i, k) +
                       memoizedMatrixChain(dimensions, k + 1, j) +
                       dimensions[i - 1] * dimensions[k] * dimensions[j];
            if (cost < dp[i][j]) {
                dp[i][j] = cost;
                split[i][j] = k;
            }
        }
        return dp[i][j];
    }

    static void printOptimalParenthesization(int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printOptimalParenthesization(i, split[i][j]);
            printOptimalParenthesization(split[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        int[] dimensions = {10, 30, 5, 60};
        System.out.println("Minimum number of scalar multiplications needed: " + matrixChainOrder(dimensions));
        System.out.print("Optimal parenthesization: ");
        printOptimalParenthesization(1, dimensions.length - 1);
    }
}
