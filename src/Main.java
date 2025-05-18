import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating vertices labeled A, B, C, and D
        Vertex<String> A = new Vertex<>("A");
        Vertex<String> B = new Vertex<>("B");
        Vertex<String> C = new Vertex<>("C");
        Vertex<String> D = new Vertex<>("D");

        // Creating a weighted graph and adding directed edges with weights
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge(A, B, 1.);   // A -> B with weight 1
        graph.addEdge(A, C, 4.);   // A -> C with weight 4
        graph.addEdge(B, C, 2.);   // B -> C with weight 2
        graph.addEdge(B, D, 5.);   // B -> D with weight 5
        graph.addEdge(C, D, 1.);   // C -> D with weight 1

        // Running Breadth-First Search from A to D
        BreadthFirstSearch<String> bfs = new BreadthFirstSearch<>();
        List<Vertex<String>> bfsPath = bfs.search(graph, A, D);
        System.out.println("BFS path from A to D: " + bfsPath);

        // Running Dijkstra's Algorithm from A to D
        DijkstraSearch<String> dijkstra = new DijkstraSearch<>();
        List<Vertex<String>> shortestPath = dijkstra.search(graph, A, D);
        System.out.println("Shortest path from A to D: " + shortestPath);
    }
}