class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Map<String, List<String>> dict = new HashMap<>();
        int len = beginWord.length();

        // Build pattern dictionary
        for (String word : wordList) {
            for (int i = 0; i < len; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                dict.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(beginWord, 1));

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while (!q.isEmpty()) {
            Pair<String, Integer> node = q.poll();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < len; i++) {
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                List<String> adjacentWords = dict.getOrDefault(pattern, new ArrayList<>());

                for (String adjWord : adjacentWords) {
                    if (adjWord.equals(endWord)) {
                        return level + 1;
                    }
                    if (!visited.contains(adjWord)) {
                        visited.add(adjWord);
                        q.add(new Pair<>(adjWord, level + 1));
                    }
                }
            }
        }

        return 0;
    }
}
