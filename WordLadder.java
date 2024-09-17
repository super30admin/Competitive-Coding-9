// Time Complexity : O(N*L) N is number of words in wordList, L i Length of each word
// Space Complexity : O(max(map.size(), number of words in the map))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Tricky, learning it. (Not a Medium Problem for sure)

// BFS is the approach to solve the problem.
// Iterate over wordList and store all possible anagrams by placing a * in one digit in a map
// add the beginword to queue and start iterating over the queue.
// get the word from queue and iterate over the word's lenth and find the possible word formed by changing one digit and compare with the words in map
// if found add it to visited map for keeping as a check and add it to queue and increase the level (means we found one step)
// before adding to queue check if the word is our endword and return.


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int len = beginWord.length();

        for(String w : wordList) {
            for(int i=0; i<len; i++) {
                String word = w.substring(0,i)+'*'+w.substring(i+1,len);
                ArrayList<String> list = map.getOrDefault(word, new ArrayList<>());
                list.add(w);
                map.put(word,list);
            }
        }

        HashMap<String,Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        int level = 1;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                String word = q.remove();

                for(int j=0; j<len; j++) {
                    String newWord = word.substring(0,j)+'*'+word.substring(j+1,len);

                    for(String adjWord : map.getOrDefault(newWord, new ArrayList<>())) {

                        if(adjWord.equals(endWord)) return level+1;
                        if(!visited.containsKey(adjWord)) {
                            visited.put(adjWord,true);
                            q.add(adjWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}