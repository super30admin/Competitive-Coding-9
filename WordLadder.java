class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        //brute force approach
        // here we take the bfs approach and at each step check if the
        // remaining words in the word list that are not already seen
        // are put in the queue and as soon as the destination word is reached
        // we return the number of steps
        
        int steps = 1;

        Queue<String> q = new LinkedList<>();

        if(beginWord.equals(endWord)) return 0;

        q.add(beginWord);

        int levels = 1;

        while(!q.isEmpty()){


            int size = steps;

            levels += 1;
            steps = 0;

            while(size > 0){

                String curr = q.poll();

                for(int i = 0; i < wordList.size(); i++){

                    String comp = wordList.get(i);

                    if(compareString(comp,curr) == 1){
                        steps += 1;

                        if(endWord.equals(comp))
                            return levels;

                        q.add(comp);
                        wordList.set(i,"");

                    }

                }

                size--;
            }


        }

        return 0;




    }

    private int compareString(String s1, String s2){
        int i = 0;

        int count = 0;


        while(count < s1.length()){
            if(s1.charAt(count) != s2.charAt(count))
                i++;
            count++;
        }

        return i;

    }
}
