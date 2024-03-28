// TC: O(n*l)
// SC: O(n)

// Approach: Run a bfs and add only those strings to the queue
// which are not visited or has a diff of 1 with the current.

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean[] visited = new boolean[wordList.size()];

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;

            while (size > 0) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return level;
                }
                for (int i = 0; i < wordList.size(); i++) {
                    if (visited[i] || getWordDiff(wordList.get(i), curr) != 1) {
                        continue;
                    }

                    queue.add(wordList.get(i));
                    visited[i] = true;
                }
                size--;
            }
        }

        return 0;
    }

    private int getWordDiff(String s1, String s2) {
        int diff = 0;
        int i = 0;

        while (i < s1.length()) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diff++;
                if (diff > 1) {
                    break;
                }
            }
            i++;
        }

        return diff;
    }
}