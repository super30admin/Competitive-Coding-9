// Time Complexity : O(mx) mx = max value in days array
// Space Complexity : O(mx+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

//         we take a dp array to store the cost required till that day.
//         array size should be maxDay length, we have 3 options
//         we keep on adding the price of previous selection-i-1 or i-7 or i-30th selection.

class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {

          
        int n = days.size();
        unordered_set<int>set;
        int mx = days[n-1];
        vector<int>dp(mx+1,0);
        for(int i =0;i<n;i++){
            set.insert(days[i]);
        }
        for(int i = 1;i<=mx;i++)
        {
            if(set.count(i)==0) {
                dp[i] = dp[i-1];
                continue;
            }
            int a = dp[i-1] + costs[0];
            int b = dp[max(0,i-7)] + costs[1];
            int c = dp[max(0,i-30)] + costs[2];
            dp[i] = min(a,min(b,c));
        }
        return dp[mx];
    }
};