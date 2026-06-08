// Time Complexity : o(n * m) where n is the number of words in the wordList and m is the length of each word
// Space Complexity : o(n) where n is the number of words in the wordList
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No


// Your code here along with comments explaining your approach
// We can use BFS to find the shortest path from beginWord to endWord. We will start with the beginWord and generate all possible words by changing one character at a time. If the generated word is in the wordList and has not been visited, we will add it to the queue and mark it as visited. We will keep track of the level of BFS and return the level when we reach the endWord. If we exhaust the queue without finding the endWord, we will return 0.
// We can also use a HashSet to store the wordList for O(1) lookups and a HashSet to keep track of visited words to avoid cycles.
// We will iterate through each character of the current word and replace it with every possible character from 'a' to 'z' to generate new words. If the new word is in the wordList and has not been visited, we will add it to the queue for further exploration. 
//  We will continue this process until we find the endWord or exhaust the queue. The level variable will keep track of the number of transformations needed to reach the endWord, which is the length of the shortest path.
// We will return the level when we find the endWord, which represents the length of the shortest transformation sequence. If we exhaust the queue without finding the endWord, we will return 0, indicating that there is no valid transformation sequence.
// This approach ensures that we explore all possible transformations level by level, guaranteeing that we find the shortest path from beginWord to endWord.

import java.util.*;

class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int k = 0; k < size; k++) {

                String word = queue.poll();

                if (word.equals(endWord)) {
                    return level;
                }

                char[] chars = word.toCharArray();

                for (int i = 0; i < chars.length; i++) {

                    char original = chars[i];

                    for (char ch = 'a'; ch <= 'z'; ch++) {

                        chars[i] = ch;

                        String newWord = new String(chars);

                        if (set.contains(newWord)
                                && !visited.contains(newWord)) {

                            visited.add(newWord);
                            queue.offer(newWord);
                        }
                    }

                    chars[i] = original;
                }
            }

            level++;
        }

        return 0;
    }
}