// Time Complexity : O(N)
// Space Complexity : O(1) - because max it can be 365 days only
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int maxDay = days[days.length-1];
        int[] dp = new int[maxDay+1];
        int[] passes = {1,7,30};
        Set<Integer> set = new HashSet<>();
        for(int day:days) set.add(day);
        for(int day=1;day<dp.length;day++) {
            // on every day we have a schedule for,
            // we have three choices to make, according to how much we have spent/ or how we could have optimized the spending upon taking differnt passes
            if(set.contains(day)) {
                int min = Integer.MAX_VALUE;
                for(int pass=0;pass<passes.length;pass++) {
                    min = Math.min(min, costs[pass]+(day >= passes[pass] ? dp[day-passes[pass]] : 0));
                }
                dp[day] = min;
            } else {
                dp[day] = dp[day-1];
            }
        }
        return dp[maxDay];
    }
}
