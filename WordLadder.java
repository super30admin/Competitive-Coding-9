// Time Complexity : O(N * list of words in the dict)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    HashSet<String> set;
    Queue<String> queue;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        this.set = new HashSet<>(wordList);
        queue = new LinkedList<>();
        if(!set.contains(endWord)){
            return 0;
        }
        int count =0;
        queue.add(beginWord);
        count =1;

        // bfs to search the path
        while(!queue.isEmpty()) {
            // iterate each level
            int size = queue.size();

            for(int i=0;i< size;i++){
                String word = queue.poll();

                if(word.equals(endWord)) return count;

                // find connected word
                findConnectedWord(word);
            }
            // increase counter
            count++;
        }
        // not found
        return 0;
    }

    private void findConnectedWord(String word){
        char[] arr = word.toCharArray();

        for(int i=0;i< arr.length;i++){
            char currChar = arr[i];

            for(char c ='a'; c<='z';c++){
                if(currChar == c) continue;

                arr[i] = c;

                String newWord = String.valueOf(arr);

                if(set.contains(newWord)){
                    queue.add(newWord);
                    set.remove(newWord);
                }
            }
            arr[i] = currChar;
        }
    }
}