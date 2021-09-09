class Solution {

    class Pair {
        String word;
        int level;

        public Pair(String word, int level) {
            this.word = word;
            this.level = level;
        }

        public String getWord() {
            return this.word;
        }

        public int getLevel() {
            return this.level;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // preprocessing
        HashMap<String, List<String>> ref = new HashMap<>();
        for(String word : wordList) {
            StringBuilder sb = new StringBuilder();
            sb.append(word);
            for(int i = 0; i < word.length(); i++) {
                String key = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
                List<String> value;
                if(ref.containsKey(key)) {
                    value = ref.get(key);
                } else {
                    value = new ArrayList<>();
                }
                value.add(word);
                ref.put(key, value);
            }
        }

        // BFS
        Queue<Pair> q = new LinkedList<>();
        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        q.add(new Pair(beginWord, 1));

        while(!q.isEmpty()) {
            Pair curr = q.poll();
            String word = curr.getWord();
            int level = curr.getLevel();

            for(int i = 0; i < word.length(); i++) {
                String newWord = word.substring(0, i) + "*" + word.substring(i + 1, word.length());
                if(ref.containsKey(newWord)) {
                    List<String> adjacentWords = ref.get(newWord);
                    for(String w : adjacentWords) {
                        if(w.equals(endWord)) {
                            return level + 1;
                        }
                        if(!visited.containsKey(w)) {
                            q.add(new Pair(w, level + 1));
                            visited.put(w, true);
                        }
                    }
                }
            }
        }
        return 0;
    }
}