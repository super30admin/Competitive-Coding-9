package CompetitiveCoding9;
// Time Complexity : O(n * k * k * 26);
// n is the number of words. k is the length of each word and for string comparision
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if(beginWord == endWord) return 0;
        HashSet<String> set = new HashSet<>(wordList);

        if(!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();

        q.add(beginWord);
        int level = 0; int wordLength = beginWord.length();
        while(!q.isEmpty())
        {
            level++;
            int size =  q.size();
            for(int i=0; i<size; i++)
            {
                String curr = q.poll();
                char[] cArr = curr.toCharArray();
                for(int pos = 0; pos<wordLength; pos++)
                {
                    char origChar = cArr[pos];
                    for(char c='a'; c<='z'; c++)
                    {
                        cArr[pos] = c;
                        String t = String.valueOf(cArr);
                        if(curr.equals(t)) continue;
                        if(t.equals(endWord)) return level+1;
                        if(set.contains(t))
                        {
                            System.out.println(t);
                            q.add(t);
                            set.remove(t);
                        }

                    }
                    cArr[pos] = origChar;
                }

            }
        }
        return 0;
    }
}