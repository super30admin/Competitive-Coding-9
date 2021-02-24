class Solution {
    int[] days;
    int[] costs;
    Integer[] memo;
    Set<Integer> dayset;

    public int mincostTickets(int[] days, int[] costs) {
        this.days = days;
        this.costs = costs;
        memo = new Integer[days[days.length-1]+1];
        dayset = new HashSet();
        for (int d: days) dayset.add(d);

        return dp(days[days.length-1]);
    }

    public int dp(int i) {
        if (i<0)
            return 0;
        if (memo[i] != null)
            return memo[i];

        int ans;
        if (dayset.contains(i)) {
            ans = Math.min(dp(i-1) + costs[0],
                               dp(i-7) + costs[1]);
            ans = Math.min(ans, dp(i-30) + costs[2]);
        } else {
            ans = dp(i-1);
        }

        memo[i] = ans;
        return ans;
    }
}

//Time complexity : O(N) where N is the max number of a day(last value) in days array
//Space complexity : O(N)
