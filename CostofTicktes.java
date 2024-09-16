class CostOfTickets {

    /**
     * Time complexity: O(N) where N is maximum day in days array
     * Space complexity: O(N) where N is maximum day in days array
     * 
     * Approach:
     * 1. Compare the minimum cost of tickets from the earlier days, (a day before, a week before and a month before).
     * 2. Find the minimum cost and return it.
     * 3. Maintain a dp array to calculate the minimum cosr progressively. (bottom up approch)
      */

    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || days.length == 0)
            return 0;
        Set<Integer> set = new HashSet<>();
        for(int i: days) {
            set.add(i);
        }
        int n = days.length;
        int[] dp = new int[days[n-1]+1];
        
        for(int i=1; i<dp.length; i++) {
            if(!set.contains(i)){
                dp[i] = dp[i-1];
            }
            else{
                int dayFare = dp[i-1]+costs[0];
                int weekFare = dp[Math.max(i-7, 0)] + costs[1];
                int monthFare = dp[Math.max(i-30, 0)] + costs[2];
                dp[i] = Math.min(Math.min(dayFare, weekFare), monthFare);
            }
        }
        
        return dp[dp.length-1];
    }
}