// Time Complexity : O(m^2)n
// Space Complexity : O(list of words)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        int len=0;
        q.add(beginWord);
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord))
            return 0;
        while(!q.isEmpty()){
            len++;
            int size=q.size();
            for(int j=0;j<size;j++){
            String word=q.poll();
            char[] arr=word.toCharArray();
            for(int i=0;i<arr.length;i++){
                for(char ch='a';ch<='z';ch++){
                    char tmpCh = arr[i];
                    arr[i]=ch;
                    String tmpWord = String.valueOf(arr);
                    if(set.contains(tmpWord)){
                        if(tmpWord.equals(endWord))
                            return len+1;
                        set.remove(tmpWord);
                        q.add(tmpWord);
                    }
                    arr[i]=tmpCh;
                }
            }
        }
        }
        return 0;
        }
    }
