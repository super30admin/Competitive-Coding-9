// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict=new HashSet<>();
        HashSet<String> visited=new HashSet<>();
        for(String st:wordList){
            dict.add(st);
        }
        if(!dict.contains(endWord)){
            return 0;
        }
        Queue<String> qu=new LinkedList<>();
        qu.add(beginWord);
        visited.add(beginWord);
        int size=0;
        int ladder=1;
        while(!qu.isEmpty()){
            size=qu.size();
            for(int i=0;i<size;i++){
                String curr=qu.remove();
                for(int j=0;j<curr.length();j++){
                    char[] arr=curr.toCharArray();
                    for(char k='a';k<='z';k++){
                        arr[j]=k;
                        if(endWord.equals(new String(arr))){
                           // System.out.println(new String(arr));
                            return ladder+1;
                        }
                        
                        if(dict.contains(new String(arr)) && !visited.contains(new String(arr))){
                            qu.add(new String(arr));
                            visited.add(new String(arr));
                        }
                    }
                }
            }
            ladder=ladder+1;
        }
        return 0;
        
    }
}