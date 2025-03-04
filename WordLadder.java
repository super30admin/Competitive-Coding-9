import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Time Complexity: O(n)
// Space Complexity: O(n)

public class WordLadder {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {

            if(wordList == null || wordList.size() ==0 || beginWord == null || endWord == null || !wordList.contains(endWord)){
                return 0;
            }

            Queue<String> q = new LinkedList<>();
            boolean[] visited = new boolean[wordList.size()];
            int count=0;

            q.add(beginWord);
            while(!q.isEmpty()){
                int size = q.size();
                if(size > 0){
                    count++;
                }
                for(int i=0;i<size;i++){
                    String str = q.poll();
                    System.out.println("str "+str);
                    HashMap<String, Integer> matches = getWordsWithDiffOne(str, wordList);
                    for(String s : matches.keySet()){
                        if(!visited[matches.get(s)]){
                            // System.out.println("index "+matches.get(s));
                            // System.out.println("count "+count);
                            if(s.equals(endWord)){
                                count++;
                                return count;
                            }
                            q.add(s);
                            visited[matches.get(s)] = true;
                            //wordList.remove(s);
                        }
                    }
                }
            }
            return 0;
        }

        public HashMap<String, Integer> getWordsWithDiffOne(String s, List<String> wordList){
            HashMap<String, Integer> hmap = new HashMap<>();
            for(int i=0;i< wordList.size();i++){
                if(compareWord(s, wordList.get(i)) == 1){
                    hmap.put(wordList.get(i), i);
                }
            }
            return hmap;
        }

        public int compareWord(String s, String word){
            int diff=0;
            int n = s.length();
            for(int i=0;i<n;i++){
                if(s.charAt(i) != word.charAt(i)){
                    diff++;
                }
            }
            return diff;
        }

    }
}
