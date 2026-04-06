// Time Complexity : O(n*k*26) , n = number of words, k = length of the max word length
// Space Complexity : O(n) for set
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We make use of a set for faster search in the list of strings.We do a BFS traversal by taking a queue starting
from beginWord and trying to replace each character until word length with 26 different combinations of alphabet
and check if we have that newly formed word in the dictionary.If so, add it to the queue and repeat the process
At any time, if we find the endWord, we return the count.
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int count = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0 ; i < size ; i++) {
                String word = q.poll();
                if(word.equals(endWord))
                    return count;
                for(int j = 0 ; j < word.length() ; j++) {
                    for(char ch = 'a' ; ch <= 'z' ; ch++) {
                        char[] wordArray = word.toCharArray();
                        wordArray[j] = ch;
                        String s = new String(wordArray);
                        if(set.contains(s)) {
                            q.add(s);
                            set.remove(s);
                        }
                    }
                }

            }
            count++;
        }
        return 0;
    }
}