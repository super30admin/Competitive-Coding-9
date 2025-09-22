
//Time Complexity: O(N) where N is the number of days.
//Space Complexity: O(N) for the recursion stack and the


//given a list of days when you will travel and an array of costs for 1-day, 7-day, and 30-day passes,
//find the minimum cost to cover all the travel days.

//since recursion will be called multiple times for the same day, we can use memoization to store the results of already computed days.
//we can use a hash map to store the minimum cost for each day.
//we start from the first day and try to buy a 1-day, 7-day, or 30-day pass.
//we recursively call the function for the next day that is not covered by the pass we bought.
//we return the minimum cost among the three options and store it in the hash map.
//if we reach the end of the days array, we return 0 as there are no more days to cover.

class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n=days.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        return helper(days,costs,0,map);
    }
    private int helper(int days[],int costs[],int pivot, HashMap<Integer,Integer> map){

        if(pivot==days.length)  //base case
            return 0;

        if(map.containsKey(days[pivot]))  // memoization check
            return map.get(days[pivot]);

        int d1=helper(days,costs,pivot+1,map)+costs[0];  // 1-day pass

        int i=pivot;
        int daysCovered=days[i]+7; 
        
        for(i=0;i<days.length;i++){
            if(days[i]>=daysCovered)    //getting the next index which is not covered by 7-day pass
                break;
                
        }
        int d7=helper(days,costs,i,map)+costs[1];   // 7-day pass

        int j=pivot;
        int daysCovered=days[j]+30;
        for(j=0;j<days.length;j++){
            if(days[j]>=daysCovered)    //getting the next index which is not covered by 30-day pass
                break;
        }
        int d30=helper(days,costs,j,map)+costs[2];   // 30-day pass

        map.put(days[pivot],Math.min(d1,Math.min(d7,d30)));   //storing the result in the map

        return Math.min(d1,Math.min(d7,d30));      //returning the minimum cost
    }
}