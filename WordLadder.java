// Time Complexity : O(M^2 * N) M is the length of begin word and N is the no. of words in list
// Space Complexity : O(M * N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Create a queue add the begin word
// Run till q is not empty
// Pop a word and find all its neighbors or words with 1 letter different than itself
// Check if the any of the words we found exist in hashset
// If exists remove from the hashset and add in queue
// Keep incrementing the level and finally return the no. of levels

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> hs = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        hs.remove(beginWord);
        q.add(beginWord);
        int level = 0;
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            for(int i = 0; i < size; i++){
            String cur = q.poll();
            if(cur.equals(endWord))
                return level;
            List<String> n = neighbors(cur);
            for(String word: n){
                if(hs.contains(word)){
                    hs.remove(word);
                    q.add(word);
                }
            }
        }
    }
        return 0;
    }
    private List<String> neighbors(String cur){
        char[] curr = cur.toCharArray();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < curr.length; i++){
            char temp = curr[i];
            for(char c = 'a'; c <= 'z'; c++){
                curr[i] = c;
                String neighbor = new String(curr);
                res.add(neighbor);
            }
            curr[i] = temp;
        }
        return res;
    }
}