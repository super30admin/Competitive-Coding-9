// Time Complexity :O(max days)
// Space Complexity :O(max days)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days.length==0 || days==null)
            return 0;
        int[] dp = new int[days[days.length-1]+1];//dp array till 1 + last entry in days 
        dp[0]=0;
        
        int index=1,i=0;
        while(index<=days[days.length-1]){//calculate min cost for each day
            if(index==days[i]){
                dp[index]= dp[index-1]+costs[0];
                if(index>=7)
                    dp[index]=Math.min(dp[index],dp[index-7]+costs[1]);
                else
                    dp[index]=Math.min(dp[index],dp[0]+costs[1]);
                if(index>=30)
                    dp[index]=Math.min(dp[index],dp[index-30]+costs[2]);
                else
                    dp[index]=Math.min(dp[index],dp[0]+costs[2]);
                
                i++;
            }
            else{
                dp[index]=dp[index-1];
            }
            index++;
        }
        return dp[days[days.length-1]]; 
    }
}