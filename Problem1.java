
// Time - O(m^2*n)
// Space - O(mn) m is the length of the wordlist and n is the avg length of the words in wordlist

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();

        HashSet<String> set = new HashSet<>(wordList); // adding wordlist to the set

        q.add(beginWord); // adding the beginning word

        int level = 0;  // level to return

        while(!q.isEmpty()) {

            int size = q.size();
            level++; // incrementing the level which is the path to return

            for(int i = 0; i < size; i++) {

                String curr = q.poll();
                if(curr.equals(endWord)) return level;

                List<String> neighbors = neighbor(curr); // finding the neighbor strings

                for(String s : neighbors) { // iterating through neighbor strings

                    if(set.contains(s)) {
                        set.remove(s); // removing from the set
                        q.add(s); // adding it to the queue
                    }

                }

            }

        }

        return 0;
    }

    private List<String> neighbor(String word) {

        char[] chars= word.toCharArray();

        List<String> result = new ArrayList<>();
        for(int i = 0; i < chars.length; i++) {

            char temp = chars[i];

            for(char c = 'a'; c < 'z'; c++) {

                chars[i] = c;
                String neighborStrings = new String(chars);
                result.add(neighborStrings); // adding all the combinations to the result


            }

            chars[i] = temp;

        }

        return result;
    }


}