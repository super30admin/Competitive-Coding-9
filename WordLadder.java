// Time Complexity - O(M^2*N*26) M = word len , N = Total no of words in input wordList
// Space Complexity - O(N) N = size of queue

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int count = 1; // no of words transformed
        while(!q.isEmpty()) {
            int size = q.size();
            // for all words this round
            for(int i=0;i<size;i++) {
                String curr_word = q.poll();
                char[] word_chars = curr_word.toCharArray();
                // traverse current word char array
                for(int j=0;j<word_chars.length;j++) {
                    char temp = word_chars[j];
                    // changing one letter at a time
                    for(char ch='a';ch<='z';ch++) {
                        if(word_chars[j]==ch) continue;
                        word_chars[j]=ch;
                        String new_word = String.valueOf(word_chars);
                        // when endword is present
                        if(new_word.equals(endWord)) return count+1;
                        // transformation is present
                        if(set.contains(new_word)) {
                            q.add(new_word);
                            set.remove(new_word);
                        }
                    }
                    word_chars[j]=temp; // undo the change of letter
                }
            }
            count++; // after changing one letter in this round
        }
        return 0;
    }
}