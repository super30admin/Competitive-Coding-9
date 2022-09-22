//TC - O(n) n is the largest number of day
//SC - O(n)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days==null || days.length==0) return 0;
        
        int len = days.length;
        int [] dp = new int[days[len-1]+1];
        dp[0]=0;
        
        for(int i=0;i<len;i++){
            dp[days[i]]=-1;
        }
        
        for(int i=1;i<dp.length;i++){
            if(dp[i]==-1){
                int week=0;
                if(i<=7){
                    week = costs[1];
                }
                else{
                    week = costs[1]+dp[i-7];
                }
                int months=0;
                if(i<=30){
                    months = costs[2];
                }
                else{
                    months = costs[2]+dp[i-30];
                }
                dp[i] = Math.min(dp[i-1]+costs[0],Math.min(week,months));
            }
            else{
                dp[i] = dp[i-1];
            }

        }
        
        return dp[dp.length-1];
    }
}