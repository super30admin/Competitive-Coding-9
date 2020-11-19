//time complexity:O(n)
//space complexity:O(n)
//executed on leetcode: yes
//approach:using dp
//any issues faced? yes

class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        int lastday=days[days.size()-1];
        vector<int>dp(lastday+1,0);
        int dayidx=0;
        for(int i=1; i<lastday+1; i++)
        {
            if(i!=days[dayidx])
            {
                dp[i]=dp[i-1];
            }
            else
            {
                dp[i]=min({dp[i-1]+costs[0], dp[max(i-7,0)]+costs[1], dp[max(i-30,0)]+costs[2]});
                dayidx++;
            }
        }
        return dp[lastday];
    }
};