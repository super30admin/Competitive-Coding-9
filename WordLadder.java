// TC: O( N * L * 26) N = len(wordList) L = length of word
// SC: O(N) N = len(wordList)

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int steps = 1;
        Queue<String> bfs = new LinkedList<>();
        HashSet<String> set = new HashSet<>(wordList); // O(n)
        HashSet<String> visited = new HashSet<>();
        if (!set.contains(endWord))
            return 0;

        char[] az = new char[26];
        for (int i = 0; i < 26; i++) {
            az[i] = (char) ('a' + i);
        }

        bfs.add(beginWord);
        visited.add(beginWord);

        while (!bfs.isEmpty()) {
            int size = bfs.size();

            for (int j = 0; j < size; j++) {
                String curr = bfs.poll();
                StringBuilder sb = new StringBuilder(curr);

                for (int i = 0; i < curr.length(); i++) {
                    char original = curr.charAt(i);
                    for (char alphabate : az) {

                        // action
                        sb.setCharAt(i, alphabate);
                        String updated = sb.toString();
                        if (set.contains(updated) && !visited.contains(updated)) {
                            if (updated.equals(endWord)) {
                                return steps + 1;
                            }
                            bfs.add(updated);
                            visited.add(updated);
                        }
                        // backtack replacement
                        sb.setCharAt(i, original);
                    }
                }
            }
            steps++;
        }

        return 0;
    }
}