/*Time Complexity: O(N)

Space Complexity: O(2N)

Did this code successfully run on Leetcode : Yes

Approach: First, recursion to try 3 different passes for each day -> TLE (3^N). So,
DP for optimal solution.

Prob: 983. Minimum Cost For Tickets

*/
#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    int helper(int i,unordered_set<int>& hs,vector<int>& costs,int max_day,vector<int>& dp){
        // base
        int day,week,month;
        if(i > max_day) return 0;
        if(dp[i] != -1){
            return dp[i];
        }
        // logic
        if(hs.find(i) != hs.end()){
            day = costs[0] + helper(i+1,hs,costs,max_day,dp);
            week = costs[1] + helper(i+7,hs,costs,max_day,dp);
            month = costs[2] + helper(i+30,hs,costs,max_day,dp);
        }
        else{
            return helper(i+1,hs,costs,max_day,dp);
        }
        return dp[i] = min(day,min(week,month));
    }
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        int n = days.size();
        unordered_set<int> hs(days.begin(), days.end());
        int max_day = days.back();
        vector<int> dp(max_day+1,-1);
        return helper(1,hs,costs,max_day,dp);
    }
};