class Solution {

    // Time Complexity : 0(m^2 * n) where m is the size of the word and n is the size of wordlist
// Space Complexity : 0(m^2 * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

    // Idea here is to perform BFS starting from begin word and get all the words
// by chaging 1 character in current string and finding if it exist in set
// if it exists put in queue and start BFS on those once all the previous neighbours are completed
// if we reach final result, level is returned

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList == null || beginWord == null || endWord == null){
            return 0;
        }
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        if(!set.contains(endWord)){
            return 0;
        }
        q.add(beginWord);
        int count = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                char [] curr = q.poll().toCharArray();
                for(int j = 0; j < curr.length; j++){
                    char temp = curr[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        curr[j] = c;
                        String neig = new String(curr);
                        if(set.contains(neig)){
                            if(endWord.equals(neig)){
                                return count + 1;
                            }
                            q.add(neig);
                            set.remove(neig);
                        }
                    }
                    curr[j] = temp;
                }
            }
            count++;
        }
        return 0;
    }
}