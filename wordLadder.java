// Time Complexity: O(wordList size* string length*26)
// Space Complexity: O(wordList size) for set and same for queue
// Idea here is to perform BFS starting from begin word and get all the words
// by chaging 1 character in current string and finding if it exist in set
// if it exists put in queue and start BFS on those once all the previous neighbours are completed
// if we reach final result, level is returned
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int endHash = endWord.hashCode();
        int level = 1;
        
        while(!q.isEmpty()) {
            int size = q.size();
            for(int l = 0; l<size; l++) {
                String curr = q.poll();
                char[] strArr = curr.toCharArray();
                
                if(endHash==curr.hashCode() && curr.equals(endWord)) return level;
                for(int i=0; i<strArr.length; i++) {
                    char currChar = strArr[i];
                    for(char c = 'a'; c<='z'; c++) {
                        if(c!=currChar) {
                            strArr[i] = c;
                            String newStr = new String(strArr);
                            if(set.contains(newStr)) {
                                q.offer(newStr);
                                set.remove(newStr);
                            }
                            strArr[i] = currChar;
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}