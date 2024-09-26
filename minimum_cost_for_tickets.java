//Time Complexity: O(N)
//Space Complexity: O(N)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || costs == null)
            return 0;
        int lastday = days[days.length - 1];
        boolean[] daysarray= new boolean[days[days.length -1] + 1];
        int dp[] = new int[days[days.length - 1] + 1];
        for(int day: days){
            daysarray[day] = true;
        }
        
        for(int i = 1; i<=lastday ; i++){
            if(!daysarray[i]){
                dp[i] = dp[i - 1];
            }
            else{
                int one = dp[i - 1] + costs[0] ;
                int seven = dp[Math.max( i - 7, 0)] + costs [1];
                int thirty = dp[Math.max(i - 30, 0)] + costs[2];
                dp[i] = Math.min(one, Math.min(seven, thirty));
                
            }
        }
        
        return dp[lastday];       
    }
}