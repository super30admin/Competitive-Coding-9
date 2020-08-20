class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>(wordList);
    Queue<String> queue = new LinkedList<>();
    queue.add(beginWord);
    int count = 1;
    while (!queue.isEmpty()) {
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            char[] current = queue.poll().toCharArray();
            for (int j = 0; j < current.length; j++) {
                char tmp = current[j];
                for (char c = 'a'; c <= 'z'; c++) {
                    current[j] = c;
                    String next = new String(current);
                    if (set.contains(next)) {
                        if (next.equals(endWord)) return count + 1;
                        queue.add(next);
                        set.remove(next);
                    }
                }
                current[j] = tmp;
            }
        }
        count++;
    }
    return 0;
}
}
