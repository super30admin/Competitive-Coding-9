import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Tc: O(n*L) Sc: O(n)
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String currentWord = queue.poll();
                for (int j = 0; j < currentWord.length(); j++) {
                    char[] wordArray = currentWord.toCharArray();
                    char originalChar = wordArray[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar)
                            continue;
                        wordArray[j] = c;
                        String nextWord = new String(wordArray);

                        if (nextWord.equals(endWord)) {
                            return level + 1;
                        }

                        if (wordSet.contains(nextWord)) {
                            queue.add(nextWord);
                            wordSet.remove(nextWord);
                        }
                    }
                }
            }
            level++;
        }

        return 0;

    }
}