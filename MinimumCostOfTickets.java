// https://leetcode.com/problems/minimum-cost-for-tickets/

// Recurssion
// Time Complexity: Exponential, O(3^N) in the worst case (with memoization, it's lesser).
// Space Complexity: Linear, O(N).

// Memoization
// Time Complexity: O(n)
// Space Complexity:  O(n)

// DP (Bottom-up)
// Time Complexity: O(n)
// Space Complexity:  O(n)

class Solution {
    int[] dp ;

    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        this.dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int option1 = costs[0] + dp[i + 1];
            int j = i;
            while (j < n && days[j] <= days[i] + 6) {
                j++;
            }
            int option2 = costs[1] + dp[j];
            j = i;
            while (j < n && days[j] <= days[i] + 29) {
                j++;
            }
            int option3 = costs[2] + dp[j];

            dp[i] = Math.min(option1, Math.min(option2, option3));
        }

        return dp[0];

        // return helper(days, costs, 0);
    }

    private int helper(int[] days, int[] costs, int idx) {
        //base
        if(idx >= days.length) {
            return 0;
        }

        //logic
        // 1 day pass
        int option1 =  costs[0] + helper(days, costs, idx+1);

        // 7 day pass
        int i = idx;
        while(i < days.length && days[i] <= days[idx]+6) {
            i++;
        }
        int option2 = costs[1] + helper(days, costs, i);

        // 30 day pass
        int j = idx;
        while(j < days.length && days[j] <= days[idx]+29) {
            j++;
        }
        int option3 = costs[2] + helper(days, costs, j);

        dp[idx] = Math.min(option1, Math.min(option2, option3));

        return dp[idx];

    }
}

