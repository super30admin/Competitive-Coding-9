// Time Complexity : O(n) where n is the length of the DP array. If we assume n cant exceed 365 days, then it is O(1)
// Space Complexity : O(n) where n is the length of the DP array. If we assume n cant exceed 365 days, then it is O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Pattern recognition in terms of code took time
/* Your code here along with comments explaining your approach: Create a DP array with days starting from 1 to Max(day) mentioned in the days list.
For each of the day starting from the first day, we need to take the minimum cost ticket, out of the three choice which we have. For the each of
the days we have all the 3 choices, but only for 1 day passes we can use the previous cost till day 7. After day 7, we could consider what would have
been the minimum if we would have bought the ticket 7 days back including the cost we already had 7 days back and if we buy the ticket of 1 day pass
today + the previous day cost, or we simply buy the 30 day pass. Similarly, we can check for 30 day scenario. 
*/
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length-1] + 1];                                                // dp array till max(day)
        HashSet<Integer> set = new HashSet<>();
        for(int i : days){
            set.add(i);                                                                                     // Add it to set for O(1) retrieval
        }
        for(int i = 1; i < dp.length; i++){
            if(set.contains(i)){                                                                                // if the set contains the day
            if(i >= 30){
               dp[i] = Math.min(dp[i-1] + costs[0], Math.min(dp[i-7] + costs[1], dp[i-30] + costs[2]));               // all 3 choices with previous 7th, 30th, 1 day cost
            } else
            if(i >= 7) {
                dp[i] = Math.min(dp[i-1] + costs[0], Math.min(dp[i-7] + costs[1], costs[2]));               // for 30, we will simply take the pass cost since < 30
            } else {    
                dp[i] = Math.min(dp[i-1] + costs[0], Math.min(costs[1], costs[2]));                             // for 7 and 30, take simply the pass cost
            }
            } else {    
                dp[i] = dp[i-1];                                                                        // if I am not travelling today, no additional cost
            }    
        }
        return dp[dp.length-1];                                                                                         // Return the total cost
    }
}