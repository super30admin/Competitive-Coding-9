import java.util.*;

public class WordLadder {
    // TC: O(N * M * M) where N is number of words in wordList, M is length of each word
    // SC: O(N * M * M) where N is number of words in wordList, M is length of each word
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> dictionary = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        queue.add(beginWord);
        int depth = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                if (curr.equals(endWord)) {
                    return depth;
                }
                char[] currArray = curr.toCharArray();
                for (int k = 0; k < currArray.length; k++) {
                    char temp = currArray[k];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        currArray[k] = ch;
                        String neighbor = new String(currArray);
                        if (dictionary.contains(neighbor) && !visited.contains(neighbor)) {
                            queue.add(neighbor);
                            visited.add(neighbor);
                        }
                    }
                    currArray[k] = temp;
                }
            }
            depth++;
        }
        return 0;
    }
}
