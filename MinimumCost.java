class MinimumCost {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length -1];
        boolean[] travelDays = new boolean[lastDay+1];

        for(int day: days)
            travelDays[day] = true;
        
        int[] dp = new int[lastDay+1];

        for(int i=1; i<=lastDay; i++){
                if(!travelDays[i]){
                    dp[i] = dp[i-1];
                    continue;
                }
            // Calculate cost if we buy a 1-day ticket today
            int oneDay = dp[i - 1] + costs[0];

            // Calculate cost if we buy a 7-day ticket covering today
            int sevenDays = dp[Math.max(0, i - 7)] + costs[1];

            // Calculate cost if we buy a 30-day ticket covering today
            int thirtyDays = dp[Math.max(0, i - 30)] + costs[2];

            // Store the minimum cost of these three options
            dp[i] = Math.min(oneDay, Math.min(sevenDays, thirtyDays));
        }
        return dp[lastDay];
    }
}