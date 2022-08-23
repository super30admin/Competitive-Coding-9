// TC : O(m^2*n)
// SC : O(m^2*n)
// m : word length, n = number of words
// BFS APPROACH

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);

        Queue<String> q = new LinkedList<>();

        q.add(beginWord);

        int level = 1;

        while (!q.isEmpty()) {
            level++;
            
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                String curr = q.poll();

                char[] temp = curr.toCharArray();
                for (int j = 0; j < temp.length; j++) {
                    for (int k = 0; k < 26; k++) {
                        temp[j] = (char) (k + 'a');
                        String key = new String(temp);
               
                        if (set.contains(key) && key.equals(endWord)) {
                            return level;
                        }
                     
                        if (set.contains(key)) {
                            q.add(key);
                            set.remove(key);
                        }
                    }
                    temp[j] = c;
                }

            }
        }
        return 0;
    }
}