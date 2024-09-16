/*

Did it run on leetcode: Yes
Time Complexity: 0(N)
Space Complexity: 0(N)

Algorithm:
- At each point of day, our decsion has to be based on three choices
one day cost, seven day cost and one month trip cost

*/


class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int lastDayOfTravel = days[days.length-1];
        int[] dp = new int[lastDayOfTravel+1];
        
        boolean[] daysToTravel = new boolean[lastDayOfTravel+1];
        for(int i=0;i<days.length;++i){
            daysToTravel[days[i]] = true;
        }
        
        for(int i=1;i<=lastDayOfTravel;++i){
            
            if(!daysToTravel[i]){
                dp[i]=dp[i-1];
                
            }else{
                int choiceOne = dp[i-1]+costs[0];
            int choiceTwo = i-7>0?(dp[i-7]+costs[1]):dp[0]+costs[1];
            int choiceThree = i-30>0?(dp[i-30]+costs[2]):dp[0]+costs[2];
            int min = Math.min(choiceOne,Math.min(choiceTwo,choiceThree));
            dp[i] = min;
            
            System.out.println(min);
            }
        }
        
        return dp[lastDayOfTravel];
    }
}