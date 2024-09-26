// Word Ladder
// Time Complexity : O(nl) where n is number of words in dictionary and l is length of each word
// Space Complexity : O(max(size of hashmap, number of words in dictionary)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>(); // to store the string with missing character as key and the possible words from dictionary as values
        Queue<String> q = new LinkedList<>(); // to process the upcoming word possible
        int len = beginWord.length(); 
        
        for(String s: wordList) // for each word in the list
        {
            for(int i=0;i<len;i++) // iterate over the length of the word being processed
            {
               String st = s.substring(0,i) + '_' + s.substring(i+1,len);  // find the possible string with missing character
                
                  List<String> list = map.getOrDefault(st, new ArrayList<>()); // get the list if already exists corresponding to the missing character string otherwise create a empty list
            list.add(s); // add the word to the list
            map.put(st, list); // put the new list for the key of missing character string
            }
           
        }
        int step = 1; // as we start from beginword
        q.add(beginWord); // add beginword to queue
        
         Set<String> visited = new HashSet<>(); // create a set of visited words
             visited.add(beginWord); // add the beginword to the set
        
        
        while(!q.isEmpty()) // while queue has elements to be processed
        {
            int size = q.size(); //get size to process the children
            
            for(int k=0;k<size;k++) // iterate over the size
            {
                String curr = q.poll();   // get curr word to be processed
               // System.out.println(curr);
            
            for(int i=0;i<len;i++)
            {
               String st = curr.substring(0,i) + '_' + curr.substring(i+1,len); //get the possible string swith missing character for the current word
                
                for(String word: map.getOrDefault(st, new ArrayList<>())) // iterate over the list of words possible for the combination
                {
                    
                   if(word.equals(endWord)) // if we have reached the end word
                       return step+1; // increment the step and return
                    
                if(!visited.contains(word)) // if the word has not been processed
                {
                    q.add(word); //add to queue
                    visited.add(word);   // add to visited set
                }
                             
                }
               
            }  
            }
           
            step++; // increment step when one level has been processed i.e all children for a particular missing character combination
        }
     return 0;   
        
    }
    
}

// Minimum Cost of Tickets

// Time Complexity : O(n) where n is the last day of travel
// Space Complexity : O(n) where n is the last day of travel
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach


class Solution {
    public int mincostTickets(int[] days, int[] costs) {
       HashSet<Integer> set = new HashSet<>(); // to access the days in O(1)
        for(int day : days)
        {
            set.add(day);
        }
        
        int max = days[days.length-1]; // getting the last day of travel
        int dp[] = new int[max+1]; // create a dp array of size = last day of travel as we will min calculate the cost on each day
        int n= dp.length;
        
        for(int i=1;i<n;i++)
        {
            if(!set.contains(i)) // i.e we are not travelling on that day
            {
                dp[i] = dp[i-1]; // take cost from the day before
            }
            else // make decision
            {
                int one_day = dp[Math.max(i-1,0)] + costs[0]; // cost of buying one day pass on day i
                int seven_day = dp[Math.max(i-7,0)] + costs[1]; // cost of buying seven day pass on day i
                int thirty_day = dp[Math.max(i-30,0)] + costs[2]; // cost of buying thirty day pass on day i
                dp[i] += Math.min(one_day , Math.min(seven_day, thirty_day)); // get the min out of all three choices  
            }
        }
        
        return dp[dp.length-1]; // return the min cost on last day
    }
}