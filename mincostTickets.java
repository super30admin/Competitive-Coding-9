//Time Complexity:O(days.length-1)
//SPace Complexity:O(days.length-1)
//Approach- The sub problem here is to compute all possible costs for the given days and find the minimum cost amongst them. Hence a Dp array is creted with the size of 30 and then it is iterated through the days array. If the particular day in the dp array is not present in the days array, then the cost for that day will be the same as the previous day. Else, the cost for that day will be the minimum of 1 day cost, 7 days cost and 30 days cost. In this way the minimum cost for each day will be calculated and then the lastday%30 will give the minimum cost covering all the given days.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp=new int[30];
        int d=0;
        int lastday=days[days.length-1];
        for(int i=days[0];i<=lastday;i++){
            if(i!=days[d]){
                dp[i%30]=dp[(i-1)%30];
            }
            else{
                dp[i%30]=Math.min(dp[(i-1)%30]+costs[0],Math.min(dp[Math.max((i-7),0)%30]+costs[1],dp[Math.max((i-30),0)%30]+costs[2]));
                d++;
            }
            
        }
        return dp[lastday%30];
    }
}