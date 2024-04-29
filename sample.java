// Time Complexity :O(n*l*l)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes


// https://leetcode.com/problems/word-ladder/description/

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q= new LinkedList<>();
        HashSet<String> set=new HashSet<>(wordList);
        q.add(beginWord);
        int level=1;
        while(!q.isEmpty())
        {
            int l=q.size();
            for(int i=0;i<l;i++){
                String curr=q.poll();
                for(int j=0;j<curr.length();j++)
                {
                    char w[]=curr.toCharArray();
                    for(char ch='a';ch<='z';ch++)
                    {
                        w[j]=ch;
                        String word= new String(w);
                        if(set.contains(word))
                        {
                            if(word.equals(endWord))
                                return ++level;
                            set.remove(word);
                            q.add(word);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}



// Time Complexity :O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : yes


// https://leetcode.com/problems/minimum-cost-for-tickets/


class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int dp[]=new int[days.length+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        int j;
        for(int i=1;i<=days.length;i++)
        {
            dp[i]=dp[i-1]+costs[0];
            j=i-1;
            while(j>=0 && days[i-1]-days[j]<7)
                j--;
            dp[i]=Math.min(dp[i],dp[j+1]+costs[1]);
            j=i-1;
            while(j>=0 && days[i-1]-days[j]<30)
                j--;
            dp[i]=Math.min(dp[i],dp[j+1]+costs[2]);

        }
        return dp[days.length];
    }
}
