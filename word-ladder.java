// Time Complexity : O(m^2*n)  n=no of chars in string n= bum of words in dictonary
// Space Complexity :O(m^2*n)   
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
         List<String> result= new ArrayList<>();
        if(beginWord==null || endWord==null || wordList==null || wordList.isEmpty()) return result.size();
        Map<String,List<String>> map = new HashMap<>();
        LinkedList<String> q= new LinkedList<>();
        Set<String> visited = new HashSet<>();     
       // int i=0;
        for(String key:wordList)
        {
          for(int i=0;i<key.length();i++)
          {
              String mapkey=key.substring(0,i)+"?"+key.substring(i+1,key.length());
              if(!map.containsKey(mapkey))
              {
                map.put(mapkey,new ArrayList());
              }
              List<String> temp=map.get(mapkey);
              temp.add(key);
             map.put(mapkey,temp);         
          }         
        }      
        System.out.print(map);
         q.add(beginWord);
        int level=0;
      while(!q.isEmpty())
      {
          int size= q.size();
          System.out.println("");
          for(int j=0;j<size;j++)
          {   
          String word=q.poll();
              System.out.print(word+",");
          if(word.equals(endWord)) return level+1;
              if(!visited.contains(word))
              {   
              for(int i=0;i<word.length();i++)
            {
            String mapkey=word.substring(0,i)+"?"+word.substring(i+1,word.length());
             if(map.containsKey(mapkey))
              {
                 
                 for(String word2:map.get(mapkey))
                   {
                     q.add(word2);
                     }
            }         
        }
          }
                visited.add(word);
          }
          level ++;          
      }     
        return 0;    
    }
}