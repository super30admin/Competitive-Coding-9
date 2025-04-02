//The approach here is to either choose or not choose the 3 different passes for each index and check all possibilities using recursion and find minimum among them.
//Here, we memoized that recursive approach by storing the results that we get at each index in memo array.
//To traverse to the next index, we need to find the index where we should choose the next option. For that, we traverse till that index.
//At each case, we add the current cost for the path chosen and check the minimum of the rest of the array
//Time Complexity: O(n) where n is the length of the the days array
//Space complexity: O(n)
import java.util.Arrays;

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days.length == 0 || costs.length == 0) return 0;
        int[] memo = new int[days.length];
        Arrays.fill(memo, -1);
        return helper(days, costs, 0, memo);

    }

    private int helper(int[] days, int[] cost, int idx, int[] memo){
        //base
        if(idx >= days.length) return 0;
        if(memo[idx] != -1) return memo[idx];
        //logic
        int case1 = cost[0] + helper(days, cost, idx+1,memo);
        int k = 0;
        while(k < days.length && days[k] < days[idx] + 7){
            k++;
        }
        int case2 = cost[1] + helper(days, cost, k, memo);
        int j = 0;
        while(j < days.length && days[j] < days[idx] + 30){
            j++;
        }

        int case3 = cost[2] + helper(days, cost, j, memo);

        memo[idx] = Math.min(case1, Math.min(case2, case3));

        return Math.min(case1, Math.min(case2, case3));
    }
}
