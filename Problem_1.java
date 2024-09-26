//Time Complexity:O(m^2*n)
//Space Complexity:O(mn) m is the length of the wordlist and n is the avg length of the words in wordlist
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q= new LinkedList<>();
        Set<String> set= new HashSet<>(wordList);
        q.add(beginWord);  
        int lvl=0;
        while(!q.isEmpty()){
            int size=q.size();
            lvl++;
            for(int i=0;i<size;i++){
                String curr= q.poll();
                if(curr.equals(endWord)) return lvl;
                List<String> neighbors = neighbors(curr);
                for(String s :neighbors){
                    if(set.contains(s)){
                        set.remove(s);
                        q.add(s);
                    }
                }
            }
        }
        return 0;
    }
    public List<String> neighbors(String str){
        char[] chars= str.toCharArray();
        List<String> result = new ArrayList<>();
        for(int i=0;i<chars.length;i++){
            char temp=chars[i];
            for(char c='a';c<='z';c++){
                chars[i]=c;
                String neigh = new String(chars);
                result.add(neigh);
        }
        chars[i]=temp;
        }
        return result;
    }
}