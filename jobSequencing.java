import java.util.*;

public class jobSequencing {
    static void jobsequencing(int jobsInfo[][]) {
        Arrays.sort(jobsInfo, Comparator.comparingInt(o -> -o[2]));
        int maxDeadline = 0;
        for (int[] job : jobsInfo) {
            maxDeadline = Math.max(maxDeadline, job[1]);
        }
        boolean[] slot = new boolean[maxDeadline];
        ArrayList<Integer> ans = new ArrayList<>();
        int profit = 0;
        for (int i = 0; i < jobsInfo.length; i++) {
            for (int j = Math.min(maxDeadline, jobsInfo[i][1]) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    ans.add(jobsInfo[i][0]);
                    slot[j] = true;
                    profit += jobsInfo[i][2];
                    break;
                }
            }
        }
        System.out.println("Maximum profit: " + profit);
        System.out.println("Job sequence: " + ans);
    }

    public static void main(String[] args) {
        int[][] jobsInfo = {{1, 2, 100}, {2, 1, 19}, {3, 2, 27}, {4, 1, 25}, {5, 1, 15}};
        jobsequencing(jobsInfo);
    }
}
