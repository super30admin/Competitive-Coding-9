// Time Complexity : O(N*N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>(wordList);
        
        q.add(beginWord);
        int level=1;
        
        while(!q.isEmpty())
        {
            int size=q.size();
            for(int m=0;m<size;m++) {
                String curr=q.poll();
                if(curr.equals(endWord)) {
                        return level;
                    }
                
                char[] currArr=curr.toCharArray();
                for(int i=0;i<curr.length();i++) {
                    char ch=currArr[i];
                    for(char j='a';j<='z';j++) {
                        currArr[i]=j;
                        String built = new String(currArr);
                        
                        if(!built.equals(curr) && set.contains(built)) {
                            q.add(built);
                            set.remove(built);
                    }
                }
                currArr[i]=ch;
                }
            }
            level++;
        }
        return 0;
    }
}
