// Time Complexity : O(n) where n is maximum number of days in given array
// Space Complexity : O(n) where n is maximum number of days in given array
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// In this approach first we are storing all the days we are travelling in HashSet for O(1) search. Then we are taking a maximum day from days array and creating
// a dp array of maximum days + 1 length. Now to fill this array we are calculating best possible cost on that day by taking minimum of total cost of using 
// 1 day pass 7 days pass and 30 days pass. If we are not traveling that day we are just simply taking value as it is from previous. At the end we are 
// returning the cost of the last day as it will be a optimized cost.

class Solution {
    public int mincostTickets(int[] days, int[] costs) {

        int n = days.length;
        int lastDay = days[n-1];

        int dp[] = new int[lastDay+1];

        int day_1 = costs[0];
        int day_7 = costs[1];
        int day_30 = costs[2];

        HashSet<Integer> daysSet = new HashSet<>();

        for(int i = 0; i < days.length; i++) {
            if(!daysSet.contains(days[i])) {
                daysSet.add(days[i]);
            }
        }

        dp[0] = 0;

        for(int i = 1; i < dp.length; i++) {

            if(!daysSet.contains(i)) {
                dp[i] = dp[i-1];
                continue;
            }

            dp[i] = Math.min(dp[i-1] + day_1, 
            Math.min(dp[Math.max(0, i-7)] + day_7, dp[Math.max(0, i-30)] + day_30));
            
        }
        

        return dp[dp.length - 1];
    }
}



// Time Complexity : O(m*m*n) where m is length of each word and n is total number of words in the wordList
// Space Complexity : O(m*m*n) where m is length of each word and n is total number of words in wordList to store dictionary with all possible intermediate words
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
// In this solution we are using Breadth-First Search to explore the shortest transformation sequence from BeginWord to endWord. We will generate all possible
// intermediate words by replacing each letter with wildcard character, and then we will map these intermediate forms to the corresponding words in the wordList.
// BFS will ensure that the first time endWord is encountered and this is how we have found the shortest path.

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, ArrayList<String>> dict = new HashMap<>();

        Queue<String> queue = new LinkedList<String>();
        queue.add(beginWord);

        int len = beginWord.length();

        for(String w : wordList) {
            for(int j = 0; j < len; j++) {
                String word = w.substring(0, j) + '*' + w.substring(j+1, len);
                ArrayList<String> list = dict.getOrDefault(word, new ArrayList<>());
                list.add(w);
                dict.put(word, list);
            }
        }

        HashMap<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);
        int level = 1;

        while(!queue.isEmpty()) {
            int queueSize = queue.size();

            for(int i = 0; i < queueSize; i++) {
                String word = queue.remove();

                for(int j = 0; j < len; j++) {
                    String newWord = word.substring(0, j) + '*' + word.substring(j+1, len);

                    for(String adjword : dict.getOrDefault(newWord, new ArrayList<>())) {
                        if(adjword.equals(endWord)) return level + 1;

                        if(!visited.containsKey(adjword)) {
                            visited.put(adjword, true);
                            queue.add(adjword);
                        }
                    }
                }
            }
            level++;
        }

        return 0;
    }
}