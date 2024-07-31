// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> set = new HashSet<>();
        int max =  days[days.length - 1];
        for(int i = 0; i<days.length; i++ ){
            set.add(days[i]);
        }

        int dp[] = new int[max+1];
        dp[0] = 0;

        for(int i=1; i<dp.length; i++){
            if(!set.contains(i)){
                dp[i] = dp[i-1];
                continue;
            }
            dp[i] = Math.min(dp[i-1] + costs[0], Math.min(dp[Math.max(0, i-7)] + costs[1], dp[Math.max(0, i-30)] + costs[2]));
        }
        return dp[dp.length -1];
    }
}