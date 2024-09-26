import java.util.*;
import javafx.util.Pair;


//word ladder
//tc- O(M^2 * N) M - length pf each word, N = number of words 
//sc - O(N) substring, queue, hashmap 
public class Problem2 {
    public static void main(String[] args){
        List<String> ls = new ArrayList<>();
        ls.add("hot");
        ls.add("dot");
        ls.add("lot");
        ls.add("log");
        ls.add("cog");
        Problem2 p = new Problem2();
        System.out.println(p.ladderLength("hit", "cog", ls));

    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> map = new HashMap<>();
        int len = beginWord.length();
        for(String word : wordList){
            for(int i = 0;i< len; i++){
                String new_word = word.substring(0, i) + '*'+word.substring(i+1, len);
                List<String> ls = map.getOrDefault(new_word,new ArrayList<>());
                ls.add(word);
                map.put(new_word, ls);

            }
            
        }
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(beginWord,1));
        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord,true);
        while(!q.isEmpty()){
            Pair<String, Integer> curr_pair = q.poll();
            String word = curr_pair.getKey();
            int level = curr_pair.getValue();
            for(int i = 0;i< len;i++){
                String new_word = word.substring(0,i) +"*"+ word.substring(i+1,len);
                for(String next_word : map.getOrDefault(new_word, new ArrayList<>())){
                    if(next_word.equals(endWord)){
                        return level+1;

                    }
                    if(!visited.containsKey(next_word)){
                        visited.put(next_word, true);
                        q.add(new Pair(next_word,level+1));
                    }


                }

            } 
        }
        return 0;

    }
    
}
