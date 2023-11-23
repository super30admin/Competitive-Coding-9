// Time Complexity:  O(n)
// Space Complexity: O(m)
//
// where n is length of array days, m is maximum number in array days

class Solution {
    
    public int mincostTickets(int[] days, int[] costs) {
        
        int max = days[days.length-1];
        Set<Integer> daySet = new HashSet<>();
        int[] dp = new int[max+1];
        dp[0] = 0;

        for(int day : days)
            daySet.add(day);
        
        for(int i=1; i<dp.length; i++) {
            if(!daySet.contains(i)) 
                dp[i] = dp[i-1];
            else
                dp[i] = Math.min(
                    dp[i-1]+costs[0],
                    Math.min(
                        dp[Math.max(0, i-7)]+costs[1],
                        dp[Math.max(0, i-30)]+costs[2]
                    )
                );
        }

        return dp[max];

    }

}
