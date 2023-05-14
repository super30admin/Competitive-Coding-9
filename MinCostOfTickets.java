/*
Time complexity - O(N), where N is the last day in the days array.
Space complexity - O(N)

Approach - 
    Construct an array of size of the value of the last day in the days array.
    Add all days in the days array to set. 
    Iterate from one to farthest day.
    At each step 
                if the day is not in the input array, simply copy the cost of prev day.
                otherwise, calculate the following
                        a. single day pass - cost of prev day + cost of single day pass.
                        b. weekly pass - cost of prev week + cost of weekly pass.
                                         if prev week doesnt exist -> cost of weekly pass alone.
                        c. monthly pass - equivalent of weekly pass.
                        find the min of a,b,c.
                store it in result array.
    return cost for the last day / farthest day.
*/
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        return dp_bottom_up(days, costs);
        //return mincostTickets(days, costs, 0);
    }

    private int dp_bottom_up(int[] days, int[] costs) {
        Set<Integer> set = new HashSet<>();
        int lastDay = days[days.length-1], dp[] = new int[lastDay+1];

        for (int day : days) set.add(day);

        for (int i = 1; i <= lastDay; i++)
            if (!set.contains(i))
                dp[i] = dp[i-1];
            else {
                dp[i] = dp[i - 1] + costs[0];

                int j = (i >= 7) ? i - 7 : 0;
                dp[i] = Math.min(dp[i], dp[j] + costs[1]);

                j = (i >= 30) ? i - 30 : 0;
                dp[i] = Math.min(dp[i], dp[j] + costs[2]);
            }
        return dp[lastDay];
    }

    /*private int mincostTickets(int[] days, int[] costs, int cost) {
        Queue<Pair<int, int>> last7, last30;
        for (int d : days) {
            while (!last7.empty() && last7.peek().getKey() + 7 <= d) 
                last7.pop();
            while (!last30.empty() && last30.peek().getKey() + 30 <= d) 
                last30.pop();
            last7.push(new Pair(d, cost + costs[1]));
            last30.push(new Pair(d, cost + costs[2]));
            cost = min({cost + costs[0], last7.peek().getValue(), last30.peek().getValue() });
        }
        return cost;
    }*/
}
