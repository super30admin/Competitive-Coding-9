//TC - O(N * L * L) - Number of words and L - length of word. ( We convert it to a char array and then back to string)
//SC - O(N) - size of queue
//Approach - The approach is to use BFS as this question deals with connected components. hit -> hot -> dot -> dog -> cog
// Add begin word to queue and maintain size to make sure all 1-letter changes of a current word are at same level. Convert into char array and check for all possibilities from a to z. 
//check if newly formed word is present in the set and then add that to the queue. If its the endword then simply return current level + 1. 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;
        //BFS 
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                for(int j = 0; j < curr.length(); j++){
                    char charArray[] = curr.toCharArray();
                    for(char c = 'a'; c <= 'z'; c++){
                        charArray[j] = c;
                        String word = new String(charArray);
                        // String word = charArray.toString(); // char array is converted to address
                        if(set.contains(word)){
                            if(word.equals(endWord)){
                                return level + 1;
                            }
                            set.remove(word);
                            q.add(word);
                        }                  
                    
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
class WordLadder{
    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>(Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
        Solution s = new Solution();
        int level = s.ladderLength(beginWord, endWord, wordList);
        System.out.println(level);

    }
}