// Time Complexity : O(N * L * 26) where N is the number of words and L is the word length
// Space Complexity : O(N) for the queue and visited set
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use BFS because we need the shortest transformation sequence from beginWord to endWord.
// For each word, we generate all possible one-character transformations and enqueue valid dictionary words.
// The BFS level represents the current transformation length, so the first time we reach endWord is the answer.

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);

        // endWord must exist in dictionary
        if(!set.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        int level = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int s = 0; s < size; s++) {
                String word = queue.poll();

                if(word.equals(endWord)) {
                    return level;
                }

                char[] arr = word.toCharArray();

                // generate all one-letter transformations
                for(int i = 0; i < arr.length; i++) {
                    char original = arr[i];

                    for(char c = 'a'; c <= 'z'; c++) {
                        arr[i] = c;

                        String next = new String(arr);

                        if(set.contains(next)) {
                            queue.add(next);
                            set.remove(next);
                        }
                    }

                    arr[i] = original;
                }
            }

            level++;
        }

        return 0;
    }
}