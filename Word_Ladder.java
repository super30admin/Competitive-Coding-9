
//Time Complexity :- O(M^2 * N), where M is size of dequeued word & N is size of our word list
// Space Complexity :- O(N)  N is size of our word list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> q  = new LinkedList<>();
        int n = beginWord.length();
        q.add(beginWord);
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        int count = 1;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                 String curr = q.poll();
                 if(curr.equals(endWord)) return count;
                 
                 for(int j=0; j<n; j++){
                    for(int k = 0; k < 26; k++){
                        char arr[] = curr.toCharArray();
                        arr[j] = (char) ('a' + k); 
                        String str = new String(arr);
                        
                        if(set.contains(str) && !visited.contains(str)){
                            q.add(str);
                            visited.add(str);
                        }
     
                    }
                    
                }
                
                      
                }
                
               ++count;
            }
            
            return 0;
            
        }
        
        
        

}
