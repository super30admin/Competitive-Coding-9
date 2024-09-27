// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int peak = prices[0], valley = prices[0];
        int i = 0;
        while(i < prices.length - 1) {
            while(i < prices.length - 1 && prices[i] >= prices[i+1]) {
                i++;
            }
            valley = prices[i];
            
            while(i < prices.length -1 && prices[i] < prices[i+1]) {
                i++;
            }
            peak = prices[i];
            
            result += peak - valley;
        }
        
        return result;
    }
}