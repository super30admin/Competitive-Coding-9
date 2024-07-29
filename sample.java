// Time Complexity : O(days)
// Space Complexity :O(days)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach

class Solution {
    int totalDays[];
    public int mincostTickets(int[] days, int[] costs) {
       Set<Integer> set=new HashSet<>();
       totalDays=new int[366];
       for(int i=0;i<days.length;i++)
       {
        set.add(days[i]);
       } 
       return minCost(days,costs,1,set);
    }
    private int minCost(int days[], int costs[],int cur, Set<Integer> set)
    {
        if(cur>365) return 0;
        if(totalDays[cur]!=0)
        {
            return totalDays[cur];
        }
        int cost=Integer.MAX_VALUE;
       while(!set.contains(cur))
        {
            return minCost(days,costs,cur+1,set);
        }
        int day1= costs[0]+minCost(days,costs,cur+1,set);
        int day7=costs[1]+minCost(days,costs,cur+7,set);
        int day30=costs[2]+minCost(days,costs,cur+30,set);
        cost=Math.min(day1,Math.min(day7,day30));
        totalDays[cur]=cost;
        return totalDays[cur];
    }
}

// Time Complexity : O(n*k)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
     HashMap<String, ArrayList<String>>dict= new HashMap<>();
     Queue<String> q=new LinkedList<>();
     q.add(beginWord);
     int len= beginWord.length();
     for(String w: wordList)
     {
        for(int j=0;j<len;j++)
        {
            String word= w.substring(0,j)+'*'+w.substring(j+1,len);
            ArrayList<String> list=dict.getOrDefault(word,new ArrayList<>());
            list.add(w);
            dict.put(word,list);
        }
     }  
     HashMap<String,Boolean> visited=new HashMap<>();
     visited.put(beginWord,true);
     int level=0;
     while(!q.isEmpty())
     {
      
        String word=q.remove();
      level++;
        for(int i=0;i<len;i++)
        {
            String newWord=word.substring(0,i)+'*'+word.substring(i+1,len);
            for(String adjword: dict.getOrDefault(newWord,new ArrayList<>()))
            {
                if(adjword.equals(endWord)) return level;
                if(!visited.containsKey(adjword))
                {
                    visited.put(adjword,true);
                    q.add(adjword);
                }
            }
        }
     } 
     return 0;
    }
}