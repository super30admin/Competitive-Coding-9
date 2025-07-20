/*
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
Time Complexity -O(N*L) where N- number of words in wordList and L- length of word
Space Complexity - O(N*L) where N- number of words in wordList and L- length of word
 */
import java.util.*;
public class WordLadder_LC_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<Pair> q = new LinkedList<>();
        int len = wordList.size();
        q.add(new Pair(beginWord,1));

        Set<String> st = new HashSet<>();
        for(int i =0; i<wordList.size(); i++){
            st.add(wordList.get(i));
        }
        st.remove(beginWord);
        while(!q.isEmpty()){
            String word = q.peek().word;
            int dist = q.peek().dist;
            q.remove();
            if(word.equals(endWord) == true) return dist;
            for(int i= 0; i<word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char replaceCharArray[] = word.toCharArray(); //hit
                    replaceCharArray[i] = ch;// replace one by one character
                    String replacedWord = new String(replaceCharArray);
                    if(st.contains(replacedWord) == true){
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, dist+1));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair{

    String word;
    int dist;
    Pair(String word, int dist){
        this.word = word;
        this.dist = dist;
    }

}