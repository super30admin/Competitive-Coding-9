//https://leetcode.com/problems/word-ladder/
/*
Time: O(M^2*N) where M=length of each word and N=wordList.size()
Space: O(M^2*N) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<String>();

        for (String s : wordList)
            set.add(s);

        if (!set.contains(endWord))
            return 0;

        Queue<String> q = new LinkedList<String>(); // bfs
        q.offer(beginWord);
        int level = 1; // for output

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String current_word = q.poll();
                char[] word_chars = current_word.toCharArray();

                for (int j = 0; j < word_chars.length; j++) // loop through current word characters h,i,t
                {
                    char original_char = word_chars[j]; // char = h, to help with reset later

                    for (char c = 'a'; c <= 'z'; c++)// loop through the letters in the alphabet, increment ascii values
                    {
                        if (word_chars[j] == c)
                            continue;// do nothing for same character

                        word_chars[j] = c; // assign this new character say hit becomes 'iit'

                        String newWord = String.valueOf(word_chars); // check if string "iit" is in set or the endword

                        if (newWord.equals(endWord)) // if we have reached the end, then return
                            return level + 1;

                        if (set.contains(newWord)) {
                            q.offer(newWord); // add newWord to queue and travel
                            set.remove(newWord);
                        }
                    }

                    word_chars[j] = original_char; // remember to reset so that we don't mess anything up.
                }

            }

            level++;
        }
        return 0;
    }

}
