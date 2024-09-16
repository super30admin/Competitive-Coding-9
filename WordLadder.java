class pair{
    String word;
    int level;
    pair(String word,int level){
        this.word = word;
        this.level = level;
    }
}

/*
construct a adjacency list which consits of all the possible combinations of the words
in the wordlist. 
ex: *it, h*t, etc
Start the bfs from begin word by adding it to queue
and for each possible combination of the word, fetch the adjacency list from map and chck if its the endword, return the count. Else continue by adding node to the queue.
time complexity: O(n^2) + O(m^2)
space complexity: O(m^2 n)
*/
class Solution {
    HashMap<String,List<String>> dictionary;
        
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        int n = beginWord.length();
        
        this.dictionary = new HashMap<>();
        
        populateDictionary(wordList,n);
        
        Queue<pair>queue = new LinkedList<>();
        queue.add(new pair(beginWord,1));
        
        HashMap<String,Boolean> visited = new HashMap<>();
        visited.put(beginWord,true);
        
        while(!queue.isEmpty()){
            
            pair p = queue.poll();
            String word =p.word;
            int level = p.level;
            
            
            for(int i = 0; i< n;i++)
            {
                String newWord = word.substring(0,i)+"*"+word.substring(i+1,n);
                
                for(String neigh : dictionary.getOrDefault(newWord,new ArrayList<>())){
                    
                    if(neigh.equals(endWord)){
                        return level+1;
                    }
                    
                    if(!visited.containsKey(neigh)){
                         visited.put(neigh,true);
                        
                        queue.add(new pair(neigh,level+1));
                    }
              }
        }
            
        }
        return 0;
    }
    
    
    private void populateDictionary(List<String> wordList,int n){
         for(String word : wordList){
            for(int i =0;i < n ; i++){
                String newWord = word.substring(0,i)+"*"+word.substring(i+1,n);
                if(dictionary.containsKey(newWord)){
                    List<String>adjlist = dictionary.get(newWord);
                    adjlist.add(word);
                    dictionary.put(newWord,adjlist);
                }else{
                    List<String>adjlist = new ArrayList<>();
                    adjlist.add(word);
                    dictionary.put(newWord,adjlist);
                                   
                }
            }
        }
        
    }
    
    
}