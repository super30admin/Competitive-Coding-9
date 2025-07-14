import java.util.*;
import java.util.LinkedList;

//Time Complexity: O(n * m * 26) where n is the number of words in the wordList and m is the length of each word
//Space Complexity: O(n) where n is the number of words in the wordList
//LeetCode Problem: 127. Word Ladder

//Intuition: We can use BFS to find the shortest path from the beginWord to the endWord
// We will find the intermediate strings that can be formed by changing one letter at a time and 
// this will take m * 26 time where m is the length of each word, and we'll do this for each word in the wordList
// We will use a queue to keep track of the words we need to process and a set to keep track of the words we have already processed

public class WordLadder {
    HashSet<String> set;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == null || endWord == null || wordList == null || wordList.size() == 0)
            return 0;
        int length = 0;
        set = new HashSet(wordList);
        Queue<String> queue = new LinkedList();
        set.remove(beginWord);
        queue.add(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.remove();
                List<String> neighbors = neighborWords(currentWord);
                if (currentWord.equals(endWord))
                    return length + 1;
                for (String neighbor : neighbors) {
                    if (set.contains(neighbor)) {
                        set.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
            length++;
        }
        return 0;
    }

    public List<String> neighborWords(String currentWord) {
        List<String> possibleWordsToMatch = new ArrayList<>();

        char[] chars = currentWord.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char temp = chars[i];

            for (char ch = 'a'; ch <= 'z'; ch++) {
                chars[i] = ch;
                String newWord = new String(chars);
                if (set.contains(newWord)) {
                    possibleWordsToMatch.add(newWord);
                }
            }
            chars[i] = temp;
        }

        return possibleWordsToMatch;
    }
}