//https://leetcode.com/problems/minimum-cost-for-tickets/description/

// Time Complexity :O(n*log(n))
// Space Complexity :(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach


class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        //dp array to store the min number of dollars possible
        int[] dp = new int[days.length+1];
        int start = days[0];
        int end = days[days.length-1];
        //Go over all the elements
        for(int i=1; i<dp.length; i++){
            //Get the value if we consider 1 day pass
            int x = dp[i-1] + costs[0];


                //Get the value if we consider 7 day pass
                int a = Arrays.binarySearch(days, days[i-1] - 7);
                if(a<0) a = (-1 * a) -1;
                else a = a+1;
                int y = costs[1] +  dp[a];

            
//Get the value if we consider 30 day pass
                int b = Arrays.binarySearch(days, days[i-1] - 30);
                if(b<0) b = (-1 * b) -1;
                else b = b+1;
                int z = costs[2] +  dp[b];

//Get min of three values
            dp[i] = Math.min(x, Math.min(y,z));
        }
        return dp[days.length];
    }
}