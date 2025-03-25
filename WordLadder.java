// Time Complexity: O(N * M * 26) where N is the number of words in the wordList and M is the length of the word
// Space Complexity: O(N) where N is the number of words in the wordList
import java.util.*;

class WordLadder {

    class Pair {
        String first;
        int second;

        Pair(String first, int second) {
            this.first = first;
            this.second = second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();

        for(int i = 0; i < wordList.size(); i++){
            set.add(wordList.get(i));
        }

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(beginWord, 1));

        while(!queue.isEmpty()){
            Pair elem = queue.poll();
            String word = elem.first;
            int step = elem.second;

            if(word.equals(endWord)){
                return step;
            }

            for(int i = 0; i < word.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] replacementWord = word.toCharArray();
                    replacementWord[i] = ch;

                    String fullWord = new String(replacementWord);


                    if(set.contains(fullWord)){
                        set.remove(fullWord);
                        queue.add(new Pair(fullWord, step+1));
                    }
                }
            }
        }
        return 0;
    }
}
