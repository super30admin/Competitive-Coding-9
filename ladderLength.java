// Time Complexity :O(nL) where n is no of words and l is length of word
// Space Complexity :O(n) where n is no of words
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (beginWord.equals(endWord))
            return 0;
        HashSet<String> set = new HashSet<>();
        // HashMap<String,List<String>> graph=new HashMap<>();
        int wsize = wordList.size();
        // create set
        for (String s : wordList) {
            set.add(s);
        }
        // if endword is not there in set, return 0
        if (!set.contains(endWord))
            return 0;
        Queue<String> q = new LinkedList<>();
        // add beginword in queue
        q.add(beginWord);
        int level = 1;

        // HashMap<String,Boolean> visited=new HashMap<>();
        // performing BFS until q is empty
        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                // for each element in queue
                String curr = q.poll();
                char[] currCh = curr.toCharArray();
                // at each index
                for (int j = 0; j < curr.length(); j++) {
                    char org = currCh[j];
                    // check for each word
                    for (char c = 'a'; c <= 'z'; c++) {
                        currCh[j] = c;
                        // if we found the endWord, return level
                        if (String.valueOf(currCh).equals(endWord)) {
                            return level + 1;
                        }
                        // if not, check if word is there in set if yes, add in queue
                        else if (set.contains(String.valueOf(currCh))) {
                            System.out.println(String.valueOf(currCh));
                            q.add(String.valueOf(currCh));
                            set.remove(String.valueOf(currCh));
                        }
                        // change the word back to original
                        currCh[j] = org;
                    }
                }

            }
            level++;
        }
        return 0;
    }
} 