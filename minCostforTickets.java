import java.util.HashSet;

public class minCostforTickets {

	public int minCostTickets(int[] days, int[] costs) {
		
		HashSet<Integer> set = new HashSet<>();
		for(int day: days)
			set.add(day);  // Store the values in hashSet so that we can check if the days are already present in set and calculate
		// the costs required for that day
		
		int max = days[days.length-1];  // retrieve the max value in array which will be dp size
		int[] dp = new int[max+1];
		
		// iterate over all the days till max day value and calculate the min costs required
		for(int i=1;i<= max;i++) {
			if(set.contains(i)) { // check if the index or value i which is present as day in days array
				
				int c1 = dp[Math.max(i-1, 0)] + costs[0];  // if the day index os present, calculate the costs required at that particular day
				// we calculate the costs for days considering 1day pass, 7day and 30 day pass
				// we subtract the present day which is ith index with that particular day pass so that we go back 7 days behind and check for the cost
				int c2 = dp[Math.max(i-7, 0)] + costs[1];
				int c3 = dp[Math.max(i-30, 0)] + costs[2];
				// take the minimum required for that day considering all the day passes, 1, 7 and 30 days and store it is our dp array
				dp[i] = Math.min(Math.min(c1, c2), c3);
			}else {
				// if the day or index is not present in set, we store the previous value of dp because we do not have to buy 
				// day pass on that day
				dp[i] = dp[i-1];
			}
		}
		return dp[max];
	}
}
