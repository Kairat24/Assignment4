import java.util.HashSet;
import java.util.Set;

public class WeightedGraph<V> {
    // Set to store all the vertices in the graph
    private Set<Vertex<V>> vertices = new HashSet<>();

    // Adds a single vertex to the graph
    public void addVertex(Vertex<V> vertex) {
        vertices.add(vertex);
    }

    // Adds a directed edge from source to destination with a weight
    public void addEdge(Vertex<V> source, Vertex<V> destination, double weight) {
        // Connect source to destination with a weighted edge
        source.addAdjacentVertex(destination, weight);

        // Make sure both source and destination are part of the graph
        vertices.add(destination);
        vertices.add(source);
    }

    // Returns all vertices in the graph
    public Set<Vertex<V>> getVertices() {
        return vertices;
    }
}