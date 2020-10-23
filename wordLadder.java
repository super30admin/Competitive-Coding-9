import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
     
        int L = wordList.get(0).length();
        HashMap<String, List<String>> combDict = new HashMap<>();
        
        wordList.forEach(word -> {
            for(int i =0; i < L ;i++){
                
                String newWord = word.substring(0, i) + "*" + word.substring(i+1, L);
                List<String> transformations = combDict.getOrDefault(newWord, new ArrayList<>());
                transformations.add(word);
                combDict.put(newWord, transformations);
            } 
        }); // do *, do* - d - og, dot *og
        
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        q.add(new Pair(beginWord, 1));
        visited.add(beginWord);
        int level = 1;
        
        while(!q.isEmpty()){
        
            Pair<String, Integer> pair = q.poll();
            String word = pair.getKey();
            level = pair.getValue();
            for(int i = 0; i < L ; i++){
                
                String newWord = word.substring(0, i) + "*" + word.substring(i+1, L);
                List<String> list = combDict.get(newWord);
                System.out.println(list);
                
                for(String adjWord: combDict.getOrDefault(newWord, new ArrayList<>())){
                    
                    if(adjWord.equals(endWord)){
                        return level+1;
                    }
                    
                    if(!visited.contains(adjWord)){
                        visited.add(adjWord);
                        q.add(new Pair(adjWord, level+1));   
                    }
                }
                
            }
        }
        
        return 0;
    }
}