// Time Complexity :O(m*n)
// Space Complexity :O(m*n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word: wordList){
            set.add(word);
        }
        if(!set.contains(endWord))
            return 0;
        
        int level=1;
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);//add begin word to queue
        
        while(!q.isEmpty()){
            int size=q.size();
            
            for(int k=0;k<size;k++){
                String st=q.poll();
                char[] temp= st.toCharArray();//convert the String in queue to char array so that we can replace each char by a-z
                for(int i=0;i<st.length();i++){
                    char ch=temp[i];
                    for(char j='a';j<='z';j++){
                        if(temp[i]==j) continue;
                        temp[i]=j;
                        if(String.valueOf(temp).equals(endWord)) return level+1;
                        if(set.contains(String.valueOf(temp)))
                            q.add(String.valueOf(temp));
                    }
                    temp[i]=ch;
                }
            }
            level++;
        }
        
        return 0;
    }
}


              