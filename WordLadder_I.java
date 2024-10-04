import java.util.*;

// LC 127
public class WordLadder_I {

    /**
     * we have to find transformations from one word to another, i.e., an edge.
     * this implies an undirected graph.
     * also, each transformation is composed of a single letter, i.e., unit weighted edge
     * <p>
     * This boils down to find the shortest distance from source to destination in an undirected unit weighted graph
     * Apply BFS
     * <p>
     * NOTE: To prepare adj list, we have a-z possibilities at each index for each word.
     * <p>
     * TC: O(v+e) --> also incorporate the n strings created while preparing the adj list
     * SC: O(v)
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        // hash the words
        Set<String> words = new HashSet<>(wordList);
        // form the adjacency list
        //for each word, add edges to all possible single letter transformations
        Map<String, List<String>> adjList = new HashMap<>();
        for (String word : words) {
            getAdjList(word, len, words, adjList);
        }
        getAdjList(beginWord, len, words, adjList);

        Set<String> visited = new HashSet<>();
        Deque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(beginWord, 1));
        visited.add(beginWord);
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            for (String adj : adjList.get(curr.word)) {
                if (adj.equals(endWord)) {
                    return curr.level + 1;
                }
                if (visited.contains(adj)) {
                    continue;
                }
                visited.add(adj);
                q.offer(new Pair(adj, curr.level + 1));
            }
        }
        return 0;
    }

    private static void getAdjList(String word, int len, Set<String> words, Map<String, List<String>> adjList) {
        // single letter transformation for word
        List<String> adjs = adjList.computeIfAbsent(word, (key) -> new ArrayList<>());
        for (int i = 0; i < len; i++) {
            char[] word_ = word.toCharArray();
            char ch = word.charAt(i);
            // for i-th character we have 25 possibilities, except the i-th character itself
            for (int j = 0; j < 26; j++) {
                char ch_ = (char) (j + 'a');
                if (ch_ != ch) {
                    word_[i] = ch_;
                    String word__ = new String(word_);
                    if (words.contains(word__)) {
                        adjs.add(word__);
                    }
                }
            }
            word_[i] = ch;
        }
    }

    /**
     * Instead of preparing the adj list.
     * It's better to prepare the adjacent nodes only when required, i.e., while performing the BFS.
     * It saves time and space.
     * <p>
     * Moreover, no need to maintain a separate visited array.
     * Just remove visited words from the hashed dictionary as we're following BFS traversal, therefore, the shortest transformation will be visited first.
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public int ladderLength_2(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);

        Deque<Pair> queue = new ArrayDeque<>();
        words.remove(beginWord);
        queue.offer(new Pair(beginWord, 1));

        while (!queue.isEmpty()) {
            Pair pop = queue.poll();
            String word = pop.word;
            int level = pop.level;

            // N * word length * 26
            char[] replaceWord = word.toCharArray();
            for (int i = 0; i < word.length(); i++) {
                char ch = replaceWord[i];
                for (char a = 'a'; a <= 'z'; a++) {
                    replaceWord[i] = a;
                    String temp = new String(replaceWord);
                    if (word.equals(endWord)) {
                        return level;
                    }
                    if (words.contains(temp)) {
                        queue.offer(new Pair(temp, level + 1));
                        words.remove(temp);
                    }
                }
                replaceWord[i] = ch;
            }
        }

        return 0;
    }

    private class Pair {
        String word;
        int level;

        Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }
    }
}
