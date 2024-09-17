// Time Complexity : O(n) 
// Space Complexity : O(m), where m is the last day in the days array (length of min)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//take the last day from days array and create a min array with that length+1 (each element corresponds to the cost till the last day)
//this array keeps track of the minimum cost to travel uptil that particular day
//we maintain a hashset for the days given in our input
//loop through the min array and if the day is present in our hashset, then find the cost for 3 passes uptil that particular day
//find the minimum of the 3 passes and add it to the min array
//if the day isnt presnt in hashset,then just update the min array of that day with its previous value as we are not travelling that day and the cost would be same as the previous value
//return the last value from the min array which has our min cost

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> res=new HashSet<>();
        int last=days[days.length-1];
        int[] min=new int[last+1];
        
        for(int i=0;i<days.length;i++){
            res.add(days[i]);
        }
        
        for(int i=1;i<min.length;i++){
            if(res.contains(i)){
                int min1 = costs[0]+min[i-1];
                
                int min7 = costs[1]+min[Math.max(i-7,0)];
                
                int min15= costs[2]+min[Math.max(i-30,0)];
                
                min[i]=Math.min(min1,Math.min(min7,min15));
            }
            else{
                min[i]=min[i-1];
            }
        }
        
        return min[min.length-1];
    }
}