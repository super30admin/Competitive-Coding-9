// Time COmplexity: O(nlogn) where n is number of nodes of tree
// Space Complexity: O(maximum depth of tree)
class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        map.put(0, list);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                Pair<TreeNode,Integer> pair = q.poll();
                TreeNode cur = pair.getKey();
                Integer level = pair.getValue();
                if(cur.left != null) {
                    list = map.getOrDefault(level - 1, new ArrayList<>());
                    list.add(cur.left.val);
                    map.put(level - 1, list);
                    q.add(new Pair(cur.left, level-1));
                }
                if(cur.right != null) {
                    list = map.getOrDefault(level + 1, new ArrayList<>());
                    list.add(cur.right.val);
                    map.put(level + 1, list);
                    q.add(new Pair(cur.right, level+1));
                }
            }
        }
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        List<List<Integer>> res = new ArrayList<>();
        for(int key: keys) {
            res.add(map.get(key));
        }
        return res;
    }
}

