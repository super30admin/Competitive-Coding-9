// Time Complexity :O(n) 
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Min cost of tickets 

#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        
        // base case
        if(days.empty() || costs.empty())
            return 0;
        
        vector<int> dp(days.size(), 0); // init to zero
        
        helper(days, costs, dp, 0);
        
        return dp[0];
    }
    
    
    int helper(vector<int>& days, vector<int>&costs, vector<int>& dp, int index){
        
        //base 
        if(index >= days.size())
            return 0;
        
        
        // logic 
        
        if(dp[index] > 0)   // if value already present, memoization
            return dp[index];
        
        int p1 = costs[0] + helper(days, costs, dp, index + 1);
        
        int j = index;
        while(j < days.size()){
            if(days[j] >= days[index] + 7)
                break;
            
            j++;
        }
        
        int p2 = costs[1] + helper(days, costs, dp, j);
        
        int k = index;
        while(k < days.size()){
            if(days[k] >= days[index] + 30)
                break;
            
            k++;
        }
        
        int p3 = costs[2] + helper(days, costs, dp, k);
        
        
        dp[index] = std::min(p1,std::min(p2,p3));
        return dp[index];
    }
};