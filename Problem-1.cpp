//remobve k elems
class Solution {
public:
string removeKdigits(string num, int k) {
        if(num.length()==k)return "0";
        // get all eligible elements in a stack
	    stack<char> stck;
        for(char c:num){
            while(k && !stck.empty() && (stck.top()-'0')>(c-'0')){
                stck.pop();
                k--;
            } 
            stck.push(c);
        } 
           if(k) {
            while(k--){
                stck.pop();
            }
        }
        //reverse
        stack<char> t;
        while(!stck.empty()){
            t.push(stck.top());
            stck.pop();
        }
    
        while(t.top()=='0'&&t.size()!=1){
            t.pop();
        }
        num="";
        while(!t.empty()){
            num.push_back(t.top());
            t.pop();
        }
        return num;
    }
};
