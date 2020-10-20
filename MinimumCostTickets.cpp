// Time Complexity : O(1) as the maximum of days will be only 365.. constant.
// Space Complexity : O(1) same maximum 365
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no issues as of now.. Learning


class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        set<int> set ; // to access the days in O(1)
        for(int day : days)
        {
            set.insert(day);
        }
        
        int max = days[days.size()-1]; // getting the last day of travel
        vector<int> dp(max+1, 0); // create a dp array of size = last day of travel as we will min calculate the cost on each day
        int n= dp.size();
        
        
        int one_day;
        int seven_day;
            int thirty_day;   
        for(int i=1;i<n;i++)
        {
            if(!(set.find(i)!= set.end())) // i.e we are not travelling on that day
            {
                dp[i] = dp[i-1]; // take cost from the day before
            }
            else // make decision
            {
             i == 1 ? one_day =  costs[0]:one_day = dp[i-1] + costs[0];     
     
                  
                i <=7? seven_day = costs[1]: seven_day = dp[i-7] + costs[1];
                
                 i <= 30? thirty_day =costs[2]:thirty_day = dp[i-30] + costs[2]; 
            
   
                dp[i] =min(one_day , min(seven_day, thirty_day)); // get the min out of all three choices  
            }
        }
        
        return dp[dp.size()-1]; // return the min cost on last day
    }
};
