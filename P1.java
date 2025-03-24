/*
Time Complexity (TC): O(M × N), where M is the word length and N is the number of words in wordList,
as each word transformation is checked against all words.

Space Complexity (SC): O(M × N) due to storing words in the queue and the HashSet for fast lookup.
 * 
 * The algorithm uses BFS to find the shortest transformation sequence from beginWord to endWord, 
 * changing one letter at a time while ensuring the new word exists in wordList. 
 * At each level, it explores all possible one-letter transformations, adds valid words to the queue, and stops when endWord is found. 
 * The HashSet prevents revisiting words, ensuring efficiency.
 */

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0; // Check if endWord exists in wordList

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int cnt = 1;  // Start counting from 1 since beginWord itself is a level

        Set<String> s = new HashSet<>(wordList);
        s.remove(beginWord); // Remove beginWord to avoid revisiting it

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String str = q.poll();
                char[] array = str.toCharArray();
                for (int j = 0; j < array.length; j++) {
                    char original = array[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (original == k) continue; // Skip same character replacement
                        
                        array[j] = k;
                        String newStr = new String(array);

                        if (newStr.equals(endWord)) return cnt + 1; // Return count when found

                        if (s.contains(newStr)) {
                            q.add(newStr);
                            s.remove(newStr);
                        }
                    }
                    array[j] = original; // Restore original character
                }
            }
            cnt++; // Increase level count
        }
        return 0;
    }
}

