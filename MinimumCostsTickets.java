
//Time Complexity-O(n)
//Space-O(n)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
       int length =days[days.length-1];
        int[]dp=new int[length+1];
        HashSet<Integer>set=new HashSet();
        for(int day:days)
        {
            set.add(day);
        }
        for(int i=1;i<dp.length;i++)
        {
            if(set.contains(i))
            {
            dp[i] = Math.min(Math.min(dp[i - 1] + costs[0], dp[Math.max(0, i - 7)] + costs[1]), dp[Math.max(0, i - 30)] + costs[2]);

            }
            else
            {
                dp[i]=dp[i-1];
             }          
        }
        return dp[dp.length-1];
        
    }
}