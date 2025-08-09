//time complexity - O(n)
//space complexity - O(n)
public class MinimumCostForTickets {
    static int mincostTickets(int[] days, int[] costs) {
        int n =  days.length;
        int[] dp = new int[n];
        dp[0]= Math.min(costs[0], Math.min(costs[1], costs[2]));

        for(int i = 1; i < n; i++) {
            dp[i] = dp[i-1] + costs[0];
            int d = i-1;
            while(d >= 0 && days[i] - days[d] < 7) {
                d--;
            }
            if (d < 0) {
                dp[i] = Math.min(dp[i], costs[1]);
            } else {
                dp[i] = Math.min(dp[i], dp[d] + costs[1]);
            }

            d = i-1;
            while(d >= 0 && days[i] - days[d] < 30) {
                d--;
            }
            if (d < 0) {
                dp[i] = Math.min(dp[i], costs[2]);
            } else {
                dp[i] = Math.min(dp[i], dp[d] + costs[2]);
            }

        }
        return dp[n-1];
    }

    public static void main(String[] args) {
        int[] days = {1,4,6,7,8,20};
        int[] cost = {2,7,15};

        System.out.println("Minimum money: " + mincostTickets(days, cost));
    }
}
