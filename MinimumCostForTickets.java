/*
 * #983. Minimum Cost For Tickets
 * 
 * In a country popular for train travel, you have planned some train travelling one year in advance.  
 * The days of the year that you will travel is given as an array days.  Each day is an integer from 1 to 365.

Train tickets are sold in 3 different ways:

1. a 1-day pass is sold for costs[0] dollars;
2. a 7-day pass is sold for costs[1] dollars;
3. a 30-day pass is sold for costs[2] dollars.

The passes allow that many days of consecutive travel.  For example, if we get a 7-day pass on day 2, then we can travel for 7 days: day 2, 3, 4, 5, 6, 7, and 8.

Return the minimum number of dollars you need to travel every day in the given list of days.

 

Example 1:

Input: days = [1,4,6,7,8,20], costs = [2,7,15]
Output: 11
Explanation: 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
In total you spent $11 and covered all the days of your travel.

Example 2:

Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
Output: 17
Explanation: 
For example, here is one way to buy passes that lets you travel your travel plan:
On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
In total you spent $17 and covered all the days of your travel.
 

Note:

1. 1 <= days.length <= 365
2. 1 <= days[i] <= 365
3. days is in strictly increasing order.
4. costs.length == 3
5. 1 <= costs[i] <= 1000

 */

/*
 * Time Complexity: O (D) -> for loop to traverse number of days -> 1 to 20, 'D' is the number of days
 * 
 * Space Complexity: O (D) -> A DP array of length -> lastDay+1 = 20+1 = 21 = O (lastDay) = O (D)
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */

package com.s30.edu.competitvecoding9;

import java.util.HashSet;

public class MinimumCostForTickets {
	public int mincostTickets(int[] days, int[] costs) {
	       
        // #1. Base condition
        if(days.length == 0 || costs.length == 0){
            return 0;
        }
       
        // #2. Compute last day of travel
        int lastDay = days[days.length-1]; // days[5] = 20
       
        /*
        *   We need one DP array, to compute minimum cost to travel all given days, length of array = lastDay+1 = 21 -> 0 ..... 20 indices
        */
        // #3. Create a DP array of length 'lastDay+1'
        int[] dp = new int[lastDay+1];
       
       
        /*
        *   We need a Set to keep track of days to travel.
        *   While creating/filling a DP array, we will not be able to check if a day is a travel day or not based on index in 'days' array.
        *   It will throw OutOfBounds exception. So copy all travel days in a Set, lookup will be constant, O (1)
        */
        // #4. Create a Set
        HashSet<Integer> set = new HashSet<Integer>();
       
        // #5. copy travel days from 'days' array in a Set
        for(int day : days){
            set.add(day);
        }
       
        // #6. Start with day 1
        for(int i = 1; i <= lastDay; i++){
           
            // #6.1. Check if that day is a travel day
            if(!set.contains(i)){ // not a travel day, no need to buy any passes, copy the previous minimum cost
                dp[i] = dp[i-1];
                continue; // continue is to avoid computing options of 3 passes for 'not a travel' day
            }
           
            // #6.2. Consider given passes option for a travel day and see which incurs minimum cost
            dp[i] = dp[i-1] + costs[0]; // Considering a travel day for one-day pass
                                        // dp[i-1] -> previous minimum cost, costs[0] -> one day pass cost, set this as min cost for 'i' in dp array
            dp[i] = Math.min(costs[1] + dp[Math.max(i-7,0)], dp[i]); // Considering a travel day for seven-day pass
                                                                     // Get the minimum of 7-day pass cost and current cost of day 'i' in dp array
                                                                     // dp[Math.max(i-7,0)] is done to get previous cost, if (i-7) is negative then get                                                                      // the minimum cost from 0th index in dp array
            dp[i] = Math.min(costs[2] + dp[Math.max(i-30,0)], dp[i]); // Considering a travel day for 30-day pass
                                                                     // Get the minimum of 30-day pass cost and current cost of day 'i' in dp array
               
        }
       
        return dp[lastDay]; // minimum cost to travel all days
       
    }
	
}
