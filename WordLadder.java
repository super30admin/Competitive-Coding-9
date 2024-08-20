// Time Complexity : O(M^2 * N) - where M is length of each word and N is total number of words
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int count = 1;
        while(!q.isEmpty()) {
            int size = q.size(); // levels
            for(int i = 0; i < size; i++) {
                String word = q.poll();
                if(word.equals(endWord)) return count;
                for(int j = 0; j < word.length(); j++) {
                    for(char ch = 'a'; ch <= 'z'; ch++) {
                        char[] arr = word.toCharArray();
                        arr[j] = ch;
                        String newWord = new String(arr);

                        if(set.contains(newWord)) {
                            q.add(newWord);
                            set.remove(newWord);
                        }
                    }
                }
            }
            ++count;
        }
        return 0;
    }
}