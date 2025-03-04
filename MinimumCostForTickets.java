//TC: O(l) where l is last day number visited
//SC: O(l)
//approach: DP

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days[days.length-1]+1];
        boolean[] visited = new boolean[days[days.length-1]+1];
        for(int day:days){
            visited[day] = true;
        }

        for(int i = 1;i<=days[days.length-1];i++){
            if(visited[i] == false){
                dp[i] = dp[i-1];
                continue;
            }

            dp[i] = dp[i-1] + costs[0];
            dp[i] = Math.min(dp[i], dp[Math.max(0,i-7)]+costs[1]);
            dp[i] = Math.min(dp[i], dp[Math.max(0,i-30)]+costs[2]);
        }
        return dp[dp.length-1];

    }
}
