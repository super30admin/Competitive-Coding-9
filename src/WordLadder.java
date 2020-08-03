// time and space - O(L^2 * n) 

/*https://leetcode.com/problems/word-ladder/
 * */

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord)) {
            return 0;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        
        int l = beginWord.length();
        for(String word:wordList) {
            
            for(int i =0; i< l; i++) {
                String newWord = word.substring(0,i) + '*' + word.substring(i+1, l);
                
                List<String> temp = map.getOrDefault(newWord, new ArrayList<>());
                temp.add(word);
                map.put(newWord, temp);
            }
        }
        
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        
        while(!q.isEmpty()) {
            
            Pair<String, Integer> p = q.remove();
            
            String word = p.getKey();
            int level = p.getValue();
            
            for(int i=0; i<l;i++) {
                String newWord = word.substring(0,i) + "*" + word.substring(i+1, l);
                
                if(map.containsKey(newWord)){
                    
                    
                    for(String temp: map.get(newWord)) {
                        
                        if(temp.equals(endWord)) {
                            return level + 1;
                        }
                        
                        if(!visited.containsKey(temp)) {
                            visited.put(temp, true);
                            q.add(new Pair(temp, level+1));
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}