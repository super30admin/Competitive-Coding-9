/*
 * #127. Word Ladder
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

1. Only one letter can be changed at a time.
2. Each transformed word must exist in the word list.

Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

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

 */


/*
 * Time Complexity: O (M^2*N) -> For each word in the word list, we iterate over its length to find all the intermediate words corresponding to it. 
 * 							Since the number of characters in each word is M and we have N words, the total number of iterations the algorithm takes to find transformations is M times N -> M×N
 * 							For 1 character, we are looping 26 times, for M characters, 26M times = M times, so (M^2*N)
 * 
 * Space Complexity: O (h + q) -> h - copy of all strings from wordList to a Set, q - all the valid transformation words stored in a queue
 * 
 * Did this code successfully run on leetcode: Yes
 * 
 * Any problem you faced while coding this: No
 * 
 */


package com.s30.edu.competitvecoding9;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        /*
        * 1. Only one letter can be changed at a time.
          2. Each transformed word must exist in the word list.
        */
       
        // According to second condition, we will have to check if a transformed word is present in a list, which takes O (n)
        // To reduce time for that, use a Set and copy all the strings from wordList to a Set, where lookup time is constant, O (1)
        HashSet<String> set = new HashSet<>(wordList);
       
        // According to 2nd condition, if endWord is not in a Set, return 0
        if(!set.contains(endWord)){
            return 0;
        }
       
        // We need minimum length of transformation sequence, can use BFS, create a queue
        Queue<String> q = new LinkedList<String>();
       
        // Initiate a queue with beginWord, start at level 1
        q.add(beginWord);
        int level = 1;
       
        // BFS level order traversal
        /*
        * 1. Get the size of a queue at current level
        * 2. For all the words at a current level, poll the front as current word from queue
        * 3. Since, Strings in JAVA are immutable, convert the current word to character array
        * 4. For each character in array for a current word:
        *       1. First, store the original character in a variable to recover it later
        *       2. loop through all the 'a' to 'z' characters in alphabet and replace original character with it to try out all the possibilities for next transformation
        *           1. If original character is same as current alphabet, ignore it, continue;
        *           2. If not, replace original character with current alphabet
        *           3. Convert the current character array to string
        *           4. If the new word is equal to endWord, we reached destination, return length of shortest transformation sequence as level + 1, as the next word will be at level below the current level
        *           5. If new word is eligible for next transformation, present in a set, then add to queue to process it later, and remove it from set to avoid duplicates
        *           6.Increment the character in alphabet and repeat above steps
        *       3. Once all characters in alphabet are done, restore the original character in word_chars array
        *       4. Move on to the next character to replace in 'word_chars' array
        *       5. Once, we are done with all the characters in a 'word_chars' array for a current word, poll the next word from queue at current level and repeat all the same steps
        *       6. If all words at current level are processed, then go to next level, level++
        *       7. If endWord is not found, return 0
        */
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                String curr_word = q.poll();
               
                char[] word_chars = curr_word.toCharArray();
                for(int j = 0; j < word_chars.length; j++){
                    char originalCharToReplace = word_chars[j];
                    for(char c = 'a'; c <= 'z'; c++){
                       
                        if(word_chars[j] == c){
                            continue;
                        }
                        word_chars[j] = c;
                        String new_word = String.valueOf(word_chars);
                       
                        if(new_word.equals(endWord)){
                            return level + 1;
                        }
                        if(set.contains(new_word)){
                            q.add(new_word);
                            set.remove(new_word);
                        }
                    }
                   
                    word_chars[j] = originalCharToReplace;
                }
               
            }
           
            level++;    
               
               
        }
       
        return 0;
       
    }
	
}
