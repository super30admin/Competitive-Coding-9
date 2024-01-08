// Time Complexity :O(M*N)
// Space Complexity :O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
       Queue<String> q= new LinkedList<>();
       HashSet<String> set= new HashSet<>();

       int cont=1;

       for(int i=0;i<wordList.size();i++)
       {
           set.add(wordList.get(i));
       }
       if(!set.contains(endWord))
       return 0;

       
        q.add(beginWord);

      while(!q.isEmpty())
      {
          int size= q.size(); 
          for(int i=0;i<size;i++)
          {
             String currword= q.poll();
             char[] wordschar = currword.toCharArray();

                for(int l=0;l<wordschar.length;l++)
                     {
                         char originalchar=wordschar[l];
                         for(char ch ='a';ch<='z';ch++)
                         {
                            if(wordschar[l]==ch)
                            continue;

                            wordschar[l]=ch;
                            String newword= String.valueOf(wordschar);
                            if(newword.equals(endWord))
                            return cont+1;

                            if(set.contains(newword))
                            {
                                q.offer(newword);
                                set.remove(newword);
                            }
          
                        } 
                          wordschar[l]=originalchar;
                     }
                   

            }
            cont++;

        }
          return 0;
          
    }
}