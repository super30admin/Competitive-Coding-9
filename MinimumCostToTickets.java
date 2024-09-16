//Approach - Dynamic programming
//Time Complexity - O(365) - worst case it could be for 365 days
//Space Complexity - O(365) - worst case it could be for 365 days

class Solution {
  int[] memo;
  Set<Integer> daySet;

  public int mincostTickets(int[] days, int[] costs) {
    memo = new int[days[days.length-1]];
    daySet = new HashSet<>();

    for(Integer day: days){
      daySet.add(day);
    }

    return dp(days[days.length-1], costs);
  }

  public int dp(int i, int[] costs){

    if(i <= 0){
      return 0;
    }

    if(memo[i-1] != 0){
      return memo[i-1];
    }

    int ans;

    if(daySet.contains(i)){
      int oneDayPass = dp(i-1, costs)+costs[0];
      int sevenDayPass = dp(i-7, costs)+costs[1];
      int thirtyDayPass = dp(i-30, costs)+costs[2];

      ans = Math.min(Math.min(oneDayPass, sevenDayPass), thirtyDayPass);
    }
    else{
      ans = dp(i-1, costs)+0;
    }

    memo[i-1] = ans;
    return ans;
  }
}
