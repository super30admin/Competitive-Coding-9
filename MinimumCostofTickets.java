//Time - O(N)
//Space - O(N)
class Solution {
    Integer[] dp;
    Set<Integer> dayset;
    
    public int mincostTickets(int[] days, int[] costs) {
        dp = new Integer[366];
        dayset = new HashSet();
        for (int d: days) dayset.add(d);
        return dp(1,costs);
    }
    
    private int dp(int i, int[] costs){
        if(i>365) return 0;
        
        if(dp[i]!=null)
            return dp[i];
        
        if(dayset.contains(i)){
            
            int min = Math.min(dp(i+1,costs)+costs[0],dp(i+7,costs)+costs[1]);
            min = Math.min(min,dp(i+30,costs)+costs[2]);
            dp[i]=min;
        }
        else{
            dp[i] = dp(i+1,costs);
        }
        return dp[i];
    }
}
