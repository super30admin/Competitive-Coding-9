class Solution {
    //Time Complexity:O(n)
    //Space Complexity:O(n)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        HashMap<String,ArrayList<String>> dict = new HashMap<>();        
         Queue<String> q = new LinkedList<>();
         q.add(beginWord);

         int len = beginWord.length();

// create the similarity map
//o(n)
         for (String word: wordList){
            for (int j = 0; j < len; j++){
                String pattern = word.substring(0,j) +  "*" + word.substring(j+1, len);
                ArrayList<String> list = dict.getOrDefault(pattern, new ArrayList<>());
                list.add(word);
                dict.put(pattern,list);
            }
         }
// created a visited map
HashSet<String> visited = new HashSet<>();
visited.add (beginWord);
int level = 0;
while (!q.isEmpty()){
    level++;
    int size = q.size();
    for (int i =0; i < size; i++){
       String curW = q.poll(); 
       if (curW.equals( endWord))
       return level;
       else {
         // if not present, add to visited and add the similar ones to queue 
            for (int j = 0; j < len; j++){
                String pattern = curW.substring(0,j) +  "*" + curW.substring(j+1, len);
            ArrayList<String> list = dict.get(pattern);
            if (list != null){
            for (String w : list){
         if (visited.contains(w) != true){
            visited.add(w);
            q.offer (w);

         }
            }}

       }

    }
}
    }

return 0;
}
}
