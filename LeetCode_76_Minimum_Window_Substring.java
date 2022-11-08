import java.util.Map;

//take hashmap based on t
//now, we will take two conditions , one to move fast pointer and one to move slow pointer!
//we will move fast pointer unitl we get match == map.size(), once we got this, we will stop here. 
//now we have to move the slow pointer, before that, we will check - if existing length of the string fast-slow is less
//than pervious result, if so we will update our index1 = slow and index2 = fast; 
//then in that same loop , we will move slow++ until we get condition fulfilled - match != match.size()
//so we will use main while loop - which will run till fast or slow is in bound!
//inside that, 1st while loop , will move fast pointer and second while loop will move slow pointer. 
//after these to nested while loop , we will put a check - if fast is out of bound and match is still less than map size, it means none
//of the while loop will be invoked, and so we break there!
// we have put the last if check so we can cover the case wjen we dont find any character/combination in s!

class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 ||t == null || t.length() == 0||s.length()<t.length())
            return "";
        
        int match= 0;
        int slow =0,fast=0;
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        int index1 =0, index2 =0;

        
        //build map from t
        for(int i =0; i<t.length(); i++)
        {
            char c = t.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }

        while(fast < s.length() || slow<s.length())
        {
            //incoming character check
            //fast and slow at 0 initially

            while(fast < s.length() && match != map.size())
            {
                char in = s.charAt(fast);

                if(map.containsKey(in))
                {
                    int cnt = map.get(in);
                    cnt--;
                    if(cnt ==0) match++;
                    map.put(in, cnt);
                }fast++; //regarrdless of map contains or not, we move fast
            }
            //we come here when we get match == map.size()
            //time to move slow pointer
            while(slow < s.length() && match == map.size())
            {
                //first update the result
                //first time index2 will be 0
                if(index2==0 || (index2-index1) > (fast -slow))
                {
                    index1 = slow;
                    index2 = fast;
                }
                //now we check for the outgoing character
                char out = s.charAt(slow);
                if(map.containsKey(out))
                {
                    int cnt = map.get(out);
                    cnt++;
                    if(cnt ==1) match--;
                    map.put(out, cnt);
                }}slow++; //regardless of map contains or not, we move slow
            }

            //we come here and also check, if fast is out of bound and slow can't be updated as match is not 
            //equal to map.size; we get out of the loop
            if(fast<s.length() && match != map.size())
            break;
        }
        return s.substring(index1, index2);
    }
}