// Time Complexity : O(M*N) where M = depth and N = number of neighbours
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int depth = 0;
        HashSet<String> map = new HashSet<String>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        
        while(!q.isEmpty()) {
            depth++;
            int len = q.size();
            for(int i=0;i<len;i++) {
                String curr = q.poll();
                if(curr.equals(endWord)) return depth;
                List<String> neighbours = findAllNeighbors(curr);
                for(String str: neighbours) {
                    if(map.contains(str)) {
                        q.add(str);
                        map.remove(str);
                    }
                }
            }
        }
        return 0;
        
    }
    
    public List<String> findAllNeighbors(String word){
        char[] charArr = word.toCharArray();
        List<String> neighbors = new ArrayList<>();
        for(int i=0; i<charArr.length; i++){
            char temp = charArr[i];
            for(char c='a'; c<='z'; c++){
                if(c == temp){
                    continue;
                }
                charArr[i] = c;
                neighbors.add(String.valueOf(charArr));
            }
            charArr[i] = temp;
        }
        return neighbors;
    }
}
