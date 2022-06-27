//time -O(n)
//space - O(1)
class Solution {
    public int maxProfit(int[] prices) {
      int profit = 0;
      int buy = prices[0];
      for(int i =1; i< prices.length; i++){
          if(prices[i]<buy){
              buy = prices[i];
          }else{
              int curr_profit = prices[i]-buy;
              if(curr_profit>profit) profit = curr_profit;
          }
          
      }
        return profit;
    }
}