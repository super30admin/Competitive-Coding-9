// Time Complexity : O(26*(LengthOfWord)*DictionaryLength)
// Space Complexity : O(DictionaryLength)
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : In framing the BFS.


// Your code here along with comments explaining your approach
class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int distance = 0;
        while(!q.isEmpty()){
            int size = q.size();
            distance++;
            for(int s = 0; s < size; s++){
            String currentNode = q.poll();
            if(currentNode.equals(endWord)){return distance;}
            char array[] = currentNode.toCharArray();
            for(int i = 0; i < array.length; i++){
                char ch = array[i];
                for(char c = 'a'; c <= 'z'; c++){
                    if(c != ch){
                        array[i] = c;
                        String neighbour = new String(array);
                        if(dictionary.contains(neighbour)&& !visited.contains(neighbour)){
                         q.add(neighbour);
                         visited.add(neighbour);
                        }
                    }
                }
                array[i] = ch;
            }
            }
        }
        return 0;
    }
}