class Solution {
    int[] dp = new int[366];
    HashSet<Integer> set;
    public int mincostTickets(int[] days, int[] costs) {
        set = new HashSet<>();
        for(int day : days){
            set.add(day);
        }
        Arrays.fill(dp, -1);
        return helper(1, costs);
    }
    private int helper(int day, int[] costs){
        // base case
        if(day > 365) return 0;
        if(dp[day] != -1) return dp[day];
        //logic 
        int ans = 0;
        if(set.contains(day)){
            ans =  Math.min(helper(day + 1, costs) + costs[0], Math.min(helper(day + 7, costs) + costs[1],helper(day + 30, costs) + costs[2]));
        }else{
            ans = helper(day+1, costs);
        }

        dp[day] = ans;
        return ans;
    }
}
