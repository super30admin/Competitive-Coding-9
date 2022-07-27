// Time Complexity : O(n) where n is the number of asteroids
// Space Complexity : O(n) number of elements that can go into the stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes , mock interviewer was not paying attention to what I was explnaning and that resulted in time being wasted and I not getting the chance to code it out in the interview.


// Your code here along with comments explaining your approach

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        StackInteger stack = new Stack();


      for(int i=0; iasteroids.length; i++)
      {
        if(!stack.isEmpty() && stack.peek()0 && asteroids[i]  0)
        {
          if(stack.peek()  Math.abs(asteroids[i]))
          {
            continue;
          }
          else if(stack.peek() == Math.abs(asteroids[i]))
          {
            stack.pop();
          }
          else 
          {
            stack.pop();
            i--;
          }
        }
        else
        {
        stack.push(asteroids[i]);
        }
      }

     int[] result = new int[stack.size()];
  for(int i=result.length-1; i=0; i--)
  {
    result[i] = stack.pop();
  }
      return result;
    }
}