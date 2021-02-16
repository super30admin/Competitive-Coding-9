/*
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        # form a graph
        graph = dict(list())
        for word in wordList:
            for i in range(len(word)):
                s = word[0:i] + "*" + word[i+1:len(word)]
                
                if s not in graph:
                    graph[s] = []
                graph[s].append(word)
        
        queue = collections.deque()
        queue.append((beginWord, 1))
        
        visited = set()
        visited.add(beginWord)
        
        
        while len(queue) > 0:
            node, level = queue.popleft()
            
            
            for i in range(len(node)):
                s = node[0:i] + "*" + node[i+1:len(node)]
                if s in graph and graph[s] is not None:
                    for neighbor in graph[s]:
                        
                        if neighbor == endWord:
                            return level+1
                        
                        if neighbor not in visited:
                            visited.add(neighbor)
                            queue.append((neighbor, level+1))
                            
        return 0
*/
      
// Time - O(s^2*wordlist) for graph where s is len of string and substring function also takes s time so its s^2. The same would hold true for bfs 
// Space - O(s^2*wordlist) as we create intermediate string in graph and graph would hold all combinations of s and wordlist
// Logic - first graph is created for every string like grouping anagrams and then bfs is performed to reach endword

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // form  graph
        HashMap<String, ArrayList<String>> graph = new HashMap<>();
        for (String s: wordList){
            for (int i=0; i<s.length(); i++){
                String key = s.substring(0,i) + "*" + s.substring(i+1,s.length());
                
                if (!graph.containsKey(key)){
                    graph.put(key, new ArrayList<String>());
                }
                
                ArrayList<String> list = graph.get(key);
                list.add(s);
                graph.put(key, list);
            }
        }
        
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord, 1));
        
        HashSet<String> visited = new HashSet<>();
        visited.add(beginWord);
        
        while (!queue.isEmpty()){
            Pair<String, Integer> p = queue.poll();
            String s = p.getKey();
            int level = p.getValue();
            
            for (int i=0; i<s.length(); i++){
                String newWord = s.substring(0,i) + "*" + s.substring(i+1, s.length());
                if (graph.containsKey(newWord)){
                    for (String neighbor:graph.get(newWord)){
                        
                        if (neighbor.equals(endWord))
                            return level+1;
                        
                        if (!visited.contains(neighbor)){
                            visited.add(neighbor);
                            queue.add(new Pair(neighbor, level+1));
                            
                        }
                    }
                }
            }
            
        }
        
        return 0;
    }
}