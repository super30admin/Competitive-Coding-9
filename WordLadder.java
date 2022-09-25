import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// Time Complexity : O(n*k) where n = length of word list, k = average length of each string
// Space Complexity : O(n) where n = length of word list
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach

//127. Word Ladder (Hard) - https://leetcode.com/problems/word-ladder/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for (String str : wordList) { // O(n)
            for (int i = 0; i < str.length(); i++) { // O(k)
                String pattern = str.substring(0, i) + "*" + str.substring(i+1, str.length());
                
                if (!map.containsKey(pattern)) {
                    map.put(pattern, new ArrayList<>());
                }
                
                map.get(pattern).add(str);
            }
        }
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        int level = 1;
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        while (!queue.isEmpty()) { // O(n)
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                
                if (word.equals(endWord)) {
                    return level;
                }
                
                for (int j = 0; j < word.length(); j++) { // O(k)
                    String pattern = word.substring(0, j) + "*" + word.substring(j+1, word.length());

                    if (map.containsKey(pattern)) {
                        for (String str : map.get(pattern)) {

                            if (!visited.contains(str)) {
                                visited.add(str);
                                queue.add(str);
                            }
                        }
                    }
                }
            }
            
            level++;
        }
        
        return 0;
    }
}