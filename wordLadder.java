// Time Complexity :O(n*m*m*26) where n is the number of words in the wordList and m is the length of each word
// Space Complexity : O(n) where n is the number of words in the wordList
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/*
 * 1. Add all the words in the wordList to a set.
 * 2. Add the beginWord to the queue to start BFS. 
 * 3. For each word in the queue, replace each character with a-z and check if the new word is in the set. If it is, add it to the queue and remove it from the set.
 * 4. If the new word is the endWord, return the depth+1.
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word : wordList){
            set.add(word);
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int depth = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            depth++;

            for(int i=0; i<size; i++){
                String currWord = queue.poll();
                char[] currWordCh = currWord.toCharArray();
                for(int j=0; j<currWordCh.length; j++){
                    char prevch = currWordCh[j];
                    for(int k=0; k<26; k++){
                        char replaceChar = (char)('a' + k);
                        if(replaceChar == prevch)
                            continue;
                        
                        currWordCh[j] = replaceChar;
                        String newWord = new String(currWordCh);
                        if(!set.contains(newWord))
                            continue;
                        if(newWord.equals(endWord))
                            return depth+1;

                        set.remove(newWord);
                        queue.offer(newWord);
                    }

                    currWordCh[j] = prevch;
                }
            }
        }

        return 0;
    }
}