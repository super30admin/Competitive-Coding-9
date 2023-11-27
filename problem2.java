// Time Complexity : O(n*max)
// Space Complexity : O(max)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int max = days[days.length-1];
        int[] dp = new int[max+1];
        dp[0] = 0;
        HashSet<Integer> day = new HashSet<>();

        for(int i = 0; i < days.length;i++)
            day.add(days[i]);
        for(int i = 1 ; i <= max; i++){
            if(day.contains(i)){
                int i_30 = Math.max(i-30,0);
                int i_7 = Math.max(i-7,0);
                dp[i] = Math.min(costs[0]+dp[i-1],Math.min(costs[1]+dp[i_7],costs[2]+dp[i_30]));
            }
            else
             dp[i] = dp[i-1];

        }
        return dp[max];

    }
}