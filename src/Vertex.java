import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex<V> {
    // The actual data stored in the vertex (like a label or value)
    private V data;

    // Stores all the neighbors of this vertex and the weights of the edges to them
    private Map<Vertex<V>, Double> adjacentVertices = new HashMap<>();

    // Constructor that sets the data for this vertex
    public Vertex(V data) {
        this.data = data;
    }

    // Getter for the data — typo in method name, should be getData()
    public V getDate() {
        return data;
    }

    // Returns all neighbors and the weights to them
    public Map<Vertex<V>, Double> getAdjacentVertices() {
        return adjacentVertices;
    }

    // Adds a neighbor with a weight (used to create an edge from this to another vertex)
    public void addAdjacentVertex(Vertex<V> destination, double weight) {
        adjacentVertices.put(destination, weight);
    }

    // Converts vertex to a string (useful for printing/debugging)
    @Override
    public String toString() {
        return data.toString();
    }

    // Checks if two vertices are equal by comparing their data
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Vertex<?>)) return false;
        Vertex<?> vertex = (Vertex<?>) o;
        return Objects.equals(data, vertex.data);
    }

    // Generates a hash code based on the data (needed for using vertices in hash-based collections)
    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }
}