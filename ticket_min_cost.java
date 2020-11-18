// Time Complexity: O(N)
// Space Complexity: O(N)
// Passes Leetcode

class Solution {
    int[] dp;
    int[] days;
    int[] costs;
    
    public int helper(int start, int end, int cost) {
        
        if (start > end)
            return cost;
        
        if (dp[start] > 0)
            return dp[start] + cost;
        int minVal;
        // 1 D pass

        minVal = helper(start + 1, end, costs[0]);
        
        // 7D Pass
        
        
        int i = start;
        int duration = days[start] + 7;
        while (i < days.length && days[i] < duration) {
            i++;
        }
        
        if (i < days.length)
            minVal = Math.min(minVal, helper(i, end, costs[1]));
        else
            minVal = Math.min(minVal, costs[1]);
        // 3D pass
        
        
        i = start;
        duration = days[start] + 30;
        while (i < days.length && days[i] < duration) {
            i++;
        }
        
        if (i < days.length)
            minVal = Math.min(minVal, helper(i, end, costs[2]));
        else
            minVal = Math.min(minVal, costs[2]);
        
        dp[start] = minVal;
        
        return minVal + cost;
    }
    
    public int mincostTickets(int[] days, int[] costs) {
        
        
        dp = new int[days.length];
        
        this.days = days;
        this.costs = costs;
        
        return helper(0, days.length - 1, 0);
        
        
    }
}