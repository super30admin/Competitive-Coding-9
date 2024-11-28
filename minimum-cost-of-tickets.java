//Time complexity: O(W), where W is the max day in the travel plan
//Space complexity: O(W)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        //add the days in the set
        //as we can search using O(1) time from set
        for(int day: days) {
            set.add(day);
        }
        //max would be the last day of travel
        int max = days[days.length - 1];
        int[] dp = new int[max + 1];
        for(int i = 1; i < dp.length; i++) {
            //cost at previous day
            int c1 = dp[i-1];
            //cost at current-7 day
            int c7 = (i-7) > 0 ? dp[i-7] : 0;
            //cost at current - 30 days
            int c30 = (i-30) > 0 ? dp[i-30] : 0;
            if(set.contains(i)) {
                dp[i] = Math.min(c1 + costs[0], Math.min(c7 + costs[1], c30 + costs[2]));
            }
            else {
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length - 1];
    }
}