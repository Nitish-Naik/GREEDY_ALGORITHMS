import java.util.ArrayList;
import java.util.Collections;

public class matrix {

    public static void main(String[] args) {
        int[][] a = {
            {0, 0, 0},
            {1, 1, 0},
            {0, 1, 0},
            {1, 0, 1}
        };

        int minRowIndex = -1; // Initialize with an invalid index
        int minCount = Integer.MAX_VALUE; // Initialize with maximum possible value
        for (int row = 0; row < a.length; row++) {
            int count = 0;
            for (int col = 0; col < a[0].length; col++) {
                if (a[row][col] == 1) {
                    count++;
                }
            }
            if (count < minCount) {
                minCount = count;
                minRowIndex = row;
            }
        }
        System.out.println(minRowIndex + 1); // Since indexing is 1-based
    }
}
