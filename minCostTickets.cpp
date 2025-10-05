#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use tabulation to fill a dp array from day 1 to the last travel day.
On non-travel days, we carry over the previous cost; on travel days, we try all 3 pass options.
At each travel day, we pick the minimum cost among 1-, 7-, or 30-day passes using the table.
*/
class Solution{
public:
    int minCostTickets(vector<int>& days, vector<int>& costs){
        int n = days.size();
        int lastDay = days[n-1];
        vector<int> dp(lastDay+1, 0);
        int dayIdx = 0;

        for(int i = 1; i <= lastDay; i++){
            if(i < days[dayIdx]){
                dp[i] = dp[i-1];
                continue;
            }
            dayIdx++;
            dp[i] = min(dp[i-1] + costs[0], 
                min(
                    dp[max(0, i-7)] + costs[1], 
                    dp[max(0, i-30)] + costs[2]
                )
            );
        }
        return dp[lastDay];
    }
};
