// Time Complexity: O(n * 3) = O(n)
// Space Complexity: O(n)
// Did the code run on Leetcode: Yes

// Approach: Dynamic Programming
// 1. Create a dp array where dp[i] represents the minimum cost to cover days[0] to days[i-1].
// 2. For each day, check the cost of using each type of ticket (1-day, 7-day, 30-day).
// 3. For each ticket type, find the last day that can be covered by that ticket.
// 4. Update the dp array with the minimum cost for that day.

class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        int n = days.size();
        vector<int> dp(n + 1, 0);  // dp[i] represents min cost to cover days[0] to days[i-1]

        vector<int> durations = {1, 7, 30};

        for (int i = 1; i <= n; i++) {
            dp[i] = INT_MAX;
            for (int j = 0; j < 3; j++) {
                int prev_day = i - 1;
                while (prev_day >= 0 && days[prev_day] > days[i - 1] - durations[j]) {
                    prev_day--;
                }
                dp[i] = min(dp[i], costs[j] + dp[prev_day + 1]);
            }
        }

        return dp[n];
    }
};
