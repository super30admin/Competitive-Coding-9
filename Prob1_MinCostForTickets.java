//TC : O(N) - Iterating overs days in linear order of time
//SC : O(N) - Using 1d array

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> set = new HashSet<>();
        
        int maximum = Integer.MIN_VALUE;
        
        for(int i = 0; i< days.length; i++){
            set.add(days[i]);
            maximum = Math.max(days[i], maximum); // MAXIMUM No. in Days for travel
        }
        
        int[] result = new int[maximum+1]; // Creating 1D array
        result[0] = 0;
        
        for(int i = 1; i< result.length; i++){
            if(!set.contains(i)){ //If not travelling 
                result[i] = result[i-1];
                continue;
            }
               result[i] = Math.min(result[i-1] + costs[0] , Math.min( result[Math.max(0, i-7)] + costs[1], result[Math.max(0, i-30)] + costs[2] ));
        }
        
        return result[result.length - 1];
        
    }
}