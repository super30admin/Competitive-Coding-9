// Time Complexity: O(N) where N is the number of days in the days array
// Space Complexity: O(N) where N is the number of days in the days array

class MinCostOfTickets {
    public int mincostTicketsMemoization(int[] days, int[] costs) {
        if(days.length == 0 || costs.length == 0){
            return 0;
        }

        Integer[] memo = new Integer[days.length];

        return helper(days, costs, 0, memo);
    }

    private int helperMemoization(int[] days, int[] costs, int index, Integer[] memo){
        //base case
        if(index >= days.length){
            return 0;
        }

        if(memo[index] != null){
            return memo[index];
        }

        int cost1 = costs[0] + helper(days, costs, index+1, memo);

        int temp = index;

        while(temp < days.length && days[temp] < days[index]+7){
            temp++;
        }
        int cost2 = costs[1] + helper(days, costs, temp, memo);

        int temp2 = temp;

        while(temp2 < days.length && days[temp2] < days[index]+30){
            temp2++;
        }

        int cost3 = costs[2] + helper(days, costs, temp2, memo);

        int min1 = Math.min(cost1, cost2);

        memo[index] = Math.min(min1, cost3);
        return memo[index];
    }

    // Dynamic Programming
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length-1];

        boolean[] travelDays = new boolean[lastDay+1];

        for(int day: days){
            travelDays[day] = true;
        }

        int[] dp = new int[lastDay+1];

        Arrays.fill(dp, 0);


        for(int i = 1; i <= lastDay; i++){
            if(!travelDays[i]){
                dp[i] = dp[i-1];
                continue;
            }

            int cost1 = costs[0] + dp[i-1];
            int cost2 = costs[1] + dp[Math.max(0, i-7)];
            int cost3 = costs[2] + dp[Math.max(0, i-30)];

            dp[i] = Math.min(cost1, Math.min(cost2, cost3));
        }

        return dp[lastDay];
    }
}
