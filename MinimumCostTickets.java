import java.util.HashSet;
import java.util.Set;

public class MinimumCostTickets {

    /*
    Time Complexity : O(N) -  N number of days
    Space Complexity : O(N)
    Approach : We expand the days  from 1 to max travel day+1. At each day we count the minimum of adding today's pass + cost of
    i-1 (previous day), i-7th day(in last week), i-30(in last month). For non traveling days, I can check the set, if the day is not there I can
    take the min value from the previous day.
*/
    public int mincostTickets(int[] days, int[] costs) {
        int len = days[days.length - 1];
        int[] dp = new int[len + 1];
        Set<Integer> set = new HashSet<>();
        for (int day : days) {
            set.add(day);
        }

        for (int i = 1; i <= len; i++) {
            if (!set.contains(i)) {
                dp[i] = dp[i - 1];
                continue;
            }
            dp[i] = Math.min(costs[0] + dp[i - 1],
                    Math.min(costs[1] + dp[Math.max(0, i - 7)],
                            costs[2] + dp[Math.max(0, i - 30)]));

        }

        return dp[len];
    }

    /*
        Time Complexity : O(3^N) -  N number of days
        Space Complexity : O(N)
        Approach : Recursive
        We need to find minimum cost on day d if we choose any of three passes. We will find the minimum cost at day i and make the recursion
        call to next i+7 index and i+30 index. We can linearly find the next index, or we can do binary search to find the next index.
    */
    int minCost(int index, int[] days, int[] costs) {
        if (index >= days.length)
            return 0;

        int cost1 = costs[0] + minCost(index + 1, days, costs);

        int nextIndex = binarySearch(days[index] + 7, days);
        int cost7 = costs[1] + minCost(nextIndex, days, costs);

        nextIndex = binarySearch(days[index] + 30, days);
        int cost30 = costs[2] + minCost(nextIndex, days, costs);
        return Math.min(cost1, Math.min(cost7, cost30));
    }

    int binarySearch(int target, int[] days) {
        int start = 0;
        int end = days.length - 1;
        int ans = days.length;

        while (start <= end) {
            int mid = (end + start) / 2;
            if (days[mid] >= target) {
                ans = mid; // possible answer
                end = mid - 1; // go LEFT
            } else {
                start = mid + 1; // go RIGHT
            }
        }

        return ans;
    }

}

