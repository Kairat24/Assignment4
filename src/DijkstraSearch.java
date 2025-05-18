import java.util.*;

public class DijkstraSearch<V> {

    // Method to find the shortest path from start to destination using Dijkstra's algorithm
    public List<Vertex<V>> search(WeightedGraph<V> graph, Vertex<V> start, Vertex<V> destination) {
        // Stores the current shortest distance from the start to each vertex
        Map<Vertex<V>, Double> dist = new HashMap<>();

        // Stores the predecessor of each vertex to reconstruct the path later
        Map<Vertex<V>, Vertex<V>> pred = new HashMap<>();

        // Initialize distances to infinity (means unreachable)
        for (Vertex<V> v : graph.getVertices()) {
            dist.put(v, Double.POSITIVE_INFINITY);
        }

        // Distance to the start vertex is 0
        dist.put(start, 0.0);

        // Priority queue to pick the vertex with the smallest distance
        PriorityQueue<Vertex<V>> pq = new PriorityQueue<>(Comparator.comparing(dist::get));
        pq.add(start);

        // Keep track of visited vertices so we don't process the same one twice
        Set<Vertex<V>> visited = new HashSet<>();

        // Main Dijkstra loop
        while (!pq.isEmpty()) {
            Vertex<V> current = pq.poll();

            // If we've already processed this vertex, skip it
            if (!visited.add(current)) {
                continue;
            }

            // If we've reached the destination, stop early
            if (current.equals(destination)) {
                break;
            }

            // Check each neighbor of the current vertex
            for (Map.Entry<Vertex<V>, Double> v : current.getAdjacentVertices().entrySet()) {
                Vertex<V> neighbor = v.getKey();
                double weight = v.getValue();

                // Calculate the distance through the current vertex
                double newDist = dist.get(current) + weight;

                // If the new distance is shorter, update it
                if (newDist < dist.get(neighbor)) {
                    dist.put(neighbor, newDist);
                    pred.put(neighbor, current);  // Remember how we got here
                    pq.add(neighbor);            // Add to queue for further processing
                }
            }
        }

        // Now we build the shortest path by going backward from destination to start
        List<Vertex<V>> path = new LinkedList<>();
        Vertex<V> step = destination;

        // If we never reached the destination, return empty path
        if (!pred.containsKey(step) && !step.equals(start)) {
            return Collections.emptyList();
        }

        // Reconstruct the path by following the predecessors
        while (step != null) {
            path.add(0, step);  // Add to the beginning to reverse the order
            step = pred.get(step);
        }

        return path;
    }
}