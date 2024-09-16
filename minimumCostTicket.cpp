// Time Complexity :O(n) where n in the number elements in the vector
// Space Complexity : O(max(days)+1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        set<int> hSet;
        for(auto day : days){
            hSet.insert(day);
        }
        vector<int> dp(days.back()+1,0);
        for (int i = 1; i < dp.size();i++){
            if(hSet.find(i) == hSet.end()) dp[i] = dp[i-1];
            else{
                dp[i] = min(dp[i-1] + costs[0],min(dp[max(i-7,0)] + costs[1],dp[max(i-30,0)]+costs[2]));
            }
        }
        return dp[dp.size()-1];
    }
};