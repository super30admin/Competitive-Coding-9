// TC: O(N+M)
// SC: O(1)
// where N is the length of the string s and M is the length of the string t

import java.util.HashMap;

public class LC76 {
    public String minWindow(String s, String t) {
        int start = 0;
        int end = 0;
        int n = s.length();
        int min = n+1, minIdx1 = 0, minIdx2 = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        int match = map.size();
        while(start<n){
            char ch = s.charAt(start);
            if(map.containsKey(ch)){
                map.put(ch, map.get(ch)-1);
                if(map.get(ch)==0) match--;
            }
            while(match==0){
                if(start-end+1 < min){
                    minIdx1 = end;
                    minIdx2 = start;
                    min = start-end+1;
                }
                char c = s.charAt(end);
                if(map.containsKey(c)){
                    map.put(c, map.get(c)+1);
                    if(map.get(c)==1) match++;
                }
                end++;
            }
            start++;
        }
        return s.substring(minIdx1, minIdx2+1);
    }
}
