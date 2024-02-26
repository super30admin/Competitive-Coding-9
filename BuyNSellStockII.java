// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yess
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: Two pointer

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1;i<prices.length;i++) {
            if(prices[i] > prices[i-1]) {
                profit += prices[i] - prices[i-1];
            }
        }
        return profit;
    }
}