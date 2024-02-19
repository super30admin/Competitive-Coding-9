// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {

    private int[] costNDaysAgo(int[] days, int startIdx, int[] dp){
        int[] result = new int[3];
        int curr = days[startIdx];
        boolean[] lookingFor = new boolean[]{true, true, true};

        for(int j = startIdx-1; j > -1; j--){
            int elem = days[j];
            // Looking for 1 day before
            if(lookingFor[0] && curr-elem >= 1){
                result[0] = dp[j];
                lookingFor[0] = false;
            }
            if(lookingFor[1] && curr-elem >= 7){
                result[1] = dp[j];
                lookingFor[1] = false;
            }
            if(lookingFor[2] && curr-elem >= 30){
                result[2] = dp[j];
                break;
            }
        }

        return result;

    }

    public int mincostTickets(int[] days, int[] costs) {

        // base case
        if(days.length == 0) return 0;

        int[] dp = new int[days.length];
 
        // iterating through days
        for(int i = 0; i < days.length; i++){
            int day = days[i];
            int[] prevCosts = costNDaysAgo(days, i, dp);
            int cost1 = costs[0] + prevCosts[0];
            int cost7 = costs[1] + prevCosts[1];
            int cost30 = costs[2] + prevCosts[2];
            dp[i] = Math.min(cost1, Math.min(cost7, cost30));
        }

        // print dp array
        for(int num : dp) System.out.print(num + ", ");
        return dp[days.length-1];

        
    }
}
