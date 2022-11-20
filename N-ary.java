import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};


class Solution {
    //use bfs to find levels
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans= new ArrayList<>();
        if(root==null) return ans;
        Queue<Node> bfsqueue = new LinkedList<>();
        bfsqueue.add(root);        
        while(!bfsqueue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size =bfsqueue.size();
            //since the size would change in the loop
            //this maintains the level, the for loop runs for only that level
            for(int i=0;i<size;i++){
                Node newnode = bfsqueue.poll();
                level.add(newnode.val);
                bfsqueue.addAll(newnode.children);
            }
            ans.add(level);
        }
        return ans;
    }
}