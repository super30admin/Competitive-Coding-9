//TC: O(n*l), n is no of words in wordList, l is length of each word
//SC: O(n)
//approach: bfs for exploring all possible next words
// and hashing to make searching if next word we created is there in the wordlist or not, a constant time operation

import java.util.*;

public class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Boolean> wordMap = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        for(String word:wordList){
            wordMap.put(word, false);
        }
        if(!wordMap.containsKey(endWord)) return 0;

        q.add(beginWord);
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size;i++){
                String word = q.poll();
                char[] wordArray = word.toCharArray();
                for(int j =0; j<wordArray.length; j++){
                    char tc = wordArray[j];
                    for(int k =  0; k<26;k++ ){
                        char c = (char) ('a' + k);
                        wordArray[j] = c;
                        String newWord = new String(wordArray);
                        if(newWord.equals(endWord)) return level+1;

                        if(wordMap.containsKey(newWord) && !wordMap.get(newWord)){
                            q.add(newWord);
                            wordMap.put(newWord, true);
                        }
                    }
                    wordArray[j] = tc;
                }

            }
            level++;
        }
        return 0;

    }
}
