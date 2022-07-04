//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/
// Time Complexity :O(n)  
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no
class Solution {
  
    public int maxProfit(int[] prices) {
        int profit=0;
        int i=0;
        int n=prices.length; 
        while(i<n)
        {
            int minI=minbreach(prices,i); //index of breach
            int min=prices[minI]; 
            System.out.println(min);
            if(minI==n-1)
                return profit;
            if(i+1<n){
            int maxI=maxbreach(prices,minI+1); 
            int max=prices[maxI];
            System.out.println("max"+max);
            profit+=max-min; 
                i=maxI+1;
            }
            else{
                i=n;
            }
                       
            
        }
        return profit;
        
    }
    
    private int minbreach(int[] prices,int i)
    {
        
        while( i<prices.length-1 &&prices[i]>prices[i+1])
        {
            i++;
        }
        return i;
    }
    
    private int maxbreach(int[] prices,int i)
    {
      
        while(i<prices.length-1 && prices[i]<prices[i+1])
        {
            i++;
        }
        return i;
    }
}