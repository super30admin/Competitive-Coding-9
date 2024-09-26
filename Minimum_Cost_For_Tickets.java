/************************************************Bottom up DP Approach**********************************/
//Time Complexity : O(n), max number of days
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

import java.util.*;
class Minimum_Cost_For_Tickets_DP {
	public int mincostTickets(int[] days, int[] costs) {
		if(days == null || days.length == 0)
			return 0;

		Set<Integer> set = new HashSet<>();
		for(int i=0; i<days.length; i++)
			set.add(days[i]);

		int[] dp = new int[days[days.length -1] +1];

		for(int i=1; i<dp.length; i++){
			if(!set.contains(i))
				dp[i] = dp[i-1];

			else{
				int oneDayPass = dp[i-1] + costs[0];
				int sevenDayPass = dp[Math.max(i-7, 0)] + costs[1];
				int thirtyDayPass = dp[Math.max(i-30, 0)] + costs[2];
				dp[i] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
			}
		}
		return dp[dp.length -1];
	}
}

/************************************************Recursive Approach**********************************/
// Time Complexity :O(3^n), ////not really sure
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Time Limit Exceeded
// Any problem you faced while coding this : No	

class Minimum_Cost_For_Tickets_Recursive {
	public int mincostTickets(int[] days, int[] costs) {
		return helper(days, costs, 0);
	}
	private int helper(int[] days, int[] costs, int d){
		//base case
		if(d >= days.length)
			return 0;

		int oneDayPass = helper(days, costs, d+1) + costs[0];

		int i=0;
		for(i=d; i<days.length; i++){
			if(days[i] >= days[d] + 7)
				break;
		}
		int sevenDayPass = helper(days, costs, i) + costs[1];

		for(i=d; i<days.length; i++){
			if(days[i] >= days[d] + 30)
				break;
		}
		int thirtyDayPass = helper(days, costs, i) + costs[2];

		return Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
	}
}

/************************************************Top Down DP Approach**********************************/
//Time Complexity :O(n), max number of days
//Space Complexity : O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No	

class Minimum_Cost_For_Tickets_DP_Top_Down {
	Integer[] dp;
	public int mincostTickets(int[] days, int[] costs) {
		dp = new Integer[days.length];
		return helper(days, costs, 0);
	}
	private int helper(int[] days, int[] costs, int d){
		//base case
		if(d >= days.length)
			return 0;

		if(dp[d] != null)
			return dp[d];

		int oneDayPass = helper(days, costs, d+1) + costs[0];

		int i=0;
		for(i=d; i<days.length; i++){
			if(days[i] >= days[d] + 7)
				break;
		}
		int sevenDayPass = helper(days, costs, i) + costs[1];

		for(i=d; i<days.length; i++){
			if(days[i] >= days[d] + 30)
				break;
		}
		int thirtyDayPass = helper(days, costs, i) + costs[2];

		return dp[d] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
	}
}