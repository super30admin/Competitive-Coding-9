class Solution {
    // Time Complexity:O(n)
    // Space Complexity:O(1)
    public int mincostTickets(int[] days, int[] costs) {
        if (days.length ==0){
            return 0;
        }
        int[] dp = new int[365+1];

        //fill up the dp array 
        int pointer = 0; // pointer which tracks the days array
        for (int i =1; i <= dp.length;i++){
            if (pointer == days.length)
            return dp[i-1];
            if (days[pointer] != i)
                dp[i] = dp[i-1];
            else {
                int prevCost = dp[i-1];
                int sdayBeforeCost = i - 7 < 0 ? 0 : dp[i-7];
                int tdayBeforeCost = i - 30 < 0 ? 0 : dp[i-30];
                dp[i] = Math.min (prevCost + costs[0], Math.min (sdayBeforeCost + costs[1],tdayBeforeCost + costs[2]));
                pointer++;
            }
        }
    return dp [ 364];
    }
}
