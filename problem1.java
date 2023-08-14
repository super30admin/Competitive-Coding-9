// Problem1- https://leetcode.com/problems/word-ladder/

// Time Complexity : O(N*M^2)
// Space Complexity :  O(N) * ( O(M)+O(M^2) )
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Nothing as such

class Problem1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        // converting to set as set remove() takes O(1) time while list remove() takes
        // O(n)
        HashSet<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) {
            return 0;
        }
        if (beginWord.equals(endWord)) {
            return 1;
        }

        queue.add(beginWord);
        int count = 1; // 1 for beginWord
        while (queue.size() > 0) {
            int size = queue.size();
            // for all words at current level
            for (int i = 0; i < size; i++) {
                char[] word = queue.poll().toCharArray();
                // we will replace each char one by one with [a,z] and check if it exists in our
                // dictionary
                for (int j = 0; j < word.length; j++) {
                    char tmp = word[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        word[j] = c;
                        String newWord = new String(word); // next word after replacing jth character
                        if (dict.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return count + 1;
                            }
                            queue.add(newWord);
                            dict.remove(newWord);
                        }
                    }
                    word[j] = tmp; // resetting to actual word for next iteration of inner for loop.
                }
            }
            // we have checked for all next words reachable from current queue, Hence
            count += 1;
        }
        // reaching here means we have not found endWord, yet return 0
        return 0;
    }
}