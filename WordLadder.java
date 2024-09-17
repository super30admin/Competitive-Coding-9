// Time Complexity : O(M^2 * N),
// Space Complexity : O(M^2 * N),
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList.size() == 0)
            return 0;

        HashMap<String, List<String>> map = new HashMap<>();
        int changes = 1;

        //Add all the possible combinations in the dictionary.i.e., create an adjacency list
        for(String s: wordList){
            int len = s.length();

            for(int i=0; i<len; i++){
                String tempWord = s.substring(0,i) + "?" + s.substring(i+1);
                if(!map.containsKey(tempWord))
                    map.put(tempWord, new ArrayList<>());

                map.get(tempWord).add(s);
            }
        }

        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        q.add(beginWord);

        while(!q.isEmpty()){ // T.C - O(M^2 * N) , S.C - O(M^2 * N)
            int size = q.size();
            for(int k=0; k<size; k++){
                String temp = q.poll();
                if(temp.equals(endWord)) return changes;

                for(int i=0; i<temp.length(); i++){
                    String newWord = temp.substring(0,i) + "?" + temp.substring(i+1);
                    if(map.containsKey(newWord)){
                        List<String> list = new ArrayList<>(map.get(newWord));
                        for(int j=0; j<list.size(); j++){
                            if(!visited.contains(list.get(j))){
                                q.add(list.get(j));
                                visited.add(list.get(j));
                            }
                        }
                    }
                }

            }
            ++changes;
        }

        return 0;
    }
}

