// Time Complexity :O(N*M*L)
// Space Complexity :O(L)
// Did this code successfully run on Leetcode :Yess
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach: BFS and Set

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q= new LinkedList<>();
        HashSet<String> set= new HashSet<>(wordList);

        q.add(beginWord);

        // for(String word: wordList){
        //     set.add(word);
        // }
        set.remove(beginWord);
        int level=1;

        while(!q.isEmpty()){
            int size= q.size();
            for(int i=0; i<size;i++){
                String curr= q.poll();
                if(curr.equals(endWord)){
                    return level;
                }
                for(int j=0; j< curr.length();j++){
                    char c[]= curr.toCharArray();
                    for(char ch='a'; ch<='z'; ch++){
                        c[j]=ch;
                        String nextWord= new String(c);
                        if(set.contains(nextWord)){
                            q.add(nextWord);
                            set.remove(nextWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}