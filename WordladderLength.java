
// Time Complexity : O(N^2)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Nope


// Your code here along with comments explaining your approach
/*Approach:
1) We use a BFS approach in this question
2) we initially have to reach from begin word to end word
3) In this we start from begin word and initally check if we have the end word in wordDict
4) if the end word is present, then we can say we can reach 
5) to make it efficient we use a hashset as lookup time is O(1)
6) Once we start from the start word, we now begin the iteration with replacing every character in queue
7) we use levels in queue uptil the character length of the word and replace the character and check if it exists in the wordDict, if yes we add that weord to queue to continue the iteration.
8) also, we need to remove the word from set as we might end up in a cycle.
9) whenever we reach the end word, we return the count variable (also levels)

*/


import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>(wordList);
    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);
    
        
    int count = 1;
    while (!queue.isEmpty()) {
        int size = queue.size();
        
        
        for (int i = 0; i < size; i++) {
            char[] current = queue.poll().toCharArray();
            
            
            for (int j = 0; j < current.length; j++) {
                char tmp = current[j];
                
                
                for (char c = 'a'; c <= 'z'; c++) {
                    current[j] = c;
                    String next = new String(current);
                    
                    
                    if (set.contains(next)) {
                        if (next.equals(endWord)) return count + 1;
                        queue.add(next);
                        set.remove(next);
                    }
                }
                
                current[j] = tmp;
            }
        }
        
        
        count++;
    }
    return 0;
}
}






