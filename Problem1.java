//https://leetcode.com/problems/asteroid-collision/
//Time complexity : O(N)
//Space complexity : O(N)

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for(int asteroid  : asteroids){
            int lastAsteriod = Integer.MIN_VALUE;
            if(!s.isEmpty())
                lastAsteriod = s.peek();
            
            //collision    
            if(lastAsteriod > 0 && asteroid < 0){
                while(!s.isEmpty() && s.peek() > 0 && s.peek() < Math.abs(asteroid)){
                    s.pop();
                }
                if(!s.isEmpty() && s.peek() == Math.abs(asteroid)){
                    s.pop();
                    continue;                    
                }
                if(!s.isEmpty() && s.peek() > Math.abs(asteroid))
                    continue;
                if(s.isEmpty() || s.peek() < 0)
                    s.add(asteroid);
            } 
            // no collision
            else{
                s.add(asteroid);
            }
        }

        int res[] = new int[s.size()];
        int index = s.size() - 1;
        while(!s.isEmpty()){
            res[index--] = s.pop();
        }
        return res;
    }
}