/*
TC = O(n)
SC = O(n)
where n is the size of the vector days.
*/
class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        set<int>s(days.begin(),days.end());
        vector<int>dp(366,0);
        for(int i=1;i<366;i++)
        {
            if(s.find(i)==s.end())
            {
                dp[i]=dp[i-1];
            }
            else
            {
                dp[i]=min({costs[0]+dp[i-1],costs[1]+dp[max(0,i-7)],costs[2]+dp[max(0,i-30)]});
            }
        }
        return dp[365];
    }
};
