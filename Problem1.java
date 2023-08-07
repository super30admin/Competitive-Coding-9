// Time Complexity :O(n) where n is the length of the prices array
// Space Complexity :O(1) as no auxiliary space used
// Did this code successfully run on Leetcode :yes
public class Problem1 {
    public int maxProfit(int[] prices) {

        if(prices == null || prices.length < 1){
            return 0;
        }

        int len = prices.length;
        int start = 0;
        int end = 1;
        int peak = prices[start];
        int profit = 0;

        while(end < len){
            peak = prices[start];
            while(end < len && prices[end] > peak){
                peak = prices[end];
                end++;
            }
            profit = profit + peak - prices[start];
            start = end;
            end = start+1;
        }
        return profit;
    }
}
