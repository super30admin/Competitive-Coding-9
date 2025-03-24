// https://leetcode.com/problems/word-ladder/

// Time Complexity : O(nxlxl) 
// Space Complexity : O(nxl)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Add the patterns and word to hashmap. Maintain a queue and set to add words visited. Add beginword in both and iterate until the queue is not empty
 * For each iteration take the size and iterate until the size. Take the curr as q.poll and iterate until the length of the word and take pattern of
 * this word and check if it is there in hashmap, if yes and that word is equals to endword return level+1, if not check if the word is in visited,
 * if not add it to visited and to queue and increase level by 1.
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.length() != endWord.length()) return 0;
        HashMap<String, List<String>> map = new HashMap<>();
        for(String word: wordList){
            for(int i = 0; i < beginWord.length(); i++){
                String sub = word.substring(0,i) + "*"+ word.substring(i+1);
                if(!map.containsKey(sub)){
                    map.put(sub, new ArrayList<>());
                }
                map.get(sub).add(word);
            }
        }
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                for(int j = 0; j<beginWord.length();j++){
                    String pattern = curr.substring(0, j) + "*" + curr.substring(j+1);
                    for(String match: map.getOrDefault(pattern, new ArrayList<>())){
                        if(match.equals(endWord)){
                            return level+1;
                        }
                        if(!visited.contains(match)){
                            visited.add(match);
                            q.add(match);
                        }

                    }
                }
            }
            level++;
        }
        return 0;
    }
}