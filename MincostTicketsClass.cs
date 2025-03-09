// TC => O(days)
// SC => O(days)


public class Solution {
    public int MincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.Length - 1];
        int[] dp = new int[lastDay + 1];

        int i = 0;
        for(int day = 1; day <= lastDay; day++){
            if(day< days[i]){
                dp[day] = dp[day - 1];
            }
            else{
                i++;
                dp[day] = Math.Min(dp[day - 1] + costs[0], Math.Min(dp[Math.Max(0, day - 7)] + costs[1], dp[Math.Max(0, day -30)] + costs[2]));
            }
        }
        return dp[lastDay];
    }
}