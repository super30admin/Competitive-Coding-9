// Time Complexity : O(M^2 * N)
// Space Complexity : O(M^2 * N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach
// we use bfs to solve this
// we iterate theough the wordlist and for each word we create relationship and store them in the map
// We add the begin word to q and also to the set to mark it as visited
// While the queue is not empty we poll and check if the word is endword otherwise we add all the related words to the queues and proceed with process

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord))
            return 0;
        HashMap<String, List<String>> map = new HashMap<>();
        List<String> temp;
        String modifiedWord;
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                modifiedWord = i + word.substring(0, i) + word.substring(i + 1, word.length());
                temp = map.getOrDefault(modifiedWord, new ArrayList<String>());
                temp.add(word);
                map.put(modifiedWord, temp);
            }
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int size;
        String word;
        int result = 0;
        HashSet<String> hs = new HashSet<>();
        hs.add(beginWord);
        while (!q.isEmpty()) {
            size = q.size();
            for (int i = 0; i < size; i++) {
                word = q.poll();
                if (word.equals(endWord))
                    return result + 1;
                for (int j = 0; j < word.length(); j++) {
                    modifiedWord = j + word.substring(0, j) + word.substring(j + 1, word.length());
                    if (map.containsKey(modifiedWord)) {
                        temp = map.get(modifiedWord);
                        for (String s : temp) {
                            if (!hs.contains(s))
                                q.add(s);
                            hs.add(s);
                        }
                        map.remove(modifiedWord);
                    }
                }
            }
            result++;
        }

        return 0;
    }
}