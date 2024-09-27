//Time complexity:O(m+n)
//Space complexity:O(n)

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days == null || days.length ==0) return 0;
        int max=0;
        Set<Integer> set = new HashSet();
        for(int i : days) {
            set.add(i);
            max=Math.max(max,i);
        }
        int[] dp = new int[max+1];
        for(int i=1;i<dp.length;i++){
            if(set.contains(i)){
                dp[i]=Math.min(dp[i-1]+costs[0],Math.min(dp[Math.max(i-7,0)]+costs[1],dp[Math.max(i-30,0)] + costs[2]));
            }
            else{
                dp[i]=dp[i-1];
            }
        }
        return dp[dp.length-1];
    }
}