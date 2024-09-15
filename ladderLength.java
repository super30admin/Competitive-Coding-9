// Time Complexity : O(m*m*n)
// Space Complexity : O(m*m*n)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
 
        Set<String> set = new HashSet(wordList);
        Queue<String> q = new LinkedList();
        
        q.add(beginWord);
        int ct = 1;
        while(!q.isEmpty()) {
            
            int s = q.size();
            
            while(s>0) {
            
                String curr = q.poll();
                
                for(int i = 0;i<curr.length();i++) {
                    
                    char[] temp = curr.toCharArray();
                    
                    for (char c = 'a'; c <= 'z'; c++) { 
                        temp[i] = c;
                        String newWord = new String(temp);
                        
                        if(set.contains(newWord)) {
                            if(newWord.equals(endWord)) return ct+1;
                            q.add(newWord);
                            set.remove(newWord);   
                        }
                    }
                    
                }
                
                s--;
            }
            ct++;
            
        }
            
        return 0;
    }
}
