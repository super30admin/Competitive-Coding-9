class Solution {
    HashSet<Integer> set;
    int[] memo;
    public int mincostTickets(int[] days, int[] costs) {
        this.set = new HashSet<>();
        int length = days[days.length-1];
        this.memo = new int[length+1];

        Arrays.fill(memo, -1);

        for(int day : days){
            set.add(day);
        }
       return  helper(days,costs, days[0]);
    }

    private int helper(int[] days, int[] costs, int day){

        if(day > days[days.length-1]){
            return 0;
        }

        if(!set.contains(day))
            return helper(days,costs,day+1);

        if(memo[day] != -1) return memo[day];

        int case1 = costs[0] + helper(days,costs,day+1);
        int case2 = costs[1] + helper(days,costs,day+7);
        int case3 = costs[2] + helper(days,costs,day+30);

    memo[day] = Math.min(case1,Math.min(case2,case3));
    return memo[day];
    }
}