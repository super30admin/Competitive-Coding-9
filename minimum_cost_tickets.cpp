
// # Time Complexity : O(n) amortized
// # Space Complexity : O(n)
// # Did this code successfully run on Leetcode : Yes
// # Three line explanation of solution in plain english
// # At each position, I compare price of 1-day pass + previous price, 7-day pass + previous of seven day and 30-day pass + previous of thirty day
// and keep the minimum of all three and return the element at last index of memoization array.

class Solution {
public:
    int mincostTickets(vector<int>& days, vector<int>& costs) {
        int dLength = days.size();
        
        vector<int> memo(dLength, 0);

        int preSeven = 0;
        int preFifteen = 0;
        for(int i = 0; i < dLength; i++) {
            int current = days[i];
            
            while (days[i] - getArrVal(days, preSeven)>=7){
                preSeven+=1;
            }
            while (days[i] - getArrVal(days, preFifteen)>=30){
                preFifteen+=1;
            }
            
            memo[i] = std::min(std::min(costs[0]+getArrVal(memo, i-1),
                              costs[1]+getArrVal(memo, preSeven-1)),
                              costs[2]+getArrVal(memo, preFifteen-1));
        }
        return memo[dLength-1];
    }
    
    int getArrVal(vector<int>& arr, int idx) {
        if (idx < 0) {
            return 0;
        } else {
            return arr[idx];
        }
    }
};
