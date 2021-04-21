// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
      
       
      
      Set<Integer> set = new HashSet<>();
      for (int e: days) 
      {
        set.add(e);
      }
      
      int n = days[days.length-1];
      int[] dp = new int[n+1];
     
      for(int i=1;i<dp.length;i++)
      {
        if(set.contains(i))
        {
          
           int x = dp[Math.max(0,i-1)]+costs[0];
        
           int y = dp[Math.max(0,i-7)]+costs[1];
        
          int z = dp[Math.max(0,i-30)]+costs[2];
        dp[i] = Math.min(x,Math.min(y,z));
        }
        else
        {
          dp[i] = dp[i-1];
        }
      }
        return dp[dp.length-1];
    }
}