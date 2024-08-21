// Time Complexity: O(N * M * 26) 
// where N is the number of words in the wordList, M is the length of each word, and 26 represents the number of possible character replacements.


// Space Complexity: O(N * M) 
// where N is the number of words in the wordList, and M is the length of each word, primarily due to the space used by the set and the queue.
class Solution {
    // Helper method to replace character at the given index with all possible characters
    private String replaceCharacter(String s, int index, char newChar) {
        char[] chars = s.toCharArray();
        chars[index] = newChar;
        return new String(chars);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Convert the word list to a HashSet for quick look-up
        HashSet<String> set = new HashSet<>(wordList);
        
        // If the end word is not in the set, return 0 as it's not reachable
        if (!set.contains(endWord)) {
            return 0;
        }

        // Initialize the queue for BFS and add the beginning word
        Queue<String> que = new LinkedList<>();
        que.add(beginWord);

        // Start from level 1 (beginWord itself is level 1)
        int level = 1;

        // Perform BFS
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                String currentWord = que.poll();
                
                // Iterate through each character position
                for (int j = 0; j < currentWord.length(); j++) {
                    char originalChar = currentWord.charAt(j);

                    // Replace the character at position j with all possible characters 'a' to 'z'
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) {
                            continue; // Skip if the character is the same as the original
                        }
                        
                        // Create a new word by replacing the character at position j
                        String newWord = replaceCharacter(currentWord, j, c);
                        
                        // If the new word matches the end word, return the current level + 1
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        // If the new word is in the set, add it to the queue and remove from set
                        if (set.contains(newWord)) {
                            que.add(newWord);
                            set.remove(newWord); // Remove to avoid revisiting
                        }
                    }
                }
            }
            // Increment the level after processing all words at the current level
            level++;
        }

        // If no transformation sequence exists, return 0
        return 0;
    }
}
