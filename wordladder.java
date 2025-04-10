// TC: O(n * l * 26)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Add all words from wordList into a HashSet for O(1) lookups.
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String currWord = q.poll();
                char[] charWord = currWord.toCharArray();
                for (int j = 0; j < charWord.length; j++) {
                    char temp = charWord[j];
                    // Iterate through all possible lowercase letters.
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (charWord[j] == c) {
                            continue;
                        }
                        charWord[j] = c;
                        String newString = String.valueOf(charWord);
                        if (newString.equals(endWord)) {
                            return level + 1;
                        }
                        if (set.contains(newString)) {
                            q.offer(newString);
                            set.remove(newString);
                        }
                    }
                    charWord[j] = temp;
                }
            }
            level++;
        }
        return 0;
    }
}
