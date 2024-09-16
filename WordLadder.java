class WordLadder {

    /**
     * Time complexity: O(N*M^2) where N is number of words and N is length of the word
     * Space complexity: O(N*M^2) where N is number of words and N is length of the word
     */

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(wordList == null || wordList.size() == 0 || beginWord.length() != endWord.length())
            return 0;
        
        Map<String, List<String>> map = new HashMap<>();
        
        for(String word : wordList) {
            int length = word.length();
            
            for(int i=0; i<length; i++) {
                String str = word.substring(0, i) + "*" + word.substring(i+1, length);
                
                List<String> list = map.getOrDefault(str, new ArrayList<String>());
                list.add(word);
                map.put(str, list);
            }
        }
        
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        
        while(!q.isEmpty()) {
            Pair<String, Integer> p = q.remove();
            String curr = p.getKey();
            int level = p.getValue();
            for(int i=0; i<curr.length(); i++) {
                String str = curr.substring(0, i) + "*" + curr.substring(i+1, curr.length());
                
                List<String> list = map.getOrDefault(str, new ArrayList<>());
                for(String adj : list) {
                    if(adj.equals(endWord)){
                        return level+1;
                    }
                    
                    if(!visited.containsKey(adj)) {
                        visited.put(adj, true);
                        q.add(new Pair(adj, level+1));
                    } 
                }
            }
        }
        
        return 0;
    }
}