// TC : O(n)
// SC : O(n)

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || days.length == 0) return 0;
   
        int n = days.length;
        int[] dp = new int[n+1];
        
        dp[0] = 0;
        
        for(int i=1;i<=n;i++){
            
            int case1 = dp[i-1] + costs[0];
            
            int temp = i;
            while(temp>0 && days[i-1]-days[temp-1] < 7){
                temp--;
            }
            int case2 = dp[temp] + costs[1];
            
            temp = i;
            while(temp>0 && days[i-1]-days[temp-1] < 30){
                temp--;
                
            }
            int case3 = dp[temp] + costs[2];

            dp[i] = Math.min(case1,(Math.min(case2,case3)));

        }
        return dp[n];
    }
}