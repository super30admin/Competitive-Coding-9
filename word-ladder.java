/*

Did it run on leetcode: Yes
Time Complexity: 0(N*N)
Space Complexity: 0(N)

Algorithm:
- Using BFS technique
- from startWord  add all words into the queue, which have only one character change.
- repeat the same for each word in queue till you get endWord or queue is empty.

*/




class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        Queue<String> q = new LinkedList<String>();
        Set<String> wordListSet = new HashSet<>(wordList);
        
        q.add(beginWord);
        
        int step = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;++i){
                String curr = q.poll();
                
                if(curr.equals(endWord)){
                    return step;
                }
                char[] currArray = curr.toCharArray();
                for(int j=0;j<curr.length();++j){
                    char ch = currArray[j];
                    for(char k='a';k<='z';++k){
                        currArray[j] = k;
                        String check = String.valueOf(currArray);
                         
                        if(!check.equals(curr)  && wordListSet.contains(check)){
                            q.add(check);
                            wordListSet.remove(check);
                        }
                    }
                    currArray[j]=ch;
                }
                
            }
            ++step;
        }

        return 0;
        
    }
}