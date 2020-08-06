// Time Complexity - O(n) n = length of dp array which is max of 366 days which is O(1)
// Space Complexity - O(n) n = length of dp array which is max of 366 days which is O(1)

// Approach
// Create a DP array with days starting from 1 to max no of days mentioned in days list.
// For each of the day starting from 1st day, we nee dto take min cost ticket, out of 3 choices.
// For each of the days we have 3 choices, but only for 1 day passes we can use previous cost till day 7.
// After day 7, we can consider what would have been the min if we would have bough the ticket 7 days ago including
// the cost we already had 7 days back and if we buy the ticket of 1 day pass today+ the prev day cost, or we simply buy 30 day pass.
// Similarly, we check for 30 day.

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length-1]+1];
        HashSet<Integer> set = new HashSet<>();
        for(int i:days) {
            set.add(i);
        }
        for(int i=1;i<dp.length;i++) {
            if(set.contains(i)) {
                if(i>=30) {
                    dp[i] = Math.min(dp[i-1]+costs[0],Math.min(dp[i-7]+costs[1],dp[i-30]+costs[2]));
                } else if(i>=7) {
                    dp[i] = Math.min(dp[i-1]+costs[0],Math.min(dp[i-7]+costs[1],costs[2]));
                } else {
                    dp[i] = Math.min(dp[i-1]+costs[0],Math.min(costs[1],costs[2]));
                }
            } else {
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}