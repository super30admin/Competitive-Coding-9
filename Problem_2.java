//Time Complexity:O(m+n)
//Space Complexity:O(m+n) m is the max of days array and n is length of days array
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        
        HashSet<Integer> set = new HashSet<>();
        int max=0;
        for(int day:days){
            max = Math.max(max,day);
            set.add(day);
        }
        int[] dp = new int[max+1];
        for(int i=1;i<dp.length;i++){
            if(!set.contains(i)){
                dp[i] = dp[i-1];
            }else{
                dp[i]= Math.min((dp[i-1]+costs[0]),Math.min(dp[Math.max(0,i-7)]+costs[1], dp[Math.max(0,i-30)]+costs[2])); 
                }
        }
        return dp[dp.length-1];
    }
}