//TC: O(m*n)
//SC: O(m*n)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Create a set of the wordList for fast lookup
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        // BFS setup
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int depth = 1;  // At the start, the transformation includes the beginWord itself.

        // Set to track visited words
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Size of the current level in BFS
            
            // Process all nodes (words) at the current level
            for (int i = 0; i < levelSize; i++) {
                String currentWord = queue.poll();
                
                // If we reach the endWord, return the number of transformations (depth)
                if (currentWord.equals(endWord)) {
                    return depth;
                }

                // Try transforming the current word by changing one letter at a time
                for (String neighbor : getNeighbors(currentWord, wordSet)) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }

            // After processing the current level, increment the depth
            depth++;
        }

        return 0;  // No valid transformation sequence
    }

    // Helper function to find all valid neighbors (words that differ by 1 character)
    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] wordArray = word.toCharArray();

        for (int i = 0; i < wordArray.length; i++) {
            char originalChar = wordArray[i];

            // Try replacing each letter with 'a' to 'z'
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) continue;

                wordArray[i] = c;
                String newWord = new String(wordArray);

                if (wordSet.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }

            // Restore the original character
            wordArray[i] = originalChar;
        }

        return neighbors;
    }
}
