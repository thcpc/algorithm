package datastructures.graph;

public interface Graph {
    int v();
    int e();

    void addEdge(int v, int e);

    Iterable<Integer> adj(int v);
}
