import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, ArrayList<String>> dict = new HashMap<>();
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        int len = beginWord.length();

        for (String w : wordList) {
            for (int j = 0; j < len; j++) {
                String word = w.substring(0, j) + '*' + w.substring(j + 1, len);
                ArrayList<String> list = dict.getOrDefault(word, new ArrayList<>());
                list.add(w);
                dict.put(word, list);
            }
        }

        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        int level = 0;
        while (!q.isEmpty()) {
            String word = q.remove();
            level++;
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i + 1, len);
                for (String adjword : dict.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjword.equals(endWord))
                        return level;
                    if (!visited.containsKey(adjword)) {
                        visited.put(adjword, true);
                        q.add(adjword);
                    }
                }
            }
        }
        return 0;

    }
}