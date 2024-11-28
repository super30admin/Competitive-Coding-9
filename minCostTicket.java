// Time Complexity: O(last day of days)
// Space Complexity: O(last day of days)
// Idea here is to check for each day in days untill last day of travel
// if a person is travelling on certain day what is the minimum cost applied if they perchased passes 
// of 1 day 1 day ago, of 7 day 7 day ago and of 30 day 30 day ago
// whichever is minumum gives current travel min expence
// last day will give total minimum cost.
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        Set<Integer> set = new HashSet<>();
        for(int day: days) {
            set.add(day);
        }
        int [] dp= new int[days[days.length-1]+1];
        for(int i = 1; i<dp.length; i++) {
            if(!set.contains(i)) dp[i] = dp[i-1];
            else {
                dp[i] = Math.min((dp[i-1] + costs[0]), Math.min(
                dp[Math.max(i-7,0)] + costs[1], 
                dp[Math.max(i-30,0)] + costs[2]));
            }
        }
        return dp[dp.length-1];
    }
}