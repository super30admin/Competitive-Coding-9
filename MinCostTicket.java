// Time Complexity : O(N)// N is the max day
// Space Complexity : O(N) //dp array size
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * 1. dp problem.
 * 2. at each travel day get min of day,week and month ticket cost
 */
public class MinCostTicket {
	public int mincostTickets(int[] days, int[] costs) {
		int maxDay=days[days.length-1];
		int[] dp=new int[maxDay+1];
		dp[0]=0;
		
		int counter=0;
		for(int i=1;i<=maxDay;i++) {
			if(days[counter]==i) {
				/*int daycost= dp[i-1]+costs[0];
				int weekCost=dp[Math.max(0, i-7)]+costs[1];
				int monthCost=dp[Math.max(0, i-30)]+costs[2];*/
				
				dp[i]=Math.min(Math.min(dp[i-1]+costs[0], dp[Math.max(0, i-7)]+costs[1]),dp[Math.max(0, i-30)]+costs[2]);
				counter++;
			}else {
				dp[i]=dp[i-1];
			}
		}
		
		return dp[maxDay];
	}
	public static void main(String[] args) {
		int[] days=new int[] {1,4,6,7,8,20};
		int[] costs= new int[] {2,7,15};
		System.out.println(new MinCostTicket().mincostTickets(days, costs));
	}
}
