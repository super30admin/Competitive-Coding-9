//Time Complexity : O(M^2*N)
//Space Complexity : O(M*N)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, ArrayList<String>> dict = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) return 0; 

        int len = beginWord.length();

        for (String w : wordList) {
            for (int j = 0; j < len; j++) {
                String pattern = w.substring(0, j) + '*' + w.substring(j + 1);
                ArrayList<String> list = dict.getOrDefault(pattern, new ArrayList<>());
                list.add(w);
                dict.put(pattern, list);
            }
        }

        HashMap<String, Boolean> visited = new HashMap<>();
        q.add(beginWord);
        visited.put(beginWord, true);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();  
            for (int s = 0; s < size; s++) {
                String word = q.remove();

                for (int i = 0; i < len; i++) {
                    String pattern = word.substring(0, i) + '*' + word.substring(i + 1);
                    for (String adj : dict.getOrDefault(pattern, new ArrayList<>())) {
                        if (adj.equals(endWord)) return level + 1;
                        if (!visited.containsKey(adj)) {
                            visited.put(adj, true);
                            q.add(adj);
                        }
                    }
                }
            }
            level++; 
        }

        return 0;
    }
}
