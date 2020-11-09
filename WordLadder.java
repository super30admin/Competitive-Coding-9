// Time Complexity : O(M^2 * N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
// BFS
class Solution {
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord==null || endWord==null || beginWord.equals(endWord)){
            return 0;
        }
        
        Queue<Pair<String, Integer>> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        
        while(!q.isEmpty()){
            Pair<String, Integer> curr = q.remove();
            String currWord = curr.getKey();
            int length = curr.getValue();
            
            ListIterator<String> iterator = wordList.listIterator();
            while(iterator.hasNext()){
                String wordDic = iterator.next();
                if(isAdjacent(wordDic, currWord)){
                    iterator.remove();
                    q.add(new Pair(wordDic, length+1));
                    if(wordDic.equals(endWord)){
                        return length + 1;
                    }
                }
            }      
        }
        return 0;  
    }
    
    public boolean isAdjacent(String s1, String s2){
        int count = 0;
        for(int i =0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                count++;
                if(count>1) return false;
            }
        }
        return count>1? false : true;
    }
}
