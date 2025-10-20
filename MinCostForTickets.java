import java.util.Arrays;

/**
 * <h3>Approach:</h3>
 * <p>This solution uses a recursive approach with memoization (top-down dynamic programming):</p>
 * <ol>
 *   <li><strong>Recursive Structure:</strong> For each travel day, we have three choices:
 *       buy a 1-day, 7-day, or 30-day pass. We choose the option that minimizes total cost.</li>
 *   <li><strong>Memoization:</strong> We cache results to avoid recalculating the same subproblems,
 *       reducing time complexity from exponential to O(n²).</li>
 *   <li><strong>State Transition:</strong> When we buy a pass, we find the next day that pass doesn't cover
 *       and recursively solve the remaining subproblem.</li>
 * </ol>
 */

 //TC: O(n), SC: O(n)
public class MinCostForTickets {

    private int[] memo;

    public int mincostTickets(int[] days, int[] costs) {
        // Input validation
        if (days == null || days.length == 0) return 0;
        if (costs == null || costs.length < 3) return 0;
        
        this.memo = new int[days.length];
        Arrays.fill(memo, -1);

        return helper(days, costs, 0);
    }

    private int helper(int[] days, int[] costs, int index) {
        // Base case: no more days to travel
        if (index >= days.length) return 0;

        if (memo[index] != -1) return memo[index];

        int one = index;
        while (one < days.length && days[one] < days[index] + 1) one++;

        int cost1 = costs[0] + helper(days, costs, one);

        int seven = index;
        while (seven < days.length && days[seven] < days[index] + 7) seven++;
        int cost2 = costs[1] + helper(days, costs, seven);

        int thirty = index;
        while (thirty < days.length && days[thirty] < days[index] + 30) thirty++;
        int cost3 = costs[2] + helper(days, costs, thirty);

        this.memo[index] = Math.min(cost1, Math.min(cost2, cost3));
        return this.memo[index];
    }
}
