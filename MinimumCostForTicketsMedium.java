import java.util.Arrays;

// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :getting started

// Your code here along with comments explaining your approach
public class MinimumCostForTicketsMedium {

    class Solution {
        public int mincostTickets(int[] days, int[] costs) {
            if(days == null || days.length ==0 ) return 0;//edge case

            int maxDays = 366;
            boolean[] travelDays = new boolean[maxDays];

            //set days of travel to true in travel days array
            for(int day:days){
                travelDays[day] = true;
            }

            //Create dp array and fill it with max value
            int[] dp = new int[maxDays];
            Arrays.fill(dp, Integer.MAX_VALUE);

            //set dp base value for 0 day is 0 cost
            dp[0] = 0;

            for (int i = 1; i < maxDays; i++) {
                if(!travelDays[i]){
                    dp[i]=dp[i-1];//get previous days value
                    continue;
                }
                //if condition is true add minmimum to dp array of 7 days cost + 7 days back or current dp at i valuue
                //else add minimum to dp array of 7 days cost or current dp at i value
                dp[i]=Math.min(dp[i-1]+costs[0], dp[i]);
                if(i-7>=0){
                    dp[i]=Math.min(dp[i-7]+costs[1], dp[i]);
                }else{
                    dp[i] = Math.min(dp[i], costs[1]);
                }

                //if condition is true add minmimum to dp array of 30 days cost + 30 days back or current dp at i valuue
                //else add minimum to dp array of 30 days cost or current dp at i value
                if(i-30>=0){
                    dp[i]=Math.min(dp[i-30]+costs[2], dp[i]);
                }else{
                    dp[i] = Math.min(dp[i], costs[2]);
                }
            }
            return dp[maxDays-1];
        }
    }


}
