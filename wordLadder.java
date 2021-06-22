//Time complexity O(n)
//Space complexity O(n)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashMap<String,ArrayList<String>> dict = new HashMap<>();
        HashMap<String,Boolean> vis = new HashMap<>();
        
        int length = beginWord.length();
        
        for(int i = 0; i < wordList.size(); i ++){
    
                
                String word = wordList.get(i);
                vis.put(word,false);
                
                for(int k = 0; k < word.length(); k ++){
                    
                    String w = word.substring(0,k)+"*"+word.substring(k+1,word.length());
                    
                    if(!dict.containsKey(w)){
                        
                        dict.put(w, new ArrayList<>());
                    }
                    
                    dict.get(w).add(word);
                }
            
        }
        Queue<String> q1 = new LinkedList<>();
        q1.add(beginWord);
        vis.put(beginWord,true);
        //System.out.println(dict);
        int level = 0;
        while(!q1.isEmpty()){
            
            int size = q1.size();
             level ++;
            
            for(int i = 0; i < size; i ++){
                
                String contains = q1.poll();
                
                
                for(int j = 0; j < contains.length(); j ++){
                    
                    String temp = contains.substring(0,j)+"*"+contains.substring(j+1,contains.length());
                    if(dict.containsKey(temp)){
                        
                        ArrayList<String> s1 = new ArrayList<>();
                        s1 = dict.get(temp);
                        
                        for(int k = 0; k < s1.size(); k ++){
                         //   System.out.println(s1.get(k));
                            if(s1.get(k).equals(endWord)){
                                
                                return level + 1;
                            }
                            
                            else if(vis.get(s1.get(k))== false){
                                
                                vis.put(s1.get(k),true);
                                
                                q1.add(s1.get(k));
                            }
                        }
                    }
                }
            }
        }
        return 0;
        
    }
}