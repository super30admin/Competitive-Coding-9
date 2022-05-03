//Time Complexity O(M^N)
//Space Complexity O(M^N)
//Leetcode tested

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> wordSet = new HashSet<>(wordList);
        return bfs(beginSet,endWord,wordSet,1);
    }
    int bfs(Set<String> beginSet,String endWord,Set<String> wordSet,int distance){
        Set<String> reachableSet = new HashSet<>();
        wordSet.removeAll(beginSet);

        for (String word:beginSet) {
            for (int i = 0; i < word.length(); i++) {
                char[] charArray = word.toCharArray();
                for (char c='a';c<='z';c++) {
                    charArray[i] = c;
                    String newWord = new String(charArray);
                    if(wordSet.contains(newWord)){
                        if(newWord.equals(endWord)) return distance+1;
                        reachableSet.add(newWord);
                    }
                }
            }
        }
        if(reachableSet.isEmpty()) return 0;
        distance++;
        return bfs(reachableSet,endWord,wordSet,distance);
    }
}
