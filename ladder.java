class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(endWord.length()!=beginWord.length()) return 0;
        HashMap<String,List<String>> map = new HashMap<>();
        Queue<String> q = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        int len=beginWord.length();
        int level=1;

        for(String s: wordList){
            for(int i=0;i<len;i++){
                String adj=s.substring(0,i)+"*"+s.substring(i+1);
                List<String> li = map.getOrDefault(adj,new ArrayList<>());
                li.add(s);
                map.put(adj,li);
            }
        }
        q.add(beginWord);
        visited.add(beginWord);
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String word=q.poll();
                for(int j=0;j<len;j++){
                    String nword=word.substring(0,j)+"*"+word.substring(j+1);
                    if(map.containsKey(nword)){
                        for(String adj:map.get(nword)){
                            if(adj.equals(endWord)) return level+1;
                            if(!visited.contains(adj)){
                                q.add(adj);
                                visited.add(adj);
                            }
                        }
                    }
                }
            }
            level++;
        }

        return 0;
    }
}
