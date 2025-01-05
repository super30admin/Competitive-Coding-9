//127. Word Ladder - https://leetcode.com/problems/word-ladder/description/
//Time Complexity: O(m*n)
//Space Complexity: O(m*n) ~ O(26) ~ O(1)

//BFS
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // in case of no transformations possible return 0
        // add all words to set
        HashSet<String> set = new HashSet<>(wordList);
        //base case
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int transformationLevel = 1;
        //logic
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String currWord = q.poll();
                //base case
                if (currWord.equals(endWord)) {
                    return transformationLevel;
                }

                // for each character in CharArray
                for (int j = 0; j < currWord.length(); j++) {
                    // convert String to Char Array
                    char[] currChar = currWord.toCharArray();
                    // for each letter from 'a' to 'z'
                    for (char c = 'a'; c <= 'z'; c++) {

                        currChar[j] = c;
                        String newWord = new String(currChar);
                        System.out.println(newWord );

                        if (set.contains(newWord)) {
                            q.add(newWord);
                            set.remove(newWord);
                        }
                    }
                }

            }

            transformationLevel++;
        }

        return 0; // if transformation is not possible

    }
}