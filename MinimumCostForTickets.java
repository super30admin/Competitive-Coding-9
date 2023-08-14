import java.util.HashSet;
import java.util.Set;

// Time Complexity : O(max(n, l)) where n = length of days array, l = largest element of days array
// Space Complexity : O(n) where n = length of days array
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//983. Minimum Cost For Tickets (Medium) - https://leetcode.com/problems/minimum-cost-for-tickets/
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int largest = days[days.length-1];
        int[] dp = new int[largest+1];
        dp[0] = 0;
        
        Set<Integer> set = new HashSet<>();
        // easy checking for days present
        for (int day : days) { // O(n)
            set.add(day);
        }
        
        for (int day = 1; day < dp.length; day++) { // O(n)
            
            if (set.contains(day)) { // O(1)
                dp[day] = Math.min(dp[day-1] + costs[0], Math.min(dp[Math.max(0, day-7)] + costs[1], dp[Math.max(0, day-30)] + costs[2]));
            } else {
                dp[day] = dp[day-1];
            }
        }
        
        return dp[dp.length-1];
    }
}