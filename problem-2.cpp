// https://leetcode.com/problems/minimum-cost-for-tickets/description/
// Time Complexity : O(1) 
// Space Complexity : O(1)

class Solution {
    public:
        int mincostTickets(vector<int>& days, vector<int>& costs) {
            int n = days.size();
            int maxEle = days[n-1];
            vector<int> dp(maxEle+1, 0);
            vector<bool> mp(maxEle+1, false);
            for(auto i:days){
                mp[i] = true;
            }
            for(int i=1; i<=maxEle; i++){
                if(!mp[i]){
                    dp[i] = dp[i-1];
                }
                else{
                    int cost1 = dp[i - 1] + costs[0]; 
                    int cost7 = dp[max(0, i - 7)] + costs[1];  
                    int cost30 = dp[max(0, i - 30)] + costs[2]; 
    
                    dp[i] = min({cost1, cost7, cost30});
                }
                
               
            }
            return dp[maxEle];
        }
    };