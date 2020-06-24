//minimum cost ticket
//time o(n), n- max day
//space o(n)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastday = days[days.length-1];
        int[] dp = new int[lastday+1];
        List<Integer> list = new ArrayList<>();
        for(int day: days) {
            list.add(day);
        }
        
        for(int i=1;i<dp.length; i++) {
            if(list.contains(i)) {
                dp[i] = Math.min(dp[i-1]+costs[0], Math.min(costs[1]+dp[Math.max(0,i-7)]
                             ,costs[2]+dp[Math.max(0,i-30)]));
            }
            else {
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}