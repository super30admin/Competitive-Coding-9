// Time Complexity : The time complexity is O(nk) where n is the length of the list and k is the length of each word
// Space Complexity : The space complexity is O(n) where n is the length of the list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        Map<String,List<String>> map = new HashMap<>();

        // Store the list in a map by mapping each word to its hash
        for(String word:wordList){

            for(int j=0;j<word.length();j++){
                String hash = word.substring(0,j) +  '*' + word.substring(j+1,word.length());

                List<String> l = map.getOrDefault(hash,new ArrayList<>());
                l.add(word);
                map.put(hash,l);
            }
        }

        int count = 0;
        set.add(beginWord);
        q.offer(beginWord);

        // BFS
        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0;i<size;i++){

                String cur = q.poll();

                if(cur.equals(endWord)){
                    return count+1;
                }

                // add all the adjacent words to the queue
                for(int j=0;j<cur.length();j++){
                    String hash = cur.substring(0,j) +  '*' + cur.substring(j+1,cur.length());
                    if(map.containsKey(hash)){
                        for(String word:map.get(hash)){
                            if(!set.contains(word)){
                                q.offer(word);
                                set.add(word);
                            }
                        }
                    }
                }
            }

            count++;
        }

        return 0;

    }
}
