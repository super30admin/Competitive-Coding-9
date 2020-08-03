// Time complexity - O(n * m), n is size of word list and m is length of given string
// Space complexity - O(n), hashset and queue

// BFS

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(String word:wordList){
            set.add(word);
        }
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level=1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                String currWord = q.poll();
                char[] charWord = currWord.toCharArray();
                for(int j=0;j<charWord.length;j++){
                    char temp = charWord[j];
                    for( char c = 'a';c<'z';c++){
                        if(charWord[j]==c) continue;
                        charWord[j]=c;
                        String newString = String.valueOf(charWord);
                        if(newString.equals(endWord))return level+1;
                        if(set.contains(newString)){
                            q.offer(newString);
                            set.remove(newString);
                        }
                    }
                    charWord[j]=temp;
                }
            }
            level++;
        }
        return 0;
    }
}
