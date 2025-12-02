// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : We maintain a dp array that gives the minimum cost required for the value at that index. We perform bottom up dp here by setting the last index
// to 0 as there is 0 cost at that position. We calculate the 3 possibilities of buying 1 day, 7 day and 30 day passes and capture the pointers position in
// all three cases. Then we calculate the cost at these pointers by adding 1 day pointer with costs[0], 7 day pointer with costs[1] and 30 day pointer with costs[2].
// Finally, we consider the minimum of these and continue until we reach 0th index, 0th gives the minimum cost to cover all days.

class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        int n = days.length;
        int[] dp = new int[n+1]; //dp[n] = 0 base case
        for(int i = n-1;i >= 0;i--){
            int p1 = i;
            while(p1 < n && days[p1] < days[i] + 1){ //index after buying 1 day pass
                p1++;
            }
            int p7 = i;
            while(p7 < n && days[p7] < days[i] + 7){ //index after buying 3 day pass
                p7++;
            }
            int p30 = i;
            while(p30 < n && days[p30] < days[i] + 30){ //index after buying 7 day pass
                p30++;
            }
            dp[i] = Math.min(costs[0] + dp[p1] , Math.min(costs[1] + dp[p7], costs[2] + dp[p30])); //minimum cost of all three possibilities.
        }
        return dp[0]; //return 0th index as it's gives the minimum cost to travel
    }
}