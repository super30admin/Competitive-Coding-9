// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : figuring out the graph part


// Your code here along with comments explaining your approach

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String,ArrayList<String>> map = new HashMap<>();
        Queue<Pair<String,Integer>> q = new LinkedList<>();
        q.add(new Pair(beginWord,1));
        int ans = 0;
        for(String s:wordList)
        {
            for(int i = 0 ; i < s.length();i++)
            {
                String rel =  s.substring(0,i)+"*"+s.substring(i+1,s.length());
                if(!map.containsKey(rel))
                {
                    map.put(rel,new ArrayList<String>());
                }
                map.get(rel).add(s);
            }
        }
        HashMap<String,Boolean> visited = new HashMap<>();
        visited.put(beginWord,true);
        while(!q.isEmpty())
        {
            Pair<String,Integer> p = q.poll();
            String word = p.getKey();
            int level = p.getValue();
            for(int i = 0 ; i <word.length();i++)
            {
                String rel =  word.substring(0,i)+"*"+word.substring(i+1,word.length());
                if(map.containsKey(rel))
                {
                    List<String> l = map.get(rel);
                    for(String s:l)
                    {
                        if(s.equals(endWord)) return level+1;
                        if(!visited.containsKey(s))
                        {
                            q.add(new Pair(s,level+1));
                            visited.put(s,true);
                        }
                    }
                }
            }
            
        }
        return 0;
    }
}