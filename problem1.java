// Time Complexity :O(nm^2)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no

/*
Approch
if i am putting the word list in set for O(1) search
then i am remove  the beginWord from the set if it exists so as avoid iterating over it twice,
then i begin the loop on the Queue until its empty;
i maintain a size variable to be able to differentiate between different BFS level,
then i take on word out of the queue return result if that is the endword
if not i run a loop on its length to make all the possible variations of that word and check if the variation exists in the set, if yes i put it queue and remove it from set
i continue this till i have iterated over all the words or return if word is found

*/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();
        int result = 0;
        q.add(beginWord);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }

        while (!q.isEmpty()) {
            int size = q.size();
            result++;
            for (int s = 0; s < size; s++) {
                String cur = q.poll();
                if (cur.equals(endWord))
                    return result;
                for (int i = 0; i < cur.length(); i++) {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        char[] charCur = cur.toCharArray();
                        charCur[i] = ch;
                        String modifiedCur = new String(charCur);
                        if (set.contains(modifiedCur)) {
                            q.add(modifiedCur);
                            set.remove(modifiedCur);
                        }
                    }
                }
            }
        }
        return 0;
    }
}