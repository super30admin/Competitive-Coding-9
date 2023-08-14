import java.util.*;

/*
Word-Ladder
approach: first convert the problem to BFS shortest path, create an adjacency list of all 1 character differing strings, do a bfs on neighbors
time: adjacency list creation: O(n*(m^2)) where m is len of given word, BFS: O((n^2)*m)
space: O(len(wordList)*(len(word)) and O(len(wordList)) for queue
 */
public class Problem2 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();

        for (String st:wordList) {
            for (int j=0;j<st.length();j++) {
                String pre = st.substring(0, j);
                String suf = st.substring(j+1, st.length());
                List<String> list = map.getOrDefault(pre+'*'+suf, new ArrayList<>());
                list.add(st);
                map.put(pre+'*'+suf, list);
            }
        }

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int res = 1;
        while (!q.isEmpty()) {

            int size = q.size();
            while(size>=1) {
                String curWord = q.poll();
                if (curWord.equals(endWord)) return res;
                for (int j=0;j<curWord.length();j++) {
                    String pre = curWord.substring(0, j);
                    String suf = curWord.substring(j + 1, curWord.length());
                    if (map.containsKey(pre+'*'+suf))
                        for (String neihbor: map.get(pre+'*'+suf)) {
                            if (!visited.contains(neihbor)) {
                                q.add(neihbor);
                                visited.add(neihbor);
                            }
                        }
                }
                size--;
            }
            res++;
        }

        return 0;
    }
    public static void main(String []args) {
        Problem2 problem2 = new Problem2();
        problem2.ladderLength("hit", "cog", Arrays.asList("hot","dot","dog","lot","log","cog"));
    }
}
