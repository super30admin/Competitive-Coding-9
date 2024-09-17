// Time Complexity :O(n)
// Space Complexity :O(n)
class Solution {
    HashSet<Integer> tdays;
    Integer[] ydays;
    public int mincostTickets(int[] days, int[] costs) {
         tdays= new HashSet();
        ydays= new Integer[366];
        for(int i=0;i<days.length;i++)
        {
            tdays.add(days[i]);
        }
        return optimal(1,costs);    
    }
    public int optimal(int d,int[]costs)
    {
        //base case to exit recursion
        if(d>365)
            return 0;
        //Access pre calculated value in ydays
        if(ydays[d]!=null)
            return ydays[d];
        
        int opresult;
        if(tdays.contains(d))
        {
            //Check minimum of all pass options for travel days
             opresult=Math.min(optimal(d+1,costs)+costs[0],optimal(d+7,costs)+costs[1]);
            opresult=Math.min(opresult,optimal(d+30,costs)+costs[2]);
        }
        else
            opresult=optimal(d+1,costs);
        
        ydays[d]=opresult;
        
        return opresult;
    }
}
==========================================================
// Time Complexity :O(mxn)
 // Space Complexity :O(m)
 class Solution {
     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         HashSet<String> beginSet = new HashSet<>();
         HashSet<String> endSet = new HashSet<>();
         HashSet<String> dict = new HashSet<>(wordList);
         HashSet<String> visited = new HashSet<String>();
         if(!dict.contains(endWord))return 0;

         int len = 1;

         beginSet.add(beginWord);
         endSet.add(endWord);

         while(!beginSet.isEmpty() && !endSet.isEmpty()){
             if(beginSet.size() > endSet.size()){
                 HashSet<String> set = beginSet;
                 beginSet = endSet;
                 endSet = set;
             }

             HashSet<String> tempSet = new HashSet<>();
             for(String word: beginSet)
             {
                 char[] cArr = word.toCharArray();
                 for(int i = 0; i < word.length(); i++)
                 {
                     char old = cArr[i];

                     for(char ch = 'a'; ch <= 'z'; ch++)
                     {
                         cArr[i]=ch;

                         String target = String.valueOf(cArr);

                         if(endSet.contains(target)){
                             return len+1;
                         }

                         if(!visited.contains(target) && dict.contains(target)){
                             visited.add(target);
                             tempSet.add(target);
                         }
                     }
                     cArr[i]=old;
                 }
             }

             beginSet = tempSet;
             len++;

         }

         return 0;
     }
 }
