//Time Complexity: O(M) max values in days array
//Space Complexity: O(M)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int max = days[days.length-1];
        int[] dp = new int[max+1];
        int j=0;
        for(int i = 1; i < dp.length; i++) {
            if(j==days.length){
                break;
            }

            if(days[j] != i){
                dp[i] = dp[i-1];
            } else {

                int one = dp[i-1] + costs[0];

                int seven = dp[Math.max(i - 7,0)] + costs[1];

                int thirty = dp[Math.max(i - 30,0)] + costs[2];

                dp[i] = Math.min(one, Math.min(seven, thirty));
                j++;
            }
        }
        return dp[days[days.length-1]];
    }
}