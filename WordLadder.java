// Time Complexity : O(size of wordList)
// Space Complexity : O(size of wordList)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class WordLadder {
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> set = new HashSet<>();
            for(int i = 0; i < wordList.size(); i++){
                String str = wordList.get(i);
                set.add(str);
            }

            if(!set.contains(endWord))
                return 0;


            int level = 1;
            Queue<String> q = new LinkedList<>();
            q.add(beginWord);

            while(!q.isEmpty()){
                int size = q.size();
                for(int i = 0; i < size; i++){
                    String currStr = q.poll();
                    char[] charArr = currStr.toCharArray();
                    for(int j = 0; j < charArr.length; j++){
                        char currChar = charArr[j];
                        for(char c = 'a'; c <= 'z'; c++){
                            if(c == currChar)
                                continue;

                            charArr[j] = c;
                            String newStr = String.valueOf(charArr);

                            if(newStr.equals(endWord))
                                return level + 1;

                            if(set.contains(newStr)){
                                q.add(newStr);
                                set.remove(newStr);
                            }
                        }
                        charArr[j] = currChar;
                    }
                }
                level++;
            }

            return 0;
        }
    }
}
