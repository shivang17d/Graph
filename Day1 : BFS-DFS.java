import java.util.*;

public class Graph {
    // Function to print the adjacency list representation of the graph
    public static void printA(ArrayList<ArrayList<Integer>> am) {
        for (int i = 1; i < am.size(); i++) {
            System.out.println("\nVertex " + i + ":");
            for (int j = 0; j < am.get(i).size(); j++) {
                System.out.print(" -> " + am.get(i).get(j));
            }
            System.out.println();
        }
    }

    // Breadth-First Search (BFS) traversal of the graph
    public static void bfs(ArrayList<ArrayList<Integer>> adjList, int startVertex) {
        boolean[] visited = new boolean[adjList.size()];
        Queue<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll();
            System.out.print(currentVertex + " ");

            for (int neighbor : adjList.get(currentVertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    // Depth-First Search (DFS) traversal of the graph
    public static void dfs(ArrayList<ArrayList<Integer>> adjList, int startVertex) {
        boolean[] visited = new boolean[adjList.size()];
        dfsRecursive(adjList, startVertex, visited);
    }

    // Recursive function for DFS traversal
    private static void dfsRecursive(ArrayList<ArrayList<Integer>> adjList, int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        for (int neighbor : adjList.get(vertex)) {
            if (!visited[neighbor]) {
                dfsRecursive(adjList, neighbor, visited);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int v = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(v + 1);

        for (int i = 0; i <= v; ++i) {
            adj.add(new ArrayList<>());
        }

        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt();

        // Input edges and build the adjacency list
        for (int i = 0; i < e; i++) {
            int src = sc.nextInt();
            int des = sc.nextInt();
            adj.get(src).add(des);
            adj.get(des).add(src); // For undirected graph
        }

        System.out.println("\nAdjacency List:");
        printA(adj);

        System.out.print("\nEnter the starting vertex for BFS traversal: ");
        int startVertexBFS = sc.nextInt();
        System.out.print("BFS Traversal starting from vertex " + startVertexBFS + ": ");
        bfs(adj, startVertexBFS);

        System.out.print("\n\nEnter the starting vertex for DFS traversal: ");
        int startVertexDFS = sc.nextInt();
        System.out.print("DFS Traversal starting from vertex " + startVertexDFS + ": ");
        dfs(adj, startVertexDFS);

        sc.close();
    }
}
