//time complexity - O(n*l)
//space complexity - O(n*l)
import java.util.*;
public class WordLadder {
    static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) {
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int len = 1;
        while (!q.isEmpty()) {
            int s = q.size();
            for (int i = 0; i < s; i++) {
                String curr = q.poll();
                char[] word = curr.toCharArray();
                for (int j = 0; j < word.length; j++) {
                    char org = word[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (word[j] == c) continue;
                        word[j] = c;
                        String newWord = new String(word);
                        if (newWord.equals(endWord)) return len + 1;

                        if (set.contains(newWord)) {
                            q.offer(newWord);
                            set.remove(newWord);
                        }
                    }
                    word[j] = org;
                }
            }
            len++;
        }
        return 0;
    }
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String >wordList = Arrays.asList("hot","dot","dog","lot","log","cog");

        System.out.println("Number of words: "+ ladderLength(beginWord, endWord, wordList));
    }
}
