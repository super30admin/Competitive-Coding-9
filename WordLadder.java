// Time Complexity : O(m^2 * n), m is word length, n is length of wordList
// Space Complexity : O(m * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : NA


// Your code here along with comments explaining your approach


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        
        Set<String> set = new HashSet<>(wordList);
        
        if(!set.contains(endWord)) {
            return 0;
        }
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        int count = 1;
        
        while(!q.isEmpty()) {
            
            int size = q.size();
            
            for(int i = 0; i < size; i++) {
                
                String curr = q.poll();
                if(curr.equals(endWord)) {
                    return count;
                }
                
                for(int j = 0; j < curr.length(); j++) {
                    for(int k = 0; k < 26; k++) {
                        char[] wordArray = curr.toCharArray();
                        wordArray[j] = (char) ('a' + k); 
                        String str = new String(wordArray);
                        
                        if(set.contains(str) && !visited.contains(str)) {
                            q.add(str);
                            visited.add(str);
                        }
                    }
                    
                }
            }
            count++;
        }
        return 0;
    }
}