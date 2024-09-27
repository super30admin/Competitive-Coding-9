import java.util.HashSet;

public class Problem1 {

    // DP solution 2d Array
    // TC : O(n)
    // SC : O(n) where n = highest days
    public int mincostTickets1(int[] days, int[] costs) {
        if (days == null || days.length == 0) return 0;

        int m = costs.length;
        HashSet<Integer> set = new HashSet<>();

        int max = Integer.MIN_VALUE;
        for (int day : days) {
            set.add(day);
            max = Math.max(max, day);
        }
        int[][] dp = new int[m + 1][max + 1];


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= max; j++) {
                if (!set.contains(j)) {
                    dp[i][j] = dp[i][j - 1];
                } else {
                    if (j == max) {
                        System.out.println("Debugger point");
                    }
                    dp[i][j] = Math.min(dp[i][j - 1] + costs[0], Math.min(dp[i][Math.max(0, j - 7)]
                            + costs[1], dp[i][Math.max(0, j - 30)] + costs[2]));
                }

            }
        }
        return dp[m][max];
    }

    // DP solution 1d Array
    // TC : O(n)
    // SC : O(n) where n = highest days
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for (int day : days) {
            set.add(day);
            max = Math.max(max, day);
        }
        int[] dp = new int[max + 1];

        for (int i = 1; i <= max; i++) {
            if (!set.contains(i)) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.min(dp[i - 1] + costs[0], Math.min(dp[Math.max(0, i - 7)]
                        + costs[1], dp[Math.max(0, i - 30)] + costs[2]));
            }
        }
        return dp[max];
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        //int[] days = {1, 4, 6, 7, 8, 20};
        int[] days = {1, 2, 3, 4, 6, 8, 9, 10, 13, 14, 16, 17, 19, 21, 24, 26, 27, 28, 29};
        //int[] days= {1,2,3,4,5,6,7,8,9,10,30,31};
        //int[] costs = {2, 7, 15};
        int[] costs = {3, 14, 50};
        System.out.println("Min cost to travel is : " + problem1.mincostTickets1(days, costs));
    }
}
