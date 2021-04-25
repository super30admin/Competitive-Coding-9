// Time Complexity :O(n) where n is the largest number in the days array
// Space Complexity :O(n + m) where n is the largest number in the days array for the dp array and m is of the size of days array
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
      
       
      
      Set<Integer> set = new HashSet<>();
      int max = Integer.MIN_VALUE;
      for (int e: days) 
      {
        set.add(e);
        max = Math.max(max,e);
      }
      
      int[] dp = new int[max+1];
     
      
      
      
      for(int i=1;i<dp.length;i++)
      {
        if(!set.contains(i))
        {
          dp[i] = dp[i-1];
          continue;
        }
        dp[i] = Math.min(dp[i-1]+costs[0],Math.min(dp[Math.max(0,i-7)]+costs[1],dp[Math.max(0,i-30)]+costs[2]));
      }
        return dp[dp.length-1];
    }
}