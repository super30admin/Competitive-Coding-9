// Time Complexity : O(max(days))
// Space Complexity : O(max(days))
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * 1. Create a hashset of all the travel days. It is used to check if a day is a travel day or not.
 * 2. Create a memo array to store the minimum cost for each day.
 * 3. If the current day is not a travel day, then move to the next day.
 * 4. If the current day is a travel day, then calculate the cost for 1 day, 7 days and 30 days and return the minimum of the three.
 */

import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> travelDays = new HashSet<>();
        int[] memo = new int[days[days.length-1]+1];
        Arrays.fill(memo, -1);

        for(int day : days){
            travelDays.add(day);
        }

        return helper(days, costs, days[0], travelDays, memo);
    }

    private int helper(int[] days, int[] costs, int currDay, HashSet<Integer> travelDays, int[] memo){
        if(currDay > days[days.length-1]){
            return 0;
        }

        if(memo[currDay] != -1){
            return memo[currDay];
        }

        if(!travelDays.contains(currDay)){
            return memo[currDay] = helper(days, costs, currDay+1, travelDays, memo);
        }

        int cost1 = costs[0] + helper(days, costs, currDay+1, travelDays, memo);
        int cost2 = costs[1] + helper(days, costs, currDay+7, travelDays, memo);
        int cost3 = costs[2] + helper(days, costs, currDay+30, travelDays, memo);

        return memo[currDay] = Math.min(cost1, Math.min(cost2, cost3));
    }
}