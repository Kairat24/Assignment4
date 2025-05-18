import java.util.*;

public class BreadthFirstSearch<V> {

    // Method to find the shortest path from start to destination using BFS
    public List<Vertex<V>> search(WeightedGraph<V> graph, Vertex<V> start, Vertex<V> destination) {
        // Keeps track of visited vertices to avoid cycles
        Set<Vertex<V>> visited = new HashSet<>();

        // Queue for BFS traversal (FIFO)
        Queue<Vertex<V>> queue = new LinkedList<>();

        // Map to remember how we got to each vertex (used to build the path later)
        Map<Vertex<V>, Vertex<V>> predecessor = new HashMap<>();

        // Start BFS from the start vertex
        visited.add(start);
        queue.add(start);

        // While there are vertices to process
        while (!queue.isEmpty()) {
            Vertex<V> current = queue.poll(); // Get the next vertex from the queue

            // If we reached the destination, build and return the path
            if (current.equals(destination)) {
                return buildPath(predecessor, start, destination);
            }

            // Go through all neighbors of the current vertex
            for (Vertex<V> neighbor : current.getAdjacentVertices().keySet()) {
                // If we haven't visited this neighbor yet
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);         // Mark as visited
                    queue.add(neighbor);           // Add to queue to explore later
                    predecessor.put(neighbor, current); // Remember how we got here
                }
            }
        }

        // If we get here, there's no path from start to destination
        return Collections.emptyList();
    }

    // Builds the path from start to destination using the predecessor map
    private List<Vertex<V>> buildPath(Map<Vertex<V>, Vertex<V>> pred, Vertex<V> start, Vertex<V> destination) {
        LinkedList<Vertex<V>> path = new LinkedList<>();

        Vertex<V> step = destination;

        // Go backwards from destination to start using predecessors
        while (step != null) {
            path.addFirst(step);     // Add to the beginning to reverse the path
            step = pred.get(step);   // Move to the previous vertex
        }

        return path;
    }
}