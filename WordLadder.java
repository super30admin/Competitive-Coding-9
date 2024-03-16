class Solution {
    //TC: O(m*m*l) n,m length of beginword and endword
    //sc: O(l) l -length of the wordlist
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>(wordList);

        q.add(beginWord);
        int level = 1;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i <size; i++){
                String curr = q.poll();
                if(curr.equals(endWord)) return level;
                for(int j = 0; j < curr.length(); j++){
                    char c[] = curr.toCharArray();
                    for(char ch = 'a'; ch <='z';ch++){
                        c[j] = ch;
                        String nextWord = new String(c);
                        if(set.contains(nextWord)){
                            set.remove(nextWord);
                            q.add(nextWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
