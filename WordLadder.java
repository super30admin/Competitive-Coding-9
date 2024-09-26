/**
 * Time Complexity : O(m^2*n) where m is the number of characters and n is the number of words
// Space Complexity : O(m^2*n + v)  where m is the number of characters and n is the number of words in the Graph (HashMap) and v words in the visited set
 */
import java.util.*;
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null){return 0;}
        HashMap<String, ArrayList<String>> store = new HashMap<>();                                           
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<String>();                                                             
        int length = beginWord.length();
        for(String s: wordList){
            for(int j = 0; j < length; j++){
                String w = s.substring(0,j) + "*" + s.substring(j+1, length);                                       
                    ArrayList<String> str = store.getOrDefault(w, new ArrayList<String>());
                    str.add(s);
                    store.put(w, str);
                }
            }
        System.out.println(store);
        q.add(beginWord);
        int level  = 0;
        visited.add(beginWord);                                                                                 
        while(!q.isEmpty()){
              level++;                                                                                          
              int size = q.size();
              for(int j = 0; j < size; j++){                                                                            
              String word = q.poll();
              if(word.equals(endWord)){return level;}
              for(int i =0 ; i < length; i++){
              String wrd = word.substring(0,i)+ "*"+word.substring(i+1, length);                                    
              for(String w1 : store.getOrDefault(wrd, new ArrayList<>())){                                     
                  if(!visited.contains(w1)){
                      visited.add(w1);                                                                              
                      q.add(w1);                                                                                    
                  }
              }
              }
              }
          }  
        return 0;                                                                                                   
    }
}