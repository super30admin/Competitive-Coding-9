// tc: o(26 * n ^ 2 * w) where n is len of each word w is number of words
// sc: 
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> myset = new HashSet<>(wordList);
        if(!myset.contains(endWord))
            return 0;
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int depth = 0;
        
        while(!q.isEmpty()) {
            depth += 1;
            int size = q.size();
            while(size > 0) {
                String cur = q.poll();
                for(int i = 0; i < cur.length(); i++) {
                    StringBuilder temp = new StringBuilder(cur);
                    for(char c = 'a'; c <= 'z'; c++) {
                        temp.setCharAt(i, c);
                        if(temp.toString().equals(cur)) continue;
                        if(temp.toString().equals(endWord)) return depth + 1;
                        if(myset.contains(temp.toString())) {
                            q.add(temp.toString());
                            myset.remove(temp.toString());
                        }          
                }
            }
            size--;
        }
    }
    return 0;
}
}