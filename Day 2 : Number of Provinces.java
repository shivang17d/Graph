/*
Problem: Number of Provinces
Time Complexity: O(V^2) where V is the number of vertices
Space Complexity: O(V)
*/

class Solution {

    // Helper function to find the number of provinces
    public int solve(ArrayList<ArrayList<Integer>> adjList, int V) {
        boolean[] visited = new boolean[adjList.size()];  // Keeping track of visited nodes
        int cnt = 0;   // Keeping track of the number of provinces
        
        // Iterate through all vertices
        for (int i = 0; i < V; ++i) {
            if (!visited[i]) {
                cnt++;
                // Call DFS to explore the connected components
                dfs(adjList, i, visited);
            }
        }
        return cnt;
    }

    // Breadth-First-Search Implementation
    public void bfs(ArrayList<ArrayList<Integer>> adjList, int startVertex, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        visited[startVertex] = true;
        queue.add(startVertex);
        
        // BFS traversal
        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            for (int neighbor : adjList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    // Depth-First-Search Implementation
    public void dfs(ArrayList<ArrayList<Integer>> adjList, int vertex, boolean[] visited) {
        visited[vertex] = true;
        
        // Recursively explore neighbors of the current vertex
        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                dfs(adjList, neighbor, visited);
            }
        }
    }

    // Function to find the number of provinces in the given graph
    public int findCircleNum(int[][] isConnected) {

        int v = isConnected.length;   // Number of node vertices

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();    // Adjacency List
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // Converting Adjacency Matrix to Adjacency List
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjList.get(i).add(j);
                }
            }
        }
    
        return solve(adjList, v);   // Returns the number of provinces.
    }
}
