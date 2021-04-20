// Time Complexity : O(m^2 * n) where m - length of words, n - total number of words in list
// Space Complexity : O(m^2 * n) where m - length of words, n - total number of words in list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

// Using HashMap to get all combination of the strings for each word in the wordList
// Using BFS traversal traverse from the begin word get the matching combination string in map
// Using the matching similar words as next level of the tree proceed till endWord is reached

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = beginWord.length();
        HashMap<String,List<String>> map = new HashMap<>();
        for(String word:wordList){
            for(int i=0;i<len;i++){
                String str = word.substring(0,i)+"*"+word.substring(i+1,len);
                if(!map.containsKey(str))
                    map.put(str,new ArrayList<String>());
                map.get(str).add(word);
            }
        }
        Queue<Pair<String,Integer>> que = new LinkedList();
        List<String> list = new ArrayList<>();
        que.add(new Pair<>(beginWord,1));
        while(!que.isEmpty()){
            Pair<String,Integer> pair = que.poll();
            String str = pair.getKey();
            int level = pair.getValue();
            for(int i=0;i<str.length();i++){
                String s = str.substring(0,i)+"*"+str.substring(i+1,str.length());
                if(map.containsKey(s)){
                    List<String> temp = map.get(s);
                    for(String st : temp){
                        if(st.equals(endWord)){
                            return level+1;
                        }
                        if(!list.contains(st)){
                            list.add(st);
                            que.add(new Pair<>(st,level+1));
                        }
                    }
                }
            }
        }
        return 0;
    }
}
