//Time complexity:O(n*m) m indicates length of wordlist n indicates length of word
//Space complexity:O(m)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet(wordList);
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<String> q=new LinkedList();
        int level=1;
        q.add(beginWord);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String curr=q.poll();
                char[] currword=curr.toCharArray();
                for(int j=0;j<currword.length;j++){
                    char temp=currword[j];
                    for(char c='a';c<='z';c++){
                        if(currword[j]==c){
                            continue;
                        }
                        currword[j]=c;
                        String newword=String.valueOf(currword);
                        if(set.contains(newword)){
                            if(newword.equals(endWord)){
                                return level+1;
                            }
                            else{
                                q.add(newword);
                                set.remove(newword);
                            }
                        }
                        currword[j]=temp;
                    }
                }
            }
            level++;
        }
        return 0;
    }
}