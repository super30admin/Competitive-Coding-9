import java.util.*;

public class WordLadder {
    /*
    Time Complexity : O(N * L * L * 26) -  One O(L) is due to the substring
    Space Complexity : O(N) for isVisited set and queue
    Approach :
    We will need to change the characters of begin word one by one, if the new word is present in the wordlist, we can
    add this to the queue and perform bfs. The new words formed by character change are the new level. As soon as the
    end word is reached we return the level, that is minimum of changes done to get to the end word.
    We need to maintain isVisited set to keep a check a word is not visited again.
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> set = new HashSet<>(wordList);
        Set<String> isVisited = new HashSet<>();

        // If begin word is same as end word. no change needed
        if (beginWord.equals(endWord)) return 0;

        // If the end word is not present in the wordList
        if (!set.contains(endWord)) return 0;

        int level = 1;
        isVisited.add(beginWord);
        while (!queue.isEmpty()) { //         O(N) words
            int levelSize = queue.size();
            while (levelSize > 0) {
                String parent = queue.poll();
                if (parent.equals(endWord)) return level;

                for (int i = 0; i < parent.length(); i++) {             // O(L)
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        // Avoid using the same letter in the parent
                        if (parent.charAt(i) == ch) continue;

                        String child = parent.substring(0, i) + ch + parent.substring(i + 1);
                        if (isVisited.contains(child)) continue;
                        if (!set.contains(child)) continue;
                        queue.add(child);
                        isVisited.add(child);
                    }
                }
                levelSize--;
            }
            level++;
        }

        return 0;
    }
    /*
Time Complexity : O(N * L * L)
Space Complexity :
Approach : We create a hashmap of the possible patterns by "*" each letter of a word present in the wordlist. So the key
will be the pattern and list of words are the words that follow that pattern. Starting with our start word, we can create
pattern by replacing each character with "*", then we can find other words that form same pattern from the map and add these to the
queue. These words form a level in the queue. As soon as the end word is reached, we return level as it is minimum length of the ladder.
We need to maintain isVisited set to keep a check a word is not visited again.

*/
    public int ladderLengthOptimized(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        Set<String> isVisited = new HashSet<>();

        // If begin word is same as end word. no change needed
        if (beginWord.equals(endWord)) return 0;

        // If the end word is not present in the wordList
        if (!set.contains(endWord)) return 0;
        Map<String, List<String>> patternWordMap = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < word.length(); i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> patternMatchedWords = patternWordMap.getOrDefault(pattern, new ArrayList<>());
                patternMatchedWords.add(word);
                patternWordMap.put(pattern, patternMatchedWords);
            }
        }

        queue.add(beginWord);
        isVisited.add(beginWord);
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String parent = queue.poll();
                if (parent.equals(endWord)) return level;

                for (int i = 0; i < parent.length(); i++) {
                    String pattern = parent.substring(0, i) + "*" + parent.substring(i + 1);
                    if (!patternWordMap.containsKey(pattern)) continue;
                    List<String> children = patternWordMap.get(pattern);
                    for (String child : children) {
                        if (isVisited.contains(child)) continue;
                        if (!set.contains(child)) continue;

                        queue.add(child);
                        isVisited.add(child);
                    }
                }
                size--;
            }
            level++;
        }
        return 0;
    }

}


