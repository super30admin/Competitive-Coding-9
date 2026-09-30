//Time Complexity: O(n * l * 26)
//Space Complexity: O(n)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        wordSet.add(beginWord);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String currWord = q.poll();
                char[] charWord = currWord.toCharArray();

                for (int j = 0; j < charWord.length; j++) {
                    char original = charWord[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (charWord[j] == c)
                            continue;

                        charWord[j] = c;
                        String newWord = new String(charWord);

                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        if (wordSet.contains(newWord)) {
                            q.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }

                    charWord[j] = original; // Restore original character
                }
            }

            level++;
        }

        return 0;
    }
}