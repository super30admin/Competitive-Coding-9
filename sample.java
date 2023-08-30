//Problem 1 Word Ladder
// Time Complexity :O(M^2 * N)
// Space Complexity :O(M^2 * N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : yes but resolved


// Your code here along with comments explaining your approach
//Try to search for all word patterns in bfs manner, try to reduce the search from doing a bidirectional bfs, means from beginword and endword to reduce time
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        if(!wordList.contains(endWord)) return 0;
        Set<String> begSet= new HashSet<>();
        begSet.add(beginWord);
        Set<String> endSet= new HashSet<>();
        endSet.add(endWord);
        Set<String> wordSet= new HashSet<>(wordList);

        // return bfs(begSet, endWord, wordSet, 1);
        return bfs(begSet, endSet, wordSet, 1);
    }

    // private int bfs(Set<String> begSet, String endWord, Set<String> wordSet, int dist){

    //     Set<String> reachableSet= new HashSet<>();
    //     wordSet.removeAll(begSet);

    //     for(String word: begSet){
    //         for(int i=0;i<word.length(); i++){
    //             char[] arr= word.toCharArray();
    //             for(char c='a';c<='z';c++){
    //                 arr[i]=c;
    //                 String newWord= new String(arr);
    //                 if(wordSet.contains(newWord)){
    //                     if(newWord.equals(endWord)) 
    //                         return dist+1;

    //                     reachableSet.add(newWord);
    //                 }
    //             }
    //         }
    //     }
    //     dist++;
    //     if(reachableSet.isEmpty())
    //         return 0;
        
    //     return bfs(reachableSet, endWord, wordSet, dist);
    // }

    //bidirectional bfs
    private int bfs(Set<String> begSet, Set<String> endSet, Set<String> wordSet, int dist){
        if(begSet.size()>endSet.size())
            return bfs(endSet, begSet, wordSet, dist);
        
        Set<String> reachableSet= new HashSet<>();
        wordSet.removeAll(begSet);

        for(String word: begSet){
            for(int i=0;i<word.length(); i++){
                char[] arr= word.toCharArray();
                for(char c='a';c<='z';c++){
                    arr[i]=c;
                    String newWord= new String(arr);
                    if(wordSet.contains(newWord)){
                        if(endSet.contains(newWord))
                            return dist+1;

                        reachableSet.add(newWord);
                    }
                }
            }
        }
        dist++;
        if(reachableSet.isEmpty())
            return 0;
        
        return bfs(reachableSet, endSet, wordSet, dist);
    }
}
//Problem 2 Minimum cost to buy tickets
// Time Complexity :O(365)
// Space Complexity :O(365)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
//check for all possible options to buy tickets in any given day, take minimum from it.
class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        HashSet<Integer> set=new HashSet<>();
        int max=Integer.MIN_VALUE;

        for(int i: days){
            set.add(i);
            max=Math.max(max, i);
        }

        int[] dp= new int[max+1];
        dp[0]=0;
        for(int i=1;i<dp.length;i++){
            if(!set.contains(i)){
                dp[i]=dp[i-1];
                continue;
            }

            dp[i]= Math.min(dp[i-1]+costs[0], Math.min(dp[Math.max(0,i-7)]+costs[1], dp[Math.max(0,i-30)]+costs[2]));
        }

        return dp[dp.length-1];
    }
}