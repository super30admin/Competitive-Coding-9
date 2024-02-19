// Time Complexity : O(n * l * l)
// Space Complexity : O(n * l)
// Method used : Hashing and BFS

class Solution {

    class Pair
    {
        String s;
        int count;

        Pair(String s, int count)
        {
            this.s = s;
            this.count = count;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> set = new HashSet();
        Queue<Pair> queue = new LinkedList();

        for(String word : wordList) set.add(word);

        // Generate all possibilities

        queue.add(new Pair(beginWord, 1));

        // Remove this or it will unnecessarily repeat and increase the number of steps
        set.remove(beginWord);

        while(!queue.isEmpty())
        {
            Pair p = queue.poll();

            String s = p.s;
            int count = p.count;

            if(s.equals(endWord)) return count;

            for(int i = 0; i < s.length(); i++)
            {
                char[] temp = s.toCharArray();

                for(char c = 'a'; c <= 'z'; c++)
                {
                    temp[i] = c;

                    String newString = new String(temp);

                    if(set.contains(newString))
                    {
                        queue.add(new Pair(newString, count + 1));
                        
                        // Remove this or it will unnecessarily repeat and increase the number of steps
                        set.remove(newString);
                    }
                }
            }
        }

        return 0;
    }
}