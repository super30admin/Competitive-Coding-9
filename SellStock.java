// Time Complexity :O(N)
// Space Complexity :O(1) 
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No.


// Your code here along with comments explaining your approach:Iterate through the array to find out the increasing pattern and add the
// Max - min of the pattern to the profit. 
class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0)
            return 0;
        int bp=0;
        int sp=0;
        int profit =0;
        int n=prices.length;
        for(int i=0; i<n; i++){
            while(i<n-1 && prices[i]>prices[i+1])
                i++;
            if(i==n-1)
                break;
            bp=prices[i];
            while(i<n-1 && prices[i]<prices[i+1])
                i++;
            if(i==n-1)
                if(prices[i]-bp>0 )
                    sp=prices[i];
                else 
                    break;
            sp=prices[i];
            profit+=sp-bp;
        }
        return profit;
        
    }
}