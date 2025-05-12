class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> mySet = new HashSet<>(wordList);
        if(!mySet.contains(endWord))
            return 0;
        
        Queue<String> myQueue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        myQueue.add(beginWord);
        visited.add(beginWord);

        int bsfLevel =1;

        while(!myQueue.isEmpty()){
            int size = myQueue.size();
            for(int i=1; i<=size; i++){
                String currentWord = myQueue.poll();

                if(currentWord.equals(endWord)){
                    return bsfLevel;
                }

                char[] currentWordCharacter = currentWord.toCharArray();
                for(int j=0; j<currentWordCharacter.length; j++){
                    char originalChar = currentWordCharacter[j];
                        for(char c='a'; c<='z'; c++){
                            if( c== originalChar){
                                continue;
                            }
                            currentWordCharacter[j] = c;
                            String newString = new String(currentWordCharacter);
                            if(mySet.contains(newString) && !visited.contains(newString)){
                                myQueue.add(newString);
                                visited.add(newString);
                            }
                        }
                    currentWordCharacter[j] = originalChar;
                }
            }
            bsfLevel = bsfLevel+1;
        }
        return 0;
    }
}

/** 
 * Time Complexity: O(26*m*n)
m = Total words in the List
n = word length
Space Complexity: O(m*n)
Set holding n elements
visited holding n elements
m : length of the word
*/




