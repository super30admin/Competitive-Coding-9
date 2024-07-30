//TC - O(N)
//SC  - O(N) 
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || days.length == 0 || costs == null || costs.length == 0){
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        int n = days.length;
        for(int day : days){
            set.add(day);
        }
        int[] dp = new int[days[n - 1] + 1];
        dp[0] = 0;
        int cost = 0;
        for(int i = 1; i < dp.length; i++){
            if(set.contains(i)){
                int oneDay = dp[i - 1] + costs[0];
                int sevenDay = (i >= 7) ? dp[i - 7] + costs[1] : costs[1];
                int thirtyDay = (i >= 30) ? dp[i - 30] + costs[2] : costs[2];
                cost = Math.min(oneDay, Math.min(sevenDay,thirtyDay));
                dp[i] = cost;
            }
            else{
                dp[i] = cost;
            }

        }
        return dp[dp.length - 1];
    }
}
