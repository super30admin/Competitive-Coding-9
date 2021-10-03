class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        
        HashSet<String> set = new HashSet<>();
        
        StringBuilder sb = new StringBuilder();
        //n thimes => length og 
        for(String w: wordList){
            //m times - length of each word
            for(int i=0; i<w.length(); i++){
                String newWord = w.substring(0,i)+"*"+w.substring(i+1,w.length());
                if(!map.containsKey(newWord)){
                    map.put(newWord, new ArrayList<>());
                }
                map.get(newWord).add(w);
            }
        }
        
        q.add(beginWord);
        
        int ladder = 1;
        // String word 
        while(!q.isEmpty()){ 
            int size = q.size();
            // System.out.println(size);
            for(int s=0; s<size; s++){
                String word = q.poll();
                // System.out.println("current word: "+word);
                for(int i=0; i<word.length(); i++){
                    String word_ = word.substring(0,i)+"*"+word.substring(i+1,word.length());
                    // System.out.println("current sequence: "+word_);
                    if(map.containsKey(word_)){
                        //Capture all strings that can be form from Dict
                        List<String> available = new ArrayList<>();
                        available = map.get(word_);
                        for(String a : available){
                            if(a.equals(endWord)) return ladder+1;
                            if(!set.contains(a)){
                                q.add(a);
                                set.add(a);
                            }
                        }
                    }    
            }
        }
      ladder++;      
    }
        return 0;
}
}
