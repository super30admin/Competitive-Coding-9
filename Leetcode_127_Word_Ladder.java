/*
 * B-F
 * I DONT KNOW _ ASK Shrinandha Mam.
 */

//To find the shortest ath we eed to keep track of which words lead where next! 
//here we are asked to find shortest path to reach to end word. 
//we add ein word to q. 
//size var on queue, run a for loop
//poll from queue and if its end word, we have levels var going at all level , we return that
//else we convert word to char array, run a for loop; and take all com of a-z
//check - if any of the comb exits in dictionary ; if so, if its not in visited, we add it tio visited and queue, else we keep going. 
//so, while going through this, because end word is a part of dictionay there will be case
//when we add actual end word to dictionary!
//we can cehck at the poll time, or at the a=time of adding to queue!
//if we never found it, return 
//tc: total M words of combination for nwords in dictionary with avg length L ; M*n*l + O(n*l) for end word check comparisions
//sc: O(n) - at max words from Dict will only added to Q. + Dict set+ visited set

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord == "")
            return 0;

        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord))
            return 0;

        boolean found = false;
        // visited set
        Set<String> visited = new HashSet<>();

        Queue<String> q = new LinkedList<>();

        int level = 1;

        q.add(beginWord);
        visited.add(beginWord);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();

                if (word.equals(endWord))
                    return level;

                // go through the word array to find all combinations!
                for (int j = 0; j < word.length(); j++) {
                    for (int c = 'a'; c <= 'z'; c++) {
                        char[] arr = word.toCharArray();
                        arr[j] = (char) c;

                        String comb = new String(arr);

                        if (comb.equals(endWord))
                            return level + 1;

                        if (dict.contains(comb) && !visited.contains(comb)) {
                            q.add(comb);
                            visited.add(comb);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}