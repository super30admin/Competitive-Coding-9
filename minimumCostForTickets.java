// Time complexity = O(n), n - max day of travel
// Space complexity = O(n)

class Solution {
  public int mincostTickets(int[] days, int[] costs) {
    int n = days.length;
    int lastDay = days[n-1];
    int[] dp = new int[lastDay + 1];
    boolean[] visited = new boolean[lastDay+1];

    for(int day: days) {
      visited[day] = true;
    }

    for(int i = 1; i<lastDay+1; i++) {
      if(!visited[i]) {
        dp[i] = dp[i-1];
        continue;
      }
      // 1 day pass
      dp[i] = dp[i-1] + costs[0];
      // 7 day pass
      dp[i] = Math.min(dp[i], dp[Math.max(0,i-7)]+costs[1]);
      // 30 day pass
      dp[i] = Math.min(dp[i], dp[Math.max(0,i-30)]+costs[2]);
    }
    return dp[lastDay];
  }
}

