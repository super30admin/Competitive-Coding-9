// Time Complexity : O(input array length)
// Space Complexity : O(input array length)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int len= days[days.length-1];
        int[] arr = new int[len+1];
        Set<Integer> set = new HashSet<Integer>();
        for(int n:days)
            set.add(n);
        
        for(int i=1;i<=len;i++){
            if(set.contains(i)){
                arr[i]=arr[i-1]+costs[0];
                arr[i]=Math.min(arr[i],arr[i-7<0?0:i-7]+costs[1]);
                arr[i]=Math.min(arr[i],arr[i-30<0?0:i-30]+costs[2]);
            }else{
                arr[i]=arr[i-1];
            }
        }
        return arr[len];
        
    }
}
