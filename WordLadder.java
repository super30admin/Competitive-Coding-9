// TC=O(mn) approx similar to the maze problem
// BFS solution
/* Approach - 
1. Create a Hashmap with each charIndex in beginWord corresponsing to set(set because the letters may repeat) of possible letters for that index . e.g.{0:{h,d,l,c},1:{o},2:{t,g}}
2. Then create all possible words iterating through this hashmap and every time we create a word check if its there in the result set which we create using the wordlist and if its there just remove it from the result set so that further if the same word is formed it will not proceed further.
3. Add these new words to queue and perform BFS level by level. And keep a track at every level whether we reach the endWord.
4. After every level if we reached the endWord return the levelCount else return 0 if we are unable to reach the desstination
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> result = new HashSet<>(wordList);
        HashMap<Integer,HashSet<Character>> map = new HashMap<>(); //Using HashSet and not List as characters may repeat which needs to be avoided
        
        for(int i=0;i<beginWord.length();i++){
            Character ch = beginWord.charAt(i);
            map.put(i,new HashSet<>());
            // iterate over all the words in the wordList
            for(int j=0;j<wordList.size();j++){
                map.get(i).add(wordList.get(j).charAt(i));
            }
        }

        Queue<String> q = new LinkedList<>();

        int count = 1;
        q.add(beginWord);

        String tempo = "";
        while(!q.isEmpty()){
            
            int size = q.size();
            while(size>0){ // level processing i.e. only increment count after a level is over
            String s = q.poll(); 
            for(int i=0;i<s.length();i++){
                HashSet<Character> temp = map.get(i);
                // form words and check before adding to queue
                if(temp!=null){
                    for(Character c:temp){
                        StringBuilder str = new StringBuilder(s);
                        str.setCharAt(i,c);
                        String myString = str.toString();

                        if(result.contains(myString)){
                            q.add(myString);
                            result.remove(myString);
                            if(myString.equals(endWord)) tempo = myString; // to keep track whether we found the word in that level
                        }
                    }
                    
                }
            

            }
            size--;
            }
            count++; // increment the count only after a level is over
            if(tempo.equals(endWord)) return count;
            
        }
        
        return 0;
        
    }
}

// Below code is the debugging version of the above one with print statements
// class Solution {
//     public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//         HashSet<String> result = new HashSet<>(wordList);
//         HashMap<Integer,HashSet<Character>> map = new HashMap<>(); //Using HashSet and not List as characters may repeat which needs to be avoided
//         for(int i=0;i<beginWord.length();i++){
//             Character ch = beginWord.charAt(i);
//             map.put(i,new HashSet<>());
//             // iterate over all the words in the wordList
//             for(int j=0;j<wordList.size();j++){
//                 // if(wordList.get(j).charAt(i) != ch){ //check whether 'i' th character of every word is equal to the current character in beginWord - yes then add to list in the map
//                     map.get(i).add(wordList.get(j).charAt(i));
//                 // }
//             }
//         }
//         System.out.println(map);
//         Queue<String> q = new LinkedList<>();
//         // for(int i=0;i<beginWord.length();i++){
//         //     HashSet<Character> temp = map.get(i);
//         //     // form words and check before adding to queue
//         //     for(Character c:temp){
//         //         StringBuilder str = new StringBuilder(beginWord);
//         //         str.setCharAt(i,c);
//         //         String myString = str.toString();
//         //         if(myString == endWord) return 1;
//         //         if(result.contains(myString)){
//         //             q.add(myString);
//         //             result.remove(myString);
//         //         }
//         //     }
//         // }
//         int count = 1;
//         q.add(beginWord);
        
//         System.out.println(q);
//         String tempo = "";
//         while(!q.isEmpty()){
            
//             int size = q.size();
//             while(size>0){
//             String s = q.poll();
//             // if(result.contains(s)){
                
            
//             for(int i=0;i<s.length();i++){
//                 HashSet<Character> temp = map.get(i);
//                 // form words and check before adding to queue
//                 if(temp!=null){
//                     for(Character c:temp){
//                         StringBuilder str = new StringBuilder(s);
//                         str.setCharAt(i,c);
//                         String myString = str.toString();
//                         System.out.println(myString);
//                         if(result.contains(myString)){
//                             q.add(myString);
//                             result.remove(myString);
//                             if(myString.equals(endWord)) tempo = myString;
//                         }
//                     }
                    
//                 }
                
//             // }

//             }
//             size--;
//             }
//             count++;
//             if(tempo.equals(endWord)) return count;
            
//             System.out.println(count);
//         }
        
//         return 0;
        
//     }
// }