// Time Complexity : O(n*26m)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> words = new HashSet<>(wordList);
        if(!words.contains(endWord))
            return 0;
        HashSet<String> visited = new HashSet<>();
        q.add(beginWord);
        visited.add(beginWord);
        int count = 1;
        while(!q.isEmpty()){
            int sz = q.size();
            for(int i = 0; i < sz; i++){
                String curr = q.poll();
                if(curr.equals(endWord))
                    return count;
                for(int j = 0; j < curr.length(); j++){
                    for(int k = 'a'; k <= 'z'; k++){
                        char[] temp = curr.toCharArray();
                        temp[j] = (char) k;
                        String tmp = new String(temp);
                        if(words.contains(tmp) && !visited.contains(tmp)){
                            q.add(tmp);
                            visited.add(tmp);
                        }
                    }
                }
            }
            count++;
        }
        return 0;
    }
}