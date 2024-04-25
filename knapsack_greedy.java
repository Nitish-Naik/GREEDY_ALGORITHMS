import java.util.Arrays;
import java.util.Comparator;

public class knapsack_greedy {
    static double knapsack(int profit[], int weight[], int capacity) {
        double matrix[][] = new double[profit.length][3];

        for (int i = 0; i < profit.length; i++) {
            matrix[i][0] = profit[i];
            matrix[i][1] = weight[i];
            matrix[i][2] = (double) profit[i] / weight[i];
        }
        double totalSum = 0;

        Arrays.sort(matrix, Comparator.comparingDouble(o -> -o[2]));
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][1] <= capacity) {
                totalSum += matrix[i][0];
                capacity -= matrix[i][1];
            } else {
                // totalSum += matrix[i][2] * capacity;
                // System.out.println(totalSum);
                double remaining = capacity/matrix[i][1];
                totalSum += remaining * matrix[i][0];
            }
        }
        return totalSum;
    }

    public static void main(String[] args) {
        int profit[] = {500};
        int weight[] = {30};
        int capacity = 10;
        System.out.println(knapsack(profit, weight, capacity));
        System.out.println(500/3);
    }
}
