// TC: O(m*n)
// SC: O(n)

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> set = new HashSet<>();
        for(String word:wordList){
            set.add(word);
        }

        if(!set.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String curr = q.poll();
                if(curr.equals(endWord)) return level;
                for(int j=0;j<curr.length();j++){
                    char [] currWord = curr.toCharArray();
                    for(char c='a';c<='z';c++){
                        currWord[j]=c;
                        String newWord = new String(currWord);
                        if(set.contains(newWord)){
                            q.add(newWord);
                            set.remove(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}