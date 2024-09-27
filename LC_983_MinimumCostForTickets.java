// Time Complexity :O(days[days.length-1]+1)
// Space Complexity :O(days[days.length-1]+1)
// Did this code successfully run on Leetcode :Yes
//Runtime: 1 ms, faster than 93.04% of Java online submissions for Minimum Cost For Tickets.
//Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Minimum Cost For Tickets.
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days[days.length-1]+1;
        boolean[] isTravel= new boolean[n];
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0]=0;
            
        for(int day: days){
            isTravel[day] = true;
        }
        
        for(int i=1; i< n; i++ ){
            if(!isTravel[i]){
                dp[i]=dp[i-1];
                continue;
            }
            dp[i] = Math.min(dp[i], dp[i-1]+ costs[0]);
            if(i-7>=0){
                dp[i]= Math.min(dp[i], dp[i-7]+ costs[1]);
            }else{
                dp[i]= Math.min(dp[i], costs[1]);
            }
            if(i-30 >= 0){
                dp[i]= Math.min(dp[i], dp[i-30]+costs[2]);
            }else{
                dp[i]= Math.min(dp[i], costs[2]);
            }
        }
        return dp[n-1];
        
    }
}