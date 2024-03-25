import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Word_Ladder {
    //TC: O(n*m^2)
    //SC: O(m*n^2)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hs = new HashSet<>();
        for(String word: wordList){
            hs.add(word);
        }
        if (!hs.contains(endWord) ) {
            return 0;
        }
        Queue<String > qu = new LinkedList<>();
        qu.add(beginWord);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        int level = 1;
        while(!qu.isEmpty()){
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                String curr_word = qu.poll();
                if (curr_word.equals(endWord)) {
                    return level;
                }
                char[] compare_char = curr_word.toCharArray();
                for (int j = 0; j < compare_char.length; j++) {
                    char original_char = compare_char[j];
                    for(char c = 'a'; c <= 'z'; c++) {
                        if(c == original_char) continue;
                        compare_char[j] = c;
                        String string = new String(compare_char);
                        if (hs.contains(string) && !visited.contains(string)) {
                            qu.add(string);
                            visited.add(string);
                        }
                    }
                    compare_char[j] = original_char;
                }
            }
            level++;
        }
        return 0;
    }
}
