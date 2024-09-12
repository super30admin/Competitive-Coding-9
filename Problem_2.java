// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int result=findMinTickets(days,costs,0);
        return result;
    }
    public int findMinTickets(int[] days,int[] costs,int index){
        if(index>=days.length){
            return 0;
        }
        
        int j=index;
        for(;j<days.length;j++){
            if(days[j]>=days[index]+1){
                break;
            }
        }
        int case1=costs[0]+findMinTickets(days,costs,j);
        
        int k=index;
        for(;k<days.length;k++){
            if(days[k]>=days[index]+7){
                break;
            }
        }
        int case2=costs[1]+findMinTickets(days,costs,k);
        
        int l=index;
        for(;l<days.length;l++){
            if(days[l]>=days[index]+30){
                break;
            }
        }
        int case3=costs[2]+findMinTickets(days,costs,l);
        return Math.min(case1,Math.min(case2,case3));
    }
}

//memoization
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int max=0;
        for(int num:days){
            max=Math.max(num,max);
        }
        int[] dp=new int[max+1];
        int result=findMinTickets(days,costs,0,dp);
        return result;
    }
    public int findMinTickets(int[] days,int[] costs,int index,int[] dp){
        if(index>=days.length){
            return 0;
        }
        if(dp[index]>0) return dp[index];
        
        int j=index;
        for(;j<days.length;j++){
            if(days[j]>=days[index]+1){
                break;
            }
        }
        int case1=costs[0]+findMinTickets(days,costs,j,dp);
        
        int k=index;
        for(;k<days.length;k++){
            if(days[k]>=days[index]+7){
                break;
            }
        }
        int case2=costs[1]+findMinTickets(days,costs,k,dp);
        
        int l=index;
        for(;l<days.length;l++){
            if(days[l]>=days[index]+30){
                break;
            }
        }
        int case3=costs[2]+findMinTickets(days,costs,l,dp);
        dp[index]=Math.min(case1,Math.min(case2,case3));
        return Math.min(case1,Math.min(case2,case3));
    }
}

//tabulation
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int max=0;
        for(int num:days){
            max=Math.max(num,max);
        }
        int[] dp=new int[max+1];
        boolean[] TravelDays=new boolean[max+1];
        for(int i:days){
            TravelDays[i]=true;
        }
        for(int i=1;i<dp.length;i++){
            if(!TravelDays[i]){
                dp[i]=dp[i-1];
                continue;
            }
            if(i>=30){
                dp[i]=Math.min(costs[2]+dp[i-30],Math.min(costs[0]+dp[i-1],costs[1]+dp[i-7]));
            }else if(i>=7){
                dp[i]=Math.min(costs[0]+dp[i-1],costs[1]+dp[i-7]);
            }else{
                dp[i]=costs[0]+dp[i-1];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[dp.length-1];
        
    }

}