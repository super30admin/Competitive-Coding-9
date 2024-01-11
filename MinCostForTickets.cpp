class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        int index=0;
        int n = days.size()-1;
        vector<int> dp(n+1, -1);

        int ans = helper(days, costs, index, dp);
        return ans;
    }

    private:
    
    int helper(vector<int> &days, vector<int> costs, int index, vector<int> &dp)
    {
        if(index >= days.size())
            return 0;
        
        if(dp[index] != -1)
            return dp[index];

        //1day
        int cost1 = costs[0] + helper(days, costs, index+1, dp);

        //7days
        int endDayof7=days[index] + 7 - 1;
        int currDayfor7 = index;
        while(currDayfor7<days.size() && days[currDayfor7] <= endDayof7)
            currDayfor7++;
        int cost7=costs[1] + helper(days, costs, currDayfor7, dp);

        //30days
        int endDayof30=days[index] + 30 - 1;
        int currDayfor30=index;
        while(currDayfor30<days.size() && days[currDayfor30] <= endDayof30)
            currDayfor30++;
        int cost30=costs[2] + helper(days, costs, currDayfor30, dp);

        dp[index] = min(cost1, min(cost7, cost30));
        return dp[index];
    }
};