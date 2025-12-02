// Time Complexity : O(n*l) where n is number of words in wordList and l is the length of each word
// Space Complexity : O(n*l)
// Did this code successfully run on Leetcode : Yes
// Approach : We perform a BFS to get the shortest path for transormation. First we store the strings of wordList in a HashSet so that the search is O(1). We
// start by adding beginWord to the queue and at each character we explore all possibilities by replacing it with a to z. We skip when original char comes but
// check if the replaced char word is present in the hashset we created. If yes, we add to the queue and remove the word from set to avoid duplicate matching.
// After checking a to z possibilities, we replace the character at index with original char so that next iterations will be performed correctly. At any point,
// if the string in queue matches the endword, we return the level, that gives the shortest path.


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);//HashSet for wordList
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;
        //BFS
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) { //endWord achieved
                    return level;
                }
                char[] chars = word.toCharArray();
                for (int j = 0; j < word.length(); j++) {
                    char curr = chars[j];
                    for(char c = 'a'; c <= 'z'; c++){ //replace with a to z chars and check
                        if(chars[j] == c){ //original char
                            continue;
                        }
                        chars[j] = c;
                        String nextWord = new String(chars);
                        if(set.contains(nextWord)){ //if sequence word is formed
                            set.remove(nextWord); //remove from set to avoid duplicate search
                            queue.add(nextWord); //add to queue
                        }
                    }
                    chars[j] = curr; //restore the original char for next index iteration
                }
            }
            level++; //increment level

        }
        return 0;
    }
}