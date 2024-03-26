

import java.util.Arrays;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int [] dp = new int [366];
		Arrays.fill(dp, -1);
        return helperMemo(days.length, days, costs, 0, dp);
    }


    //Tc: O(n)
    //Sc: O(1)
    private int  helperMemo(int n, int[] days, int []cost, int idx, int [] dp) {

		//base
		if(idx >= n) {
			return 0;
		}

		if(dp[idx] != -1) {
			return dp[idx];
		}

		//logic

		//1 day pass
		int cost1 = cost[0] + helperMemo(n, days, cost, idx + 1, dp);

		//7 day pass
		int i = idx;
		int end7DayPass = days[idx] + 6;
		while(i < n && days[i] <= end7DayPass) {
			i++;
		}
		int cost7 = cost[1] + helperMemo(n, days, cost, i, dp);


        // 30 day pass
		i = idx;
		int end30DayPass = days[idx] + 29;

		while(i < n && days[i] <=end30DayPass ) {
			i++;
		}

		int cost30 = cost[2] + helperMemo(n, days, cost, i, dp);

		dp[idx] =  Math.min(cost1, Math.min(cost7, cost30));

		return dp[idx];
	}
}