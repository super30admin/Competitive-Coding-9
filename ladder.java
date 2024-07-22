// Time Complexity : O(nxn)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        if(!words.contains(endWord)){
            return 0;
        }
        int count = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                String curr = q.poll();
                if(curr.equals(endWord)){
                    return count;
                }
                char[] compare = curr.toCharArray(); // convert to array, easy to swap and check
                for(int j = 0; j < compare.length; j++){
                    char hasChar = compare[j];
                    for( char c = 'a'; c <= 'z'; c++){ // O(1) swapping and checking with each character
                        if(c == hasChar){
                            continue;
                        }
                        compare[j] = c;
                        String str = new String(compare);
                        if(words.contains(str) && !visited.contains(str)){
                            q.add(str);
                            visited.add(str);
                        }
                    }
                    compare[j] = hasChar; // setting it back to how it was before
                }
            }
            count++; // incremenet count
        }
        return 0;
    }
}