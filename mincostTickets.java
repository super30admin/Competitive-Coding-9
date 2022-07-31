class Main {
    // to store minimum value
    private static int min;

    // approch 1 recursion
    public static int mincostTickets1(int[] days, int[] costs) {
        min = Integer.MAX_VALUE;
        // recursion function
        helper(days, costs, 0, 0);
        return min;

    }

    private static void helper(int[] days, int[] costs, int idx, int curr) {
        // System.out.println(curr+ " " + idx);
        // base case
        if (idx == days.length) {
            min = Math.min(curr, min);
            return;
        }
        // main function
        // at each index I have three options take 1 day pass
        // 7 day pass or 30 day pass
        // If i take one day pass include costs[0] into current and increase index by 1
        helper(days, costs, idx + 1, curr + costs[0]);
        // temp for cover 7 days
        int temp = idx;
        while (temp < days.length && days[temp] - days[idx] < 7) {
            // System.out.println(days[idx]-days[temp]);
            temp++;
        }
        // If i take one day pass include costs[1] into current and increase index until
        // we cover 7 days
        helper(days, costs, temp, curr + costs[1]);
        // reset temp
        temp = idx;
        while (temp < days.length && days[temp] - days[idx] < 30) {
            // System.out.println(days[idx]-days[temp]);
            temp++;
        }
        // If i take one day pass include costs[1] into current and increase index until
        // we cover 30 days
        helper(days, costs, temp, curr + costs[2]);
    }

    // approch 2 dp
    public static int mincostTickets2(int[] days, int[] costs) {
        // null case
        if (days == null || days.length == 0)
            return 0;
        int n = days.length;
        // dp array
        int dp[] = new int[n + 1];
        // intially dp[0] will be 0 as we are going till first in days index
        // and to handle bound
        dp[0] = 0;
        // traverse in days array
        for (int i = 1; i <= n; i++) {
            // at each index I have three option take 1 day pass
            // 7 day pass or 30 day pass
            // if I take 1 day pass I will get total cost by dp[i-1] + 1 day pass cost
            int op1 = dp[i - 1] + costs[0];
            // to going back If i buy 7 day pass or 30 day pass
            int temp = i;
            while (temp > 0 && days[i - 1] - days[temp - 1] < 7) {
                // System.out.println(days[temp-1] - days[i-1]);
                temp--;
            }
            // after getting previous 7 days we are adding remaining days that is not
            // covered
            int op2 = dp[temp] + costs[1];
            // reset temp
            temp = i;
            // while we include all previous 30 days we are decreasing temp;
            while (temp > 0 && days[i - 1] - days[temp - 1] < 30) {
                temp--;
            }
            // after getting previous 30 days we are adding remaining days that is not
            // covered
            int op3 = dp[temp] + costs[2];
            // dp[i] will be minimum between all three options
            dp[i] = Math.min(op1, Math.min(op2, op3));
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int[] days = new int[] { 3, 5, 6, 7, 8, 10, 12, 15, 16, 18, 19, 21, 23, 24, 25, 26, 27, 28, 29, 37, 38, 39, 40,
                48, 49, 52, 54, 55, 57, 61, 63, 65, 66, 69, 73, 75, 77, 78, 81, 83, 84, 85, 88, 89, 90, 91, 93, 94, 96,
                99 };
        int[] costs = new int[] { 5, 26, 98 };
        System.out.println(mincostTickets1(days, costs));
        System.out.println(mincostTickets2(days, costs));

    }
}