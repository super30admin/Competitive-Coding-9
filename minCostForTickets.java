// https://leetcode.com/problems/minimum-cost-for-tickets/

// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Take the days into a set and last day as last element in the array. Go from 1 to last day and if the day is not in set then dp[i] = dp[i-1] else
 * dp[i] = min(dp[i-1]+costs[0], min(dp[Math.max(0, i-7)]+costs[1], dp[Math.max(0,i-30)]+costs[2]))). Finally return dp[lastday].
 */
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int lastDay = days[n-1];
        int []dp = new int[lastDay+1];  // the last day in array is 20 so 0-20 days
        HashSet<Integer> set = new HashSet<>();
        dp[0] = 0;
        for(int i:days){
            set.add(i);   // add all days in days array to hash set
        }
        // while moving from day 1 - day 20, while you dont have a day in days array just
        // copy the amount else get min amount of below condition
        for(int i = 1;i<=lastDay;i++){
            if(!set.contains(i)){   
            dp[i] = dp[i-1];
        }
        else{
            dp[i] = Math.min(dp[i-1]+costs[0], Math.min(dp[Math.max(0, i-7)]+costs[1], dp[Math.max(0,i-30)]+costs[2]));
        }
        }
        return dp[lastDay];
    }
}