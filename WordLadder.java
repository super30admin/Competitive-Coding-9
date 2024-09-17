import java.util.*;

// Time Complexity :O(m^2*n), m = size of dequeued word and n = size of word list
// Space Complexity :O(m^2*n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :getting started

// Your code here along with comments explaining your approach
public class WordLadder {

    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> set = new HashSet<>(wordList);//convert wordlist to hashset to have constant lookup during looping
            if(!set.contains(endWord)) return 0;// if the set doesn't contain the end word then no possible path to end

            //create queue for bfs
            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);

            //create hashset to track visited words
            Set<String> visited = new HashSet<>();
            visited.add(beginWord);

            //keep track of number of changes
            int changes =1;

            //bfs
            while(!queue.isEmpty()){
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String word = queue.poll();
                    if(word.equals(endWord)) return changes;

                    for (int j = 0; j < word.length(); j++) {
                        for (int k = 'a'; k <= 'z'; k++) {
                            char[] array = word.toCharArray();
                            array[j] = (char) k;

                            String str = new String(array);
                            if(set.contains(str) && !visited.contains(str)){
                                queue.add(str);
                                visited.add(str);
                            }
                        }
                    }
                }
                ++changes;
            }
            return 0;
        }
    }

}
