//TC : O(k*n^2) - n = words in wordList and k is average length of words in wordList and O(n) for calculating string combinations

//SC : O(n) // Map size

class Solution {
    HashMap<String, Boolean> map;
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        int counter = 1;
        
        map = new HashMap<>();
        
        for(int i = 0; i< wordList.size(); i++){ // Using Boolean for visited words
            map.put(wordList.get(i), false);
        }
        
        Queue<String> queue = new LinkedList<>();
        
        queue.add(beginWord);
        map.put(beginWord, true);
        
        while(!queue.isEmpty() ){
            int len = queue.size();
            
            while(len-- > 0){
                    String curr = queue.poll();
                    if(curr.equals(endWord))    return counter + 1;
                
                    char[] arr = curr.toCharArray();
                    for(int i = 0; i< arr.length; i++){
                        char ch = arr[i];
                        
                        for(char c = 'a'; c<= 'z'; c++){ // 26 combinations of string
                            arr[i] = c;
                            String tempString = new String(arr);
                            if(map.containsKey(tempString) && !map.get(tempString)){
                                if(tempString.equals(endWord))  return counter + 1;
                                queue.add(tempString);
                                map.put(tempString, true);
                            }
                        }
                        arr[i] = ch;
                    }
                    
                }
            counter++; // Incrementing counter level by level
        }
        return 0;
    }
}


