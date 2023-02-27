// TC: 0(n)
// SC: 0(n)


// This will be a DP solution because of repeated subproblems.
// At every travel day you have 3 choices, buy 1 day pass, 7 day pass and 30 day pass
// You create a hashset of the travel days so that we know which days are travel days when
// we create the dp array
// Create a dp array of size of the total no. of days in days array +1 (for day 0).
// Traverse through dp array 
// If the 'i'th day is not a travel day, copy ticket value from i-1 day.

// For 1 day pass, 
// at day 2, I wouldve bought 1 day pass on the same day

// For 7 day pass,
// at day 5, I wouldve bought 7 day pass at day 0 
// Because if I did i-7(days) i.e. 5-7 = -2, it is negative so here we take value from day 0
// at day 9, I woulve bought 7 day pass at i-7 i.e. 9-7 = day 2


// For 30 day pass,
// in this test case there are 20 days so the 30 day pass I can buy on day 0 and it will work
// for all my travel days


class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        int size=days[days.length-1]; //get the last travel day
        
        // hashset for travel days
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<days.length;i++){
            set.add(days[i]);
        }
        int[] dp = new int[size+1]; //last travel day + 1 for day 0
        dp[0]=0;
        
        //traverse dp and check from hashset if that day is a travel day
        for(int i=1;i<dp.length;i++){
            if(!set.contains(i)){
                dp[i]=dp[i-1]; //not travelling then copy prev value
            }
            else{
                dp[i]=Math.min(dp[i-1]+costs[0], // 1 day pass 
                      Math.min(dp[Math.max(0,i-7)]+costs[1], // 7 day pass
                               dp[Math.max(0,i-30)]+costs[2])); //30 day pass
            }
        }

        return dp[dp.length-1];
    }
}


// 1 day pass is prev value[i-1] + 1 day pass cost
// 7 day pass is max of 0,i-7 because if i-7 is -ve we take value from day 0
// 30 day pass is max of 0,i-30 because if i-30 is -ve then we take value from day 0