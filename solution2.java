//Time Complexity:O(N)
//Space Complexity:	O(N)
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        //edge 
        if(days == null || days.length ==0)return 0;
        int lastDay =days[days.length-1];
        HashSet<Integer> hs = new HashSet<>();
        for(int i: days){
            hs.add(i);
            }
        int[] dp = new int[lastDay+1]; // starting from 0
        dp[0] = 0;
        for(int i =1;i<dp.length;i++){
            if(hs.contains(i)){
                dp[i] = Math.min(Math.min((dp[i-1] + costs[0]),
                        (dp[Math.max(0,i-7)] + costs[1])),
                         (dp[Math.max(0,i-30)] + costs[2]));
            }else{
                dp[i] = dp[i-1];
            }
        }return dp[lastDay];
    }
}