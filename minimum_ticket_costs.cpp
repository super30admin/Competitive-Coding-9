// Time Complexity : O(n) atleast. A bit confused with TC :(
// Space Complexity :  O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this - 

class Solution {
private:
    vector<int> tcosts;
    vector<int> memo;
    set<int> dayset;
    
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        
        tcosts = costs;
    
        for(int i = 0; i < 366; i++)
            memo.push_back(0);
        
        // Add all days in a set
        for(int i = 0; i < days.size(); i++)
            dayset.insert(days[i]);
        
        return helper_dp(1);
    }
    
    int helper_dp(int num)
    {
        // Cannot be more than 365
        if(num > 365)
            return 0;
        
        // If the memo already planned
        if(memo[num] != NULL)
            return memo[num];
        
        int res;
        
        // Check if day present or not
        if(dayset.find(num) != dayset.end())
        {
            res = min(helper_dp(num+1) + tcosts[0], helper_dp(num+7) + tcosts[1]);
            
            res = min(res, helper_dp(num+30) + tcosts[2]);
        }
        else
            res = helper_dp(num+1);
        
        memo[num] = res;
        return res;
    }
};