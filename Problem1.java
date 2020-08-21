// Time Complexity : O(M^2*N) M=avg lenght of each word N=length of list
// Space Complexity :O(MN)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, List<String>> map = new HashMap<>();
        HashSet<String> visited = new HashSet<>();
        int level = 0;
        
        wordList.add(beginWord);
        
        for(String s : wordList){
            for(int i=0; i<s.length(); i++){
                String word = s.substring(0,i) + "*" + s.substring(i+1);
                
                map.putIfAbsent(word, new ArrayList<String>());
                map.get(word).add(s);
            }
        }
        
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);
        
        while(!q.isEmpty()){
            int n = q.size();
            for(int j=0; j<n; j++){
                String s = q.poll();

                if(s.equals(endWord))
                    return level+1;

                for(int i=0; i<s.length(); i++){
                    String word = s.substring(0,i) + "*" + s.substring(i+1);

                    for(String newWord: map.get(word)){
                        if(!visited.contains(newWord)){
                            visited.add(newWord);
                            q.offer(newWord);
                        }
                    }
                }
            }
            level++;
        }
        
        return 0;
    }
}