
import java.util.*;

public class Graph {
    private final Map<String, List<Edge>> adjList;
    private final Set<String> nodes;
    private final List<Edge> edges;

    public Graph() {
        adjList = new HashMap<>();
        nodes = new HashSet<>();
        edges = new ArrayList<>();
    }

    public void addEdge(String from, String to, int weight) {
        nodes.add(from);
        nodes.add(to);
        Edge edge = new Edge(from, to, weight);
        adjList.computeIfAbsent(from, k -> new ArrayList<>()).add(edge);
        adjList.computeIfAbsent(to, k -> new ArrayList<>()).add(edge);
        edges.add(edge);
    }

    public List<Edge> getEdges() { return new ArrayList<>(edges); }
    public Set<String> getNodes() { return new HashSet<>(nodes); }
    public List<Edge> getNeighbors(String node) { return adjList.getOrDefault(node, new ArrayList<>()); }
    public int getVertexCount() { return nodes.size(); }
    public int getEdgeCount() { return edges.size(); }
}