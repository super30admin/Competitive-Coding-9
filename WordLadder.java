/*
 * TC: O(n * m * 26) where n is the length of the word, m is the number of words in the list
 * SC: O(m)
 */
import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // to quickly check if the word is in the list
        Set<String> words = new HashSet<>(wordList);
        // to avoid repeating words
        Set<String> visited = new HashSet<>();
        // queue to perform BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int count = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            // cover this level
            for(int j = 0; j < size; j++) {
                String word = queue.poll();
                char[] current = word.toCharArray();
                for(int i = 0; i < word.length(); i++) {
                    char tmp = current[i];
                    // change each character of the word
                    for(char x = 'a'; x <= 'z'; x++) {
                        current[i] = x;
                        String next = new String(current);
                        // if the changed word was in the word list,
                        // return count if endWord, else add to queue
                        // (also make sure it wasn't visited & add to visited)
                        if(words.contains(next) && !visited.contains(next)) {
                            if(endWord.equals(next)) return count + 1;
                            queue.add(next);
                            visited.add(next);
                        }
                    }
                    // reset the character
                    current[i] = tmp;
                }
            }
            count++; //count increments for the level
        }
        return 0;
    }
}
