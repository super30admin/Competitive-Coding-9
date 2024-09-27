// Time Complexity : O(365)=O(1)
// Space Complexity : O(365)=O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None

import java.util.*;

class MinimumCost {
    public int mincostTickets(int[] days, int[] costs) {
        int [] dp = new int[366];
        HashMap<Integer,Integer> map = new HashMap<>();
        //day, index;
        for(int j=0;j<days[0];j++){
            dp[j]=0;
            map.put(j,j);
        }
        for(int i=0;i<days.length;i++){
            map.put(days[i],i);
            if(i==0){
                dp[days[i]] = Math.min(costs[0], Math.min(costs[1], costs[2]));
            }
            else{
                int d = days[i];
                int prev7day = days[i]-7;
                int prev30day = days[i]-30;
                //System.out.println(prev7day);
                //System.out.println(prev30day);
                dp[d] = Math.min(dp[d-1]+costs[0], Math.min(prev7day<=0?costs[1]:costs[1]+dp[map.get(prev7day)], prev30day<=0?costs[2]:costs[2]+dp[map.get(prev30day)]));

            }
            int temp = dp[days[i]];
            if(i+1<days.length){
                for(int j=days[i];j<days[i+1];j++){
                    dp[j]=temp;
                    map.put(j,j);
                }
            }
        }
        int d = days[days.length-1]; //lastday
        int prev7day = d-7;
        int prev30day = d-30;
        dp[d]=Math.min(dp[d-1]+costs[0], Math.min(prev7day<=0?costs[1]:costs[1]+dp[map.get(prev7day)], prev30day<=0?costs[2]:costs[2]+dp[map.get(prev30day)]));

        // for(int i=0;i<d;i++){
        //     System.out.print(dp[i]+" ");
        // }

        return dp[days[days.length-1]];
    }

    public static void main(String [] args){
        MinimumCost mc = new MinimumCost();
        System.out.println(mc.mincostTickets(new int[]{1,4,6,7,8,20}, new int[]{2,7,15}));
    }
}