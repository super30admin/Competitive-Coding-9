//TimeComplexity: O(n)
//SpaceComplexity:O(n)

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int []dp = new int[days.length];
        return recursiveFunction(days, 0, costs,dp);
    }

    int recursiveFunction(int []days, int day, int []costs, int []dp) {

      //base
      if(day >= days.length) {
        return 0;
      }
      if(dp[day] != 0) {
        return dp[day];
      }

      //logic
      int onedayPass = recursiveFunction(days, day+1,costs,dp) + costs[0];
      int i;
      for(i = day; i<days.length && days[i] < days[day]+7 ;i++) {

      }
      int sevendaypass = recursiveFunction(days,i,costs,dp) + costs[1];

      for(i = day; i<days.length && days[i] < days[day]+30;i++) {

      }
      int thirtydaypass = recursiveFunction(days,i,costs,dp) + costs[2];

      int result = Math.min(Math.min(onedayPass,sevendaypass), thirtydaypass);
      dp[day] = result;
    return result;
    }
}