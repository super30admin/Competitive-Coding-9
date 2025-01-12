// Approach : Need to find shortest transformation will apply BFS
//Time Complexity: O(m*n)
//Space Complexity: O(m*n) ~ O(26) ~ O(1)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        // add all words to set - O(1) lookup
        HashSet<String> set = new HashSet<>(wordList);

        // base case
        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                String currWord = q.poll();

                //base case
                if (currWord.equals(endWord)) {
                    return level;
                }

                // for each character in CharArray
                for (int j = 0; j < currWord.length(); j++){
                    // convert String to Char Array
                    char[] currChar = currWord.toCharArray();

                    // for each letter from 'a' to 'z'
                    for (char c = 'a'; c <= 'z'; c++){
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
            level++;
        }

        return 0;
    }
}