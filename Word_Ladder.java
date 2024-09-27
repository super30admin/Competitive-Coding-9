// Time Complexity :O(mxn)
// Space Complexity :O(m)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> beginSet = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        HashSet<String> dict = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<String>();
        if(!dict.contains(endWord))return 0;
        
        int len = 1;
        
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            if(beginSet.size() > endSet.size()){
                HashSet<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }
            
            HashSet<String> tempSet = new HashSet<>();
            for(String word: beginSet)
            {
                char[] cArr = word.toCharArray();
                for(int i = 0; i < word.length(); i++)
                {
                    char old = cArr[i];
                    
                    for(char ch = 'a'; ch <= 'z'; ch++)
                    {
                        cArr[i]=ch;
                        
                        String target = String.valueOf(cArr);
                        
                        if(endSet.contains(target)){
                            return len+1;
                        }
                        
                        if(!visited.contains(target) && dict.contains(target)){
                            visited.add(target);
                            tempSet.add(target);
                        }
                    }
                    cArr[i]=old;
                }
            }
            
            beginSet = tempSet;
            len++;
            
        }
        
        return 0;
    }
}
