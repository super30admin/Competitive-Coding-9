// 127.

//time - max(O(wordList.length), O(word with max lengthh in wordList))
//space - max(O(wordList.length) - hashset, O(word with max lengthh in wordList) - char array)

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        //make a hashset of wordlist to get constant lookup
        HashSet<String> words = new HashSet<>();
        for(String word : wordList)
        {
            words.add(word);
        }
        
        //if the endWord is not in wordList return
        //endWord unreachable
        if(!words.contains(endWord))
        {
            return 0;
        }
        
        //start from the begin word in the queue
        Queue<String> support = new LinkedList<>();
        support.offer(beginWord);
        int distance = 1; //source word is in layer 1
        
        while(!support.isEmpty())
        {
            int layerSize = support.size();
            for(int i = 0; i < layerSize; i++)
            {
                //remove the first word and get the char array
                String current = support.poll();
                char[] currentWord = current.toCharArray();
                for(int j = 0; j < currentWord.length; j++)
                {
                    //find all words which are 1 letter different from the current
                    char currentLetter = currentWord[j];
                    for(char replacement = 'a'; replacement <= 'z'; replacement++)
                    {
                        if(replacement == currentLetter) //current letter & replacement letter - same
                        {
                            continue;
                        }
                        currentWord[j] = replacement;
                        String transform = new String(currentWord); //transformed word - one letter away
                        if(transform.equals(endWord))
                        {
                            return distance + 1; //as this transform is part of next layer
                        }
                        else if(words.contains(transform)) //transfrom is valid word
                        {
                            support.offer(transform); //process this word in the next level
                            words.remove(transform); //to remove processing of same words again 
                        }
                    }
                    currentWord[j] = currentLetter; //to reconstruct the original array
                }
            }
            distance++;
        }
        
        //word not found after processing the whole wordlist
        return 0;
    }
}
