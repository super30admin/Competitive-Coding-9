// Time complexity - O(n)
// Space complexity - O(n)

// Dp

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> set = new HashSet<>();
        for(int day : days){
            set.add(day);
        }
        int max = days[days.length - 1];
        int []dp = new int[max+1];
        for(int i = 1; i < dp.length; i++){
            if(!set.contains(i)){
                dp[i] = dp[i-1];
            }else{
              dp[i] = Math.min(
                  dp[i-1] + costs[0],
                  Math.min(
                  dp[Math.max(i-7, 0)]+ costs[1],
                       dp[Math.max(i-30, 0)]+ costs[2]
                  )
              );  
            }
        }
        return dp[dp.length - 1];
    }
}
