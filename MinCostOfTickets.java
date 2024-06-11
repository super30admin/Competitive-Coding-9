// Time Complexity : O(N) - N is the size of dp array
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        int[] dp = new int[days[days.length-1]+1];

        HashSet<Integer> set = new HashSet<>();
        for(int day : days) {
            set.add(day);
        }

        for(int i=1;i< dp.length;i++) {
            if(!set.contains(i)) {
                dp[i] = dp[i-1];
            }else{
                int oneDayPass = dp[i-1] + costs[0];

                int sevenDayPass = costs[1];
                if(i >= 7) {
                    sevenDayPass = dp[i-7] + costs[1];
                }

                int thirtyDayPass = costs[2];
                if(i >= 30) {
                    thirtyDayPass = dp[i-30] + costs[2];
                }

                dp[i] = Math.min(oneDayPass, Math.min(sevenDayPass,thirtyDayPass));
            }
        }

        return dp[dp.length -1];
    }
}