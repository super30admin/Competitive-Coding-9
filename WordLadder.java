// Time Complexity : O((m^2) * n), where m is the length of each word and n is the total number of words in the input word list
// Space Complexity : O((m^2) * n)
// Did this code successfully run on Leetcode (127): Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // create a graph
        HashMap<String, ArrayList<String>> dict = new HashMap<>();
        int len = beginWord.length();
        for (String word : wordList) {
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, len);
                ArrayList<String> list = dict.getOrDefault(newWord, new ArrayList<>());
                list.add(word);
                dict.put(newWord, list);
            }
        }
        
        // create a map for visited words
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        
        // create a queue for BFS
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        
        // iterate over the queue
        while (!q.isEmpty()) {
            Pair<String, Integer> pair = q.remove();
            String word = pair.getKey();
            int level = pair.getValue();
            
            for (int i = 0; i < len; i++) {
                String newWord = word.substring(0, i) + '*' + word.substring(i+1, len);
                for (String adjWord : dict.getOrDefault(newWord, new ArrayList<>())) {
                    if (adjWord.equals(endWord)) return level + 1;
                    if (!visited.containsKey(adjWord)) {
                        visited.put(adjWord, true);
                        q.add(new Pair(adjWord, level+1));
                    }
                }
            }
        }
        return 0;
    }
}