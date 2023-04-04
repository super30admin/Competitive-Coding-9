983. Minimum Cost For Tickets

TC O(n)
SC O(n)

#include <algorithm>
class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {

        int x,y = 0;

        vector<int> dp;
        int m = days[days.size()-1];
        dp.push_back(0);

        for (int i =1; i <= m; i++) {
             if (find(days.begin(), days.end(), i) != days.end()) {
                 x = max(0, (i-7));
                 y = max(0, i-30);
                 int mini = min((dp[x])+costs[1],(dp[y] + costs[2]));
                dp.push_back(min((dp[i-1]+costs[0]), mini));
             } else {
                 dp.push_back(dp[i-1]);
             }
        }
        return dp[m];
    }
};

