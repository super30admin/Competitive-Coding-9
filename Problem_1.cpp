//Time: O(N)
//Space: O(1)
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        if(prices.size()==0) return 0;
        int value = 0;
        int sz = prices.size();
        int arr[sz];
        for(int i=1; i<prices.size(); i++){
            value = std::max(value , value + (prices[i]-prices[i-1]));
        }
        return value;
    }
};