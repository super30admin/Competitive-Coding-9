//Time: (M^2 x N)
//Space: (M^2 x N)

public class wordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            StringBuilder sb;
            for (int i = 0; i < word.length(); i++) {
                sb = new StringBuilder(word);
                sb.setCharAt(i, '*');
                String hashString = sb.toString();
                List<String> list = map.getOrDefault(hashString, new ArrayList<>());
                list.add(word);
                map.put(hashString, list);
            }
        }

        //BFS
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        Set<String> visited = new HashSet<>();
        int count = 1;
        while (!queue.isEmpty()) {
            int last = queue.size();
            while (last-- > 0) {
                String word = queue.poll();
                if(word.equals(endWord)) return count;
                for (int i = 0; i < word.length(); i++) {
                    StringBuilder sb = new StringBuilder(word);
                    sb.setCharAt(i, '*');
                    if (!visited.contains(sb.toString())) {
                        List<String> list = map.getOrDefault(sb.toString(), new ArrayList<>());
                        if (!list.isEmpty()) {
                            for (String el : list) {
                                queue.add(el);
                            }
                        }
                    }
                    visited.add(sb.toString());
                }
            }
            count++;
        }
        return 0;
    }
}
