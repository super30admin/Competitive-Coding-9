// Time Complexity :o(MN)
// Space Complexity : o(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashMap<String,ArrayList<String>> hashMap=new HashMap<>();
        
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        
        int len=beginWord.length();
        
        for(String w:wordList)
        {
            for(int j=0;j<len;j++)
            {
                String word= w.substring(0,j)+"*"+w.substring(j+1,len);
                ArrayList<String> list=hashMap.getOrDefault(word,new ArrayList<>());
                list.add(w);
                hashMap.put(word,list);
            }
           
        }
        
        HashMap<String,Boolean> visited=new HashMap<>();
        visited.put(beginWord,true);
        int level=0;
        
        while(!queue.isEmpty())
        {
            String word=queue.remove();
            level++;
            for(int i=0;i<len;i++)
            {
                String newword=word.substring(0,i)+"*"+word.substring(i+1,len);
                
                for(String adjword:hashMap.getOrDefault(newword,new ArrayList<>()))
                {
                    if(adjword.equals(endWord)) return level;
                    
                    if(!visited.containsKey(adjword))
                    {
                        visited.put(adjword,true);
                        queue.add(adjword);
                    }
                        
                }
            }
        }
        return 0;
    }
}
