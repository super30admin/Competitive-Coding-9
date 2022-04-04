// Time Complexity : O(W) where W is the window of days, here its 365 days
// Space Complexity : O(W)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a solution array that would store the min cost of travel until that day
// We will loop throught the window, when we have the day in days
// We will have to buy a pass using either 3 ways, and find the min among them
// If the day is not there we can add the previous day solution to current index
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] solution = new int[366];
        int curIndex = 0;
        for(int i = 1; i < 366; i++){
            if(days[curIndex] == i){
                //Solve
                int a, b, c;
                a = solution[i-1] + costs[0];
                if(i - 7 < 0)
                    b = costs[1];
                else
                    b = solution[i-7] + costs[1];
                if(i - 30 < 0)
                    c = costs[2];
                else
                    c = solution[i-30] + costs[2];
                solution[i] = Math.min(a, Math.min(b,c));
                curIndex++;
                if(curIndex >= days.length)
                    return solution[i];
            }
            else{
                solution[i] = solution[i - 1]; 
            }
        }
        return solution[365];
     }
}