//The idea here is that because we can have multiple combinations, it represents a graph.
//So for each word, we take all possibilities and we create a graph using adjacency list using all the words
//Now to find the minimum length, it's like finding shortest distance between two nodes, so we can use BFS
//We start with begin word and add it to queue, and when we process it, we add all the possible next words into queue and increase the level by 1
//Whenever, we find the end word, we return that level
//Time Complexity: O(m*n) where n is the number of words in wordlist and m is the avg length of each word
//Space Compelxity: O(m*n)
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, ArrayList<String>> dict = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int len = beginWord.length();

        for (String w : wordList) {
            for (int j = 0; j < len; j++) {
                String word = w.substring(0, j) + '*' + w.substring(j + 1, len);
                if (!dict.containsKey(word)) {
                    dict.put(word, new ArrayList<>());
                }
                dict.get(word).add(w);
            }
        }

        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        int level = 1; // Start at 1 since the first word itself is counted

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                String word = q.remove();
                for (int i = 0; i < len; i++) {
                    String newWord = word.substring(0, i) + '*' + word.substring(i + 1, len);
                    for (String adjWord : dict.getOrDefault(newWord, new ArrayList<>())) {
                        if (adjWord.equals(endWord)) return level + 1;
                        if (!visited.containsKey(adjWord)) {
                            visited.put(adjWord, true);
                            q.add(adjWord);
                        }
                    }
                }
            }
            level++; // Increment level after processing all words at the current level
        }
        return 0;
    }
}
