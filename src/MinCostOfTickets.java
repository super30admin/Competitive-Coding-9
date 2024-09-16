//time - O(n) , space O(n) , n= number of days
//https://leetcode.com/problems/minimum-cost-for-tickets/
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> daysSet = new HashSet<>();
        
        //create set for available days
        for(int day:days) {
          daysSet.add(day);  
        }
        
        int max = days[days.length-1];
        
        //make dp arrays with length of max days + 1
        int[] dp = new int[max+1];
        
        for(int i=1 ;i< max+1;i++) {
            //if day not present in given days, cost to reach that day
            //is same as of previous day
            if(!daysSet.contains(i)){
                dp[i] = dp[i-1];
            } else
            {
                //if day present in the days, it can be reached using 1, 7, 30 day pass
                // consider 7 day pass, so we reach this from (currentDay - 7)th day
                //if (current-7) is valid day then cost of that day + cost of 7 day pass
                // else use cost of 0th day, do this for all options (1,7,30) and take min
                dp[i] = Math.min(
                    dp[i-1] + costs[0], 
                    Math.min(    
                    dp[Math.max(i-7, 0)] + costs[1],
                    dp[Math.max(i-30, 0)] + costs[2]  
                    )
                );
            
            }
        }
        
        return dp[max];
    }
    
    
}