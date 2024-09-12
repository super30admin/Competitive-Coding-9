// Time Complexity : O(Max(days))
// Space Complexity :O(Max(days))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int day: days)
            set.add(day);
        
        int[] dp = new int[days[days.length-1]+1];
        
        
        for(int i=1; i<dp.length; i++){
            if(!set.contains(i))
                dp[i] = dp[i-1];
            else{
                dp[i] = Math.min(dp[i-1]+costs[0], 
                        Math.min(dp[Math.max(i-7, 0)]+costs[1], 
                        dp[Math.max(i-30, 0)]+costs[2]));
            }
        }
        
        return dp[dp.length-1];
    }
}