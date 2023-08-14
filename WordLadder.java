class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, ArrayList<String>> dict = new HashMap<>();
        Queue<String> q = new LinkedList<String>();//string and level
        q.add(beginWord);
        int len = beginWord.length();

        for(String w : wordList)//o(n)
        {
            for(int j=0;j<len;j++)//o(m) m is len of begin of word
            {
                String word = w.substring(0,j) + '*' + w.substring(j+1,len);
                ArrayList<String> list = dict.getOrDefault(word,new ArrayList<>());
                list.add(w);
                dict.put(word,list);

            }
        }
        HashMap<String,Boolean> visited = new HashMap<>();
        visited.put(beginWord,true);
        int level = 0;
        while(!q.isEmpty())
        {
            String word = q.remove();
            level++;
            for(int i=0;i<len;i++)///o(m)
            {
                String newWord = word.substring(0,i) + '*' + word.substring(i+1,len);
                for(String adjword : dict.getOrDefault(newWord, new ArrayList<>()))//o(n)
                {
                if(adjword.equals(endWord)) return level;
                if(!visited.containsKey(adjword))
                {
                    visited.put(adjword, true);
                    q.add(adjword);
                }
                }
            }
        }
return 0;
    }
}