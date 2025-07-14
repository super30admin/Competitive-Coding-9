// Time complexity - O(n^2)
// Space complexity - O(n^2)
// Solved on leetcode - yes
// faced any issues - nO
// using BFS we are adding all possible words which are different from this word in the Queue and then Processing all the elements which are differenr by 1 character into the Queue
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                String word = queue.poll();
                
                for (int j = 0; j < word.length(); j++) {
                    char[] wordChars = word.toCharArray();
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordChars[j] = c;
                        String nextWord = new String(wordChars);
                        
                        if (nextWord.equals(endWord)) {
                            return level + 1;
                        }
                        
                        if (wordSet.contains(nextWord)) {
                            queue.offer(nextWord);
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
