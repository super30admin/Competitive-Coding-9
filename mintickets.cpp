//TC: O(365)
//SC: O(365)

class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        unordered_map<int,int> tickets;
        
        //create a map of ticket prices to costs
        tickets[1] = costs[0];
        tickets[7] = costs[1];
        tickets[30] = costs[2];
        
        //dp array of length 366 since we travel for a year. Each index of the dp array is the minimum dollars to travel every day. 
        vector<int> dp(366, INT_MAX);
        
        //initialize this to 0
        dp[0] = 0;
        for(int i=1; i<366; ++i){
            //logic is if i is not part of the given days array then the cost will be the same as the previous day's cost. (Since we do not buy a ticket for this day so the total cost at this day will be the same as the previous day)
            if(find(days.begin(), days.end(), i) == days.end()){
                dp[i] = dp[i-1];
                continue;
            }
            //if i is part of the days array, we check for every ticket price and see if the cost at i-ticket for x day + ticket price at x day is smaller than the current dp array. 
            for(auto ticket : tickets){
                dp[i] = min(dp[i], dp[max(0, i-ticket.first)] + ticket.second);
            }
        }
        
        //we then return the last value of the dp array. 
        return dp[365];
    }
};