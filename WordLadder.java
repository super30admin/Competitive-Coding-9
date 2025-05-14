import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList); // for fast search

        if (!dict.contains(endWord))
            return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();

                if (word.equals(endWord))
                    return level;

                char[] wordArray = word.toCharArray();
                for (int j = 0; j < wordArray.length; j++) {
                    char originalChar = wordArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar)
                            continue;
                        wordArray[j] = c;
                        String transformed = new String(wordArray);

                        if (dict.contains(transformed)) {
                            q.add(transformed);
                            dict.remove(transformed); //visited
                        }
                    }
                    wordArray[j] = originalChar; // restore original char
                }
            }
            level++;
        }
        return 0;
    }
}

//TC: O(N * L^2), SC: O(N*L)
