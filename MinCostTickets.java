// Time Complexity :  O(N)
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i : days) {
            set.add(i);
        }
        
        int[] dp = new int[lastDay + 1];
        
        for (int i = 1; i < lastDay + 1; i++) {
            if (set.contains(i))
                dp[i] =  Math.min(Math.min((dp[i - 1] + costs[0]),
                                 (dp[Math.max(0, i - 7)] + costs[1])),
                                  dp[Math.max(0, i - 30)] + costs[2]);
            else
                dp[i] = dp[i-1];
        }
        
        return dp[lastDay];
    }
}
//Memoization
// class Solution {
//     int[] memo;
//     public int mincostTickets(int[] days, int[] costs) {
//         memo = new int[days.length + 1];
//         return helper(days, costs, 0);
//     }
//     private int helper(int[] days, int[] cost, int index){
//         if(index >= days.length){return 0;}
//         if(memo[index]!= 0) return memo[index];
//         //logic
//         //1 day logic
//         int oneDay = memo[index] == 0 ? helper(days, cost, index + 1) + cost[0] : memo[index] + cost[0];
//         int i;
//         for(i = index; i < days.length; i++){
//             if(days[i] >= days[index] + 7)
//                 break;
//         }
//         int sevenDay = memo[i] == 0 ? helper(days, cost, i) + cost[1] : memo[i] + cost[1];
//         int j;
//         for(j = index; j < days.length; j++){
//             if(days[j] >= days[index] + 30)
//                 break;
//         }
//         int thirtyDay = memo[j] == 0 ? helper(days, cost, j) + cost[2] : memo[j] + cost[2];
        
        
//         return memo[index] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
//     }
// }
//recursion

// class Solution {
//     int[] memo;
//     public int mincostTickets(int[] days, int[] costs) {
//         memo = new int[days.length + 1];
//         return helper(days, costs, 0);
//     }
//     private int helper(int[] days, int[] cost, int index){
//         if(index >= days.length){return 0;}
        
//         //logic
//         //1 day logic
//         int oneDay = memo[index] == 0 ? helper(days, cost, index + 1) + cost[0] : memo[index] + cost[0];
//         int i;
//         for(i = index; i < days.length; i++){
//             if(days[i] >= days[index] + 7)
//                 break;
//         }
//         int sevenDay = memo[i] == 0 ? helper(days, cost, i) + cost[1] : memo[i] + cost[1];
//         int j;
//         for(j = index; j < days.length; j++){
//             if(days[j] >= days[index] + 30)
//                 break;
//         }
//         int thirtyDay = memo[j] == 0 ? helper(days, cost, j) + cost[2] : memo[j] + cost[2];
        
        
//         return Math.min(oneDay, Math.min(sevenDay, thirtyDay));
//     }
// }