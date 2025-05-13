// Time Complexity : O(n * l * l), n-size of wordList, l-length of each word
// Space Complexity : O(n), for visited set and queue
// Did this code successfully run on Leetcode : Yes

// Approach:
// Use BFS to explore all one-letter transformations of the current word at each level.
// Add each valid transformed word to the queue if it's in the wordList and not yet visited.
// Return the level count when the endWord is found; if unreachable, return 0.

import java.util.*;
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words=new HashSet<>(wordList);
        if(!words.contains(endWord)) return 0;
        Queue<String> qu=new LinkedList<>();
        HashSet<String> visited=new HashSet<>();
        qu.add(beginWord);
        visited.add(beginWord);
        int cnt=1;
        while(!qu.isEmpty()){
            int levSize=qu.size();
            for(int i=0;i<levSize;i++){
                String curr=qu.poll();
                if(curr.equals(endWord)) return cnt;
                char[] chars=curr.toCharArray();
                for(int j=0;j<chars.length;j++){
                    char temp=chars[j];
                    for(char c='a';c<='z';c++){
                        if(c==temp) continue;
                        chars[j]=c;
                        String newWord=new String(chars);
                        if(words.contains(newWord) && !visited.contains(newWord)){
                            visited.add(newWord);
                            qu.add(newWord);
                        }
                    }
                    chars[j]=temp;
                }
            }
            cnt++;
        }
        return 0;
    }
}