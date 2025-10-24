/*
* Approach: As adjacent pairs of words differs by a single letter, we can think of them as connected components and apply BFS as we want to return the shortest transformation sequence
- Start by adding all the words from the wordlist in the set for O(1) lookup
- The idea is to process words level by level as at a time we can only modify one character. If by modifying the character, the newword is in the set, then we add it to the queue and remove it from the set (basically we want mark as visited so that we dont process it again and again)
- If the word is found, we return the level If not, we return 0
- TC: O(n * l * 26) -> n - iterate through the list of words in the wordlist, l - length of the word and at each word we have 26 possibles of characters that we can replace it
- SC: O(n) -> n - words in the hashset, words in the queue 
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        int level = 1;
        Queue<String> q = new LinkedList<>();

        //add wordlist words in the set
        for (int i = 0; i < wordList.size(); i++) {
            set.add(wordList.get(i));
        }

        //if endword is not in the set, endowrd doesnt exists, so return
        if (!set.contains(endWord))
            return 0;

        q.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            // size because we wantt o keep track of the level and process words on that level
            for (int i = 0; i < size; i++) {
                String temp = q.poll();
                if (temp.equals(endWord))
                    return level;

                //create new word
                char[] charArray = temp.toCharArray();
                for (int j = 0; j < temp.length(); j++) {
                    //keep the original letter for the next position
                    char original = temp.charAt(j);
                    String newWord = "";
                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[j] = c;
                        newWord = new String(charArray);
                        // check if newword is in the set, if present, remove it from the set, add it to the queue
                        if (set.contains(newWord)) {
                            q.add(newWord);
                            //remove it from the set so that means we have already visited the word to avoid revisiting the same word
                            set.remove(newWord);
                        }
                        //restore original letter
                        charArray[j] = original;
                    }
                }
            }
            level++;
        }
        return 0;
    }
}