// Problem 127. Word Ladder
// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // If the endWord is not in the wordList, return 0 early
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        int len = 1;
        int wordLen = beginWord.length();
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> nextLevel = new HashSet<>();
            for (String word : beginSet) {
                char[] wordChars = word.toCharArray();
                for (int i = 0; i < wordLen; i++) {
                    char originalChar = wordChars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[i] = c;
                        String newWord = new String(wordChars);
                        // If the other set contains the word, return the answer
                        if (endSet.contains(newWord)) {
                            return len + 1;
                        }
                        // If the new word is in the wordSet and hasn't been visited yet
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            nextLevel.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    wordChars[i] = originalChar;  // Restore original character
                }
            }
            // Move to the next level of the BFS
            beginSet = nextLevel;
            len++;
        }
        return 0;
    }
}
