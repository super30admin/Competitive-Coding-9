//Time - O(1)
//Space - O(1)
class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& cost) {
        if(days.size() == 0) return 0;
        if(days.size() == 1) return cost[0];
        vector<int> arr {1,7,30};

        vector<int> dp(366,INT_MAX);
        unordered_set<int> uset;
        for(auto d:days){
            uset.insert(d);
        }    
        
        dp[0] = 0;
        for(int i=1;i<366;i++){
            if(uset.find(i)!=uset.end()){
                for(int j=2;j>=0;j--){
                    if(i-arr[j]>=0){
                        dp[i] = min(dp[i],dp[i-arr[j]]+cost[j]);              
                    }else{
                        dp[i] = min(dp[i],dp[0]+cost[j]);
                    }
                }
            }else{
                dp[i] = dp[i-1];
            }
        }


        return dp[365];
   }
};