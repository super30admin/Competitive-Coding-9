public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        
        HashMap<String, ArrayList<String>> relations = new HashMap<>();
        
        // Form the relations
        for(String str: wordList){
            for(int i=0;i<str.length();i++){
                String pattern = str.substring(0,i) + "*" + str.substring(i+1, str.length());
                if(!relations.containsKey(pattern)) relations.put(pattern, new ArrayList<>());
                
                relations.get(pattern).add(str);
            }
        }
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0;i<size;i++){
                String word = q.poll();
                // base case
                if(word.equals(endWord)) return level;
                
                for(int j=0;j<word.length();j++){
                    // getting all patterns of the word
                    String pattern = word.substring(0,j) + "*" + word.substring(j+1, word.length());
                    
                    // If map already has that pattern
                    if(relations.containsKey(pattern)){
                        // Getting all the words associated with that pattern
                        for(String str:relations.get(pattern)){
                            if(!visited.contains(str)){
                                visited.add(str);
                                q.add(str);
                            }
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}

// Time Complexity - O(n*k)
// Space Complexity - O(n)
