// Time complexity - O(n*k*26) where k = no. of words in wordList, n = length of beginWord
// Space complexity - O(2*n*k), because set holds k words of size n, at maximum queue will hold k words each of length n
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Perform Breadth-First Search (BFS) starting from `beginWord`.
//   - At each step, for each word in the queue, generate all possible one-letter transformations.
//   - If a transformed word exists in the word list (stored as a Set for O(1) lookup), add it to the queue with steps incremented and remove it from the set.
//   - Stop when the endWord is found and return the number of steps.
//   - If no transformation is found, return 0.

import java.util.*;

class Pair {
    String first;   //store word
    int second;     //store step no
    Pair(String s, int i) {     //constructor
        first = s;
        second = i;
    }
}
public class WordLadder {
    public int findSteps(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>(); //Queue to store word transformation and steps
        q.offer(new Pair(beginWord, 1));    //add beginWord to queue to start BFS
        Set<String> st = new HashSet<>(wordList);   //to unmark visited words from wordList and add words to set for better lookup
        st.remove(beginWord);   //remove start word since visited if present in wordList
        //BFS start
        while(!q.isEmpty()) {   //loop till q is empty
            Pair p = q.poll();  //get front element and fetch data members
            String word = p.first;
            int steps = p.second;
            if(word.equals(endWord)) {  //if word is same as endWord return steps
                return steps;
            }
            //transformation steps
            for(int i = 0; i < word.length(); i++) {    //loop through all char of word
                for(char ch = 'a'; ch <= 'z'; ch++) {   //loop change each char from a to z
                    char[] wordArray = word.toCharArray();
                    wordArray[i] = ch;
                    String tempWord = new String(wordArray);
                    if(st.contains(tempWord)) {     //if set contains tempWord
                        st.remove(tempWord);    //remove it
                        q.offer(new Pair(tempWord, steps + 1)); //add to queue with steps+1
                    }
                }
            }
        }
        return 0;   //return 0 if could not be converted
    }

    public static void main(String[] args) {
        WordLadder wl = new WordLadder();

        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");

        int steps = wl.findSteps(beginWord, endWord, wordList);
        System.out.println("Minimum transformation steps: " + steps); // Expected: 5 ("hit" → "hot" → "dot" → "dog" → "cog")
    }
}
