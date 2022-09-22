class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        
        for(int i=0;i<wordList.size();i++){
            set.add(wordList.get(i));
        }
        
        if(!set.contains(endWord)) return 0;
        
        Queue<String> q = new LinkedList<>();
        int level=1;
        q.offer(beginWord);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int j=0;j<size;j++){
                String currWord = q.poll();
                char [] wordArr = currWord.toCharArray();

                for(int i=0;i<wordArr.length;i++){
                    char temp = wordArr[i];
                    for(char c='a';c<='z';c++){
                        if(c==temp) continue;
                        wordArr[i] = c;
                        String newSt = String.valueOf(wordArr);
                        if(newSt.equals(endWord)) return level+1;
                        if(set.contains(newSt)){
                            q.offer(newSt);
                            set.remove(newSt);
                        }

                    }
                    wordArr[i]=temp;
                }
            }

            level++;
        }
        return 0;
        
    }
}