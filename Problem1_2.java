//Time Complexity: O(max(n)); where n is the length of days array.
//Space Complexity: O(max(n))
//Code run successfully on LeetCode.

public class Problem1_2 {

    public int mincostTickets(int[] days, int[] costs){
        
        HashSet<Integer> daySet = new HashSet<>();
        int max = days[days.length - 1];
        
        for(int i=0; i < days.length; i++)
            daySet.add(days[i]);
        
        int[] dp = new int[max + 1];
        dp[0] = 0;
        
        for(int i =1; i < dp.length; i++)
        {
            if(!daySet.contains(i))
            {
                dp[i] = dp[i-1];
                continue;
            }
            
            dp[i] = Math.min(
                dp[i-1] + costs[0],
                Math.min(dp[Math.max(0,i-7)] + costs[1],
                dp[Math.max(0,i-30)] + costs[2]));
        }
        return dp[dp.length-1];
    }
}
