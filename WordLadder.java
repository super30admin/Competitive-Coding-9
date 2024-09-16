package CompetitiveCoding9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*S30 FAANG Problem #120 {Medium} - https://www.youtube.com/watch?v=LMfyKqKHwl4&list=PLWtKyKogBpBDSDsgA3mcSlstDoKPNGSx0&index=10&t=307s
    Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

    Only one letter can be changed at a time.
    Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
    Return 0 if there is no such transformation sequence.
    Example 1:

    Input:
    beginWord = "hit",
    endWord = "cog",
    wordList = ["hot","dot","dog","lot","log","cog"]

    Output: 5
    Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
    return its length 5.

    Example 2:
    Input:
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log"]

    Output: 0
    Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
    Source Link: https://leetcode.com/problems/word-ladder/
-------------------------------------------------------------------------------------------------------
Time complexity : O(N*L) 
space complexity: O(N*L) 
Approach:
Did this code run successfully in leetcode : yes
problems faces : no
*/

public class WordLadder {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> words = new HashSet<>(wordList);
        words.remove(beginWord);
        queue.add(beginWord);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for(int i = 0; i < size; i++){
                String currentWord = queue.poll();
                if(currentWord.equals(endWord)) return level;
                List<String> neighbors = neighbors(currentWord);
                for(String neigh: neighbors){
                    if(words.contains(neigh)){
                        words.remove(neigh);
                        queue.add(neigh);
                    }
                }
            }
        }
        return 0;
    }

    public List<String> neighbors(String string){
        char[] chars = string.toCharArray();
        List<String> result = new ArrayList<>();
        for(int i = 0 ; i < chars.length; i++){
            char temp = chars[i];
            for(char c = 'a'; c <= 'z'; c++){
                chars[i] = c;
                String neighbor = new String(chars);
                result.add(neighbor);
            }
            chars[i] = temp;
        }
        return result;
    }
    
}
