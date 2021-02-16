/*

class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        self.days_set = set(days)
        self.maxday = days[len(days)-1]
        return self.helper(days, days[0], costs)
        
        
    def helper(self, days, startday, costs):
        if startday > self.maxday:
            return 0
        
        #check whether day exists
        while startday not in self.days_set:
            startday += 1
        
        
        #logic
        oneDayPass = costs[0] + self.helper(days, startday+1, costs)
        sevenDayPass = costs[1] + self.helper(days, startday+7, costs)
        monthlyPass = costs[2] + self.helper(days, startday+30, costs)
        
        return min(oneDayPass, min(sevenDayPass, monthlyPass))


class Solution {
    HashSet<Integer> set;
    int maxDay;
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0)
            return 0;
        
        set = new HashSet<>();
        
        for (int d:days)
            set.add(d);
        maxDay = days[days.length-1];
        
        return helper(days[0], costs);
    }
    private int helper(int startDay, int[] costs){
        if (startDay > maxDay)
            return 0;
        
        while (!set.contains(startDay))
            startDay ++;
        
        int oneDay = costs[0] + helper(startDay+1, costs);
        int sevenDayPass = costs[1] + helper(startDay+7, costs);
        int monthlyPass = costs[2] + helper(startDay+30, costs);
        
        return Math.min(oneDay, Math.min(sevenDayPass, monthlyPass));
    }
}        
*/



/*
class Solution:
    def mincostTickets(self, days: List[int], costs: List[int]) -> int:
        if days is None or len(days) == 0:
            return 0
        
        days_set = set(days)
        
        dp = [0]*(days[len(days)-1]+1)
        
        for i in range(1, len(dp)):
            if i not in days_set:
                dp[i] = dp[i-1]
            else:
                dp[i] = min(dp[i-1]+costs[0], min(dp[max(i-7, 0)]+costs[1], dp[max(i-30,0)]+costs[2]))
        return dp[len(dp)-1]

*/

// Time - O(n) where n is maxday
// Space - O(n)
// Logic - for a particular day we check whether daypass would be feasible or go 7 days back and check whether weekpass is cheaper or 
// go month back and check whether monthlypass is cheaper

class Solution {
    HashSet<Integer> set;
    int maxDay;
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0)
            return 0;
        
        set = new HashSet<>();
        
        for (int d:days)
            set.add(d);
        
        maxDay = days[days.length-1];
        int[] dp = new int[maxDay+1];
        
        for (int i=1; i<dp.length; i++){
            if (!set.contains(i))
                dp[i] = dp[i-1];
            else{
                dp[i] = Math.min(dp[i-1]+costs[0], Math.min(dp[Math.max(i-7, 0)]+costs[1], dp[Math.max(i-30,0)]+costs[2]));
            }
        }
        
        return dp[dp.length-1];
    }
}