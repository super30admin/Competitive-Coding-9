// Time Complexity : O(M^2*N) where M is the length of the permutation word and N is the length of wordList
// Space Complexity : O(M*N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Got incorrect answer with recursive approach


// Your code here along with comments explaining your approach

class WordList {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList();
        HashSet<String> set = new HashSet();
        Set<String> visited = new HashSet();
        for(String word: wordList){
            set.add(word);
        }
        int path = 1;
        q.add(beginWord);
        while(!q.isEmpty()){
            int size = q.size();
            for(int k=0;k<size;k++){
                String word = q.poll();
                if(word.equals(endWord))
                    return path;
            
                    for(int j=0;j<word.length();j++){
                         
                        for(int i='a';i<='z';i++){
                        char[] wordChar = word.toCharArray();
                            wordChar[j]=(char)i;
                        
                        
                        String permWord = new String(wordChar);
                        if(set.contains(permWord) && !visited.contains(permWord)){
                            visited.add(permWord);
                            q.add(permWord);
                        }
                    }
                }
            }
                path++;
        }
             return 0;
    }
       
}
