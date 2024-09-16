package competitiveCoding9;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadderI {
	//BFS
	//Time Complexity : O(m^2*n), where m is length of each word and n is the total
	//number of words
	//Space Complexity : O(m*n)
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord))
            return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        set.remove(beginWord);
        int count = 1;
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                String curr = queue.poll();
                for(int j=0; j<curr.length(); j++) {
                    char[] charArr = curr.toCharArray();
                    char currChar = charArr[j];
                    for(char c='a'; c<='z'; c++) {
                        if(c == currChar)
                            continue;
                        charArr[j] = c;
                        String str = String.valueOf(charArr);
                        if(endWord.equals(str))
                            return count + 1;
                        if(set.contains(str)) {
                            queue.offer(str);
                            set.remove(str);
                        }
                    }
                    charArr[j] = currChar;
                }
            }
            count += 1;
        }
        return 0;
    }
}
