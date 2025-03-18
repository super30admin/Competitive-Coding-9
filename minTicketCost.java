// Tc:O(n)
// Sc:O(n)

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int m = days[days.length-1];
        HashSet<Integer> set = new HashSet<>();
        for(int day:days){
            set.add(day);
        }
        int[] dp = new int[m+1];
        dp[0]=0;
        for(int i=1;i<=m;i++){
            if(set.contains(i)){
                int cost2=costs[1]; int cost3=costs[2];
                    int cost1=dp[i-1]+costs[0];
                if(i>=7){
                    cost2+=dp[i-7];
                }if(i>=30){
                    cost3+=dp[i-30];
                }
                dp[i]=Math.min(cost1,Math.min(cost2,cost3));
            }else{
                dp[i]=dp[i-1];
            }
        }
        
        return dp[m];
    }
}