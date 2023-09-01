// https://leetcode.com/problems/word-ladder/description/

// Time Complexity :O(nl)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //set to search if we have the word in wordlist
        HashSet<String> set = new HashSet<>(wordList);
        //null case
        if(!set.contains(endWord)) return 0;
        //Using bfs, we use one queue to kkep track of the word and other to keep track of the number of words used
        Queue<String> s = new LinkedList<>();
        Queue<Integer> c = new LinkedList<>();
        s.add(beginWord);
        c.add(1);
        set.remove(beginWord);
        int cnt = 0;
        //Run the loop till we go through each and every word
        while(!s.isEmpty()){
            String word = s.poll();
            cnt = c.poll();
            //Go through all the characters
            for(int i=0; i<word.length(); i++){
                //Replace the character with a-z and check
                for(int j=0; j<26; j++){
                    String t = word.substring(0,i) + (char)('a' + j) + word.substring(i+1,word.length());
                    //If we find the endword, return result
                    if(t.equals(endWord)){
                        return cnt+1;
                    }
                    //otherwise keep adding word to queue
                    if(set.contains(t)){
                        set.remove(t);
                        s.add(t);
                        c.add(cnt+1);
                    }
                }
            }
        }
        
        //if we cannot reach to endword, return 0;
        return 0;
    }
}