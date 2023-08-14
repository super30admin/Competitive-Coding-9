// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> daySet = new HashSet<>();
        int max = days[days.length - 1];
        for(int i = 0; i <  days.length; i++){
            daySet.add(days[i]);
        }
        int dp[] = new int[max+1];
        dp[0] = 0;
        for(int i = 1; i < dp.length;i++){
            if(!daySet.contains(i)){
                dp[i] = dp[i-1];
                continue;
            }
            dp[i] = Math.min(dp[i-1] + costs[0], //1 day
                            Math.min(dp[Math.max(0,i-7)] + costs[1], // 7 day
                            dp[Math.max(0,i-30)] + costs[2])); //30 day optiom
        }
        return dp[dp.length - 1];
    }
}