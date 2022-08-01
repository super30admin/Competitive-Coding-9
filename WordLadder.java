// Time Complexity : O(m*m*n), where m is the avg length of word and n is the number of words in dict
// Space Complexity : O(m*m*n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Yes, I wasn't able to think this far.

import java.util.*;

class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);

        int l = beginWord.length();
        for(String word : wordList){
            for(int j=0;j<word.length();j++){
                String str = word.substring(0,j)+'*'+word.substring(j+1,l);
                ArrayList<String> list = map.getOrDefault(str, new ArrayList<>());
                list.add(word);
                map.put(str, list);
            }
        }

        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        int level = 0;
        while(!q.isEmpty()){
            String word = q.poll();
            //String word = pair.getKey();
            level++;
            for(int i=0;i<l;i++){
                String newWord = word.substring(0,i)+'*'+word.substring(i+1,l);
                for(String adjword : map.getOrDefault(newWord, new ArrayList<>())){
                    if(adjword.equals(endWord)){
                        return level;
                    }
                    if(!visited.containsKey(adjword)){
                        visited.put(adjword, true);
                        q.add(adjword);
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String [] args){
        WordLadder wl = new WordLadder();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dog");
        list.add("lot");
        list.add("cog");
        list.add("log");
        list.add("dot");
        System.out.println(wl.ladderLength("hit","cog",list));
    }
}