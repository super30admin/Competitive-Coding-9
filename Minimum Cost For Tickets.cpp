//time complexity: O(n) space complexity: O(n)

class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        int n = days[days.size()-1];        
        vector<int> dp(n+1);
        dp[0] = 0;
        int a, b, c, j = 0;
        for(int i = 1; i <= n; i++) {
            
            if(i != days[j]) dp[i] = dp[i-1];

            else {
                
                if((i-30) < 0) a = costs[2];
                else a = dp[i-30] + costs[2];

                if((i-7) < 0) b = costs[1];
                else b = dp[i-7] + costs[1];

                if((i-1) < 0) c = costs[0];
                else c = dp[i-1] + costs[0];

                int temp = min(a, b);
                dp[i] = min(temp, c);
                
                j++;

            }
        }
        return dp[n];
    }
};
