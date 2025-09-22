
// Time Complexity: O(N * M * 26) where N is the number of words in the wordList and M is the length of each word.
// Space Complexity: O(N) for the queue and the hash set.


//given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation 
// sequence from beginWord to endWord, such that:Only one letter can be changed at a time.
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

//we can use BFS to solve this problem. We start from the beginWord and explore all possible transformations 
// by changing one letter at a time. We keep track of the level of the BFS, which represents the number of transformations. 
// If we reach the endWord, we return the current level + 1 (to account for the endWord). else we return 0.
// We use a hash set to store the word list for O(1) lookups and to avoid revisiting words.
// We also use a queue to facilitate the BFS traversal.
// We iterate through each character of the current word, change it to every possible letter from 'a' to 'z',
// and check if the new word exists in the word list. If it does, we add it to the queue and remove it from the word list to prevent cycles.

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordset=new HashSet<>(wordList);
        if(!wordset.contains(endWord)) return 0;

        Queue<String> q=new LinkedList<>();

        q.add(beginWord);
        if(wordset.contains(beginWord))
            wordset.remove(beginWord);

        int level=1;
        while(!q.isEmpty()){
            int size=q.size();

            for(int i=0;i<size;i++){
                String curr=q.poll();
                char[] currWord=curr.toCharArray();

                for(int j=0;j<currWord.length;j++){
                    char original=currWord[j];
                    for(char c='a';c<='z';c++){
                        currWord[j]=c;
                        String newWord=new String(currWord);

                        if(newWord.equals(endWord))
                            return level+1;
                            
                        if(wordset.contains(newWord)){
                            q.add(newWord);
                            wordset.remove(newWord);
                        }
                    }
                    currWord[j]=original;
                }
            }
            level++;
        }
        return 0;
    }
}