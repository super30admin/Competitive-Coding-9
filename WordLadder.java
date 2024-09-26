// Time Complexity :  O(26 * N * M) - M is the length of endWord 
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        
        q.offer(beginWord);
        int count = 1;
        while(!q.isEmpty()){
            
            int size = q.size();
            for(int i = 0; i < size; i++){
                char[] current = q.poll().toCharArray();
                for(int j = 0; j < current.length; j++){
                    char temp = current[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        current[j] = c;
                        String next = new String(current);
                        if(set.contains(next)){
                            if(next.equals(endWord)) return count + 1;
                            q.offer(next);
                            set.remove(next);
                        }
                    }
                    current[j] = temp;
                }
            }
            count++;
        }
        return 0;
    }
}