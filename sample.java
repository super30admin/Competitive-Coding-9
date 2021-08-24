// Time Complexity : O(N)
// Space Complexity :O(M) M = Max number in the array
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no


class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> set = new HashSet<>();
        for(Integer i : days) {
            set.add(i);  
        }
         int max = days[days.length-1];
        int[] dp = new int[max+1];
        
        for(int i = 1; i < dp.length; i++) {
            if(!set.contains(i)) {
                dp[i] = dp[i-1];
            } else {
                //1 day
                int oneDay = dp[i-1] + costs[0];
                //7 day
                int sevenDay = dp[Math.max(i - 7,0)] + costs[1];
                //30 day
                int thirtyDay = dp[Math.max(i - 30,0)] + costs[2];
                
                dp[i] = Math.min(oneDay, Math.min(sevenDay, thirtyDay));
            }
        }
        return dp[dp.length-1];
    }
}

// Time Complexity : O(N^2 + M)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode : yes 
// Any problem you faced while coding this : no

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, ArrayList<String>> dict = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int length = beginWord.length();
        
        for(String word : wordList) {
            for(int i = 0; i < length; i++) {
                String pattern = word.substring(0,i) + '*' + word.substring(i+1,length);
                if (!dict.containsKey(pattern)) {
                    dict.put(pattern, new ArrayList<String>());
                }
                dict.get(pattern).add(word);
            }
        }

        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        int level = 0;
        
        while(!queue.isEmpty()) {
            
            String word = queue.poll();
            level++;
            for(int i = 0; i < length; i++) {
                String newWord = word.substring(0,i) + '*' + word.substring(i+1,length);
                for(String adjacent : dict.getOrDefault(newWord, new ArrayList<>())) {
                    if(adjacent.equals(endWord)) {
                        return level;
                    }
                    if(!visited.contains(adjacent)) {
                        visited.add(adjacent);
                        queue.add(adjacent);
                    }
                }
            }
        }
        return 0;
    }
}



