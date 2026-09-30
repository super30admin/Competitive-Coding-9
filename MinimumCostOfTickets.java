//Time Complexity: O(n)
//Space Complexity: O(n)
class Solution {

    public int mincostTickets(int[] days, int[] costs) {

        int last = days[days.length-1];
        int dp[] = new int[last + 1];

        int i = 0; //days pointer

        for(int j = 1; j <= last; j++) //Iterating all days from 1 to last day
        {
            if (j < days[i])
            {
                dp[j] = dp[j-1];
            }
            else
            {
                //Travelling day - increment my days pointer and fill the dp
                i++;
                int dayPass = dp[j-1] + costs[0];
                int weekPass = dp[Math.max(j-7, 0)] + costs[1];
                int monthPass = dp[Math.max(j-30, 0)] + costs[2];

                dp[j] = Math.min(dayPass, Math.min(weekPass,monthPass));
            }
        }
        return dp[last];
    }
}