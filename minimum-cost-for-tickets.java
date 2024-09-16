// Time Complexity : O(N) where N is max element of days array + 1
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days[days.length-1];
        boolean[] daysIncluded = new boolean[n+1];
        for(int day : days)
            daysIncluded[day]=true;
        
        int minCost[] = new int[n+1];
        for(int day=1;day<=n;day++)
        {
            if(!daysIncluded[day]) {
                minCost[day]=minCost[day-1];
                continue;
            }
            
            minCost[day] = minCost[day-1]+costs[0];
            minCost[day] = Math.min(minCost[day], minCost[Math.max(0, day-7)]+costs[1]);
            minCost[day] = Math.min(minCost[day], minCost[Math.max(0, day-30)]+costs[2]);
        }
        return minCost[n];
    }
}
