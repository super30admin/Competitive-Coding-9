// Time Complexity : O(nk*26) where n is the number of words and k is the length of the word
// Space Complexity : O(nk) to store the visited and words set
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Since we have to find the end word from start word with one letter change at every step, we have to find connected component using bfs.
 * We start with the word and try to update one character at every index to see if the word exists in the wordList.
 * If it does, then we can add it to the bfs queue to find matches in next level.
 * If it doesn't, then we discard the word and move to the next word.
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // adding to a set for O(k) lookup to check if the word exists in the original input
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord))
            return 0;

        // keeping visited so we don't have go back to the word that we have already done
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            //iterate through the words on current level
            for (int i = 0; i < size; i++) {
                String currWord = q.poll();

                // found the match so we can return the level
                if (currWord.equals(endWord))
                    return level;

                char[] chars = currWord.toCharArray();
                //Updating the character at jth index with all possible combinations
                for (int j = 0; j < chars.length; j++) {
                    char ch = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        // if the character is same as current word's character, then we can skip the word
                        if (ch == c)
                            continue;

                        chars[j] = c;
                        String newWord = new String(chars);
                        // if new word is from words list and not the one that we have already visited, add it to queue
                        if (words.contains(newWord) && !visited.contains(newWord)) {
                            q.add(newWord);
                            visited.add(newWord);
                        }
                    }
                    // putting the original character back
                    chars[j] = currWord.charAt(j);
                }
            }
            level++;
        }

        return 0;
    }
}