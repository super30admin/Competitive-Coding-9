//Time complexity : O(n) 
//space complexity: O(m) m is max days 


public class MinCostTicket {
    public int mincostTickets(int[] days, int[] costs) {
        int lastday = days[days.length-1];
        int []dp = new int [lastday+1];
        Set<Integer> s = new HashSet<>();
        for (int day : days){
            s.add(day);
        }
        
        for (int i = 1 ; i< dp.length; i++){
            if(s.contains(i)){
                int c1 = dp[i-1] + costs[0];
                int c2 = (i - 7 > 0 ? dp[i-7] : 0) + costs[1];
                int c3 = (i-30 > 0 ? dp[i-30]:0) + costs[2];
                
                dp[i] = Math.min(c1, Math.min (c2,c3));
                
            }else{
                //not active
                dp[i] = dp[i-1];
            }
            
        }
        
        return dp[dp.length-1];
    }
}
