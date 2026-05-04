//TC : O(n * m)
//SC : O(n)

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Set<String> set = new HashSet<>(wordList);
        
        if (!set.contains(endWord)) {
            return 0;
        }
        
        Queue<String> q = new LinkedList<>();
        
        q.offer(beginWord);
        
        int level = 1;
        
        while (!q.isEmpty()) {
            int s = q.size();
            
            for (int i = 0; i < s; i++) {
                String currWord = q.poll();
                if (currWord.equals(endWord)) {
                    return level;
                }
                
                for (int j = 0; j < currWord.length(); j++) {
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        
                        char[] arr = currWord.toCharArray();
                        arr[j] = c;
                        
                        String newWord = new String(arr);
                        
                        if (set.contains(newWord)) {
                            q.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                }
            }
            
            level++;
        }
        
        return 0;
    }
}