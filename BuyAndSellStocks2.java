// TC: O(N)
// SC: O(1)
// Did it run successfully on Leetcode? : Yes
class Solution {
    public int maxProfit(int[] prices) {
    if ( prices == null || prices.length == 0)
        return 0;
        int maxProfit = 0;
        int profit = 0;
        
       for ( int i = 0; i < prices.length-1; i++)
       {
           if (prices[i] < prices[i+1])    
           {
               profit = profit + (prices[i+1] - prices[i]);
               maxProfit = Math.max(maxProfit, profit);
           }
       }
        return maxProfit;
    }
}
