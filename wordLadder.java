//Time Complexity:O(wordList.size())
//Space Complexity:O(n)
//Approach- The begining word will be added to the queue and all the words in the worddict will be added to the set. Then for the size of the queue , the queue elements will be popped out and then till the length of the endword, each character will be modified to check if that particular word is in the set. If so, then it'll be checked if that word is the end word and the number of steps until then will be returned. Else, that word will be removed from the list and will be added to the queue. If the ladder can not be formed, then the function will be returning 0.
//This code was executed successfully and got accepted in leetcode.
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>(wordList);
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        int step=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String cur=q.poll();
                for(int j=0;j<endWord.length();j++){
                    for(char letter='a';letter<='z';letter++){
                        StringBuilder newcur=new StringBuilder(cur);
                        newcur.setCharAt(j,letter);
                        if(set.contains(newcur.toString())){
                            if(newcur.toString().equals(endWord)){
                                return step+1;
                            }
                            set.remove(newcur.toString());
                            q.add(newcur.toString());
                        }
                    
                }
            }
        }
        step++;
        
    }
    return 0;
        
}
}