class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int max=days[days.length-1];
        HashSet<Integer> set = new HashSet<>();
        int[] dur = new int[]{1,7,30};
        for(int i=0;i<days.length;i++){
            set.add(days[i]);
        }
        int [] dp= new int[max+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1,k=0;i<=max;i++){
            if(i!=days[k]){
                dp[i]=dp[i-1];
            }
            else{
                k++;                
                for(int j=0;j<costs.length;j++){
                    dp[i]=Math.min(dp[i],dp[Math.max(0,i-dur[j])]+costs[j]);
                }
            }
        }
        
        return dp[dp.length-1]; 
    }
}
