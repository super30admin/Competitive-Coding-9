// Time Complexity : O(n*l^2) where n is the number of words in wordList and l is length of longest words
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach: We use a Breadth-First Search (BFS) approach to find the shortest sequence of words that can transform beginWord into endWord by changing one letter at a time while ensuring each intermediate word exists in wordList. Our code iterates through the wordList, exploring all possible word transformations and maintaining a queue of words to be processed in each level. When the endWord is found, the length of the transformation sequence is returned. If no transformation is possible, it returns 0.

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int length = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String currWor = queue.poll();
                char[] wordChars = currWor.toCharArray();
                // Start putting
                for (int j = 0; j < wordChars.length; j++) {
                    char origChar = wordChars[j];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (wordChars[j] == ch) {
                            continue;
                        }
                        wordChars[j] = ch;
                        String newWord = new String(wordChars);
                        // Trying
                        if (newWord.equals(endWord)) {
                            return length + 1;
                        }
                        if (set.contains(newWord)) {
                            queue.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    wordChars[j] = origChar;
                }
                // System.out.println("");
            }
            length++;
        }
        return 0;
    }

    public static void main(String[] args) {
        // Example usage of ladderLength method
        WordLadder wordLadder = new WordLadder();
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        int length = wordLadder.ladderLength(beginWord, endWord, wordList);
        System.out.println("The length of the word ladder is: " + length);
    }
}
