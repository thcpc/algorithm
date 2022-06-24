package datastructures.graph;

public abstract class AbstractGraph implements Graph {
    private final int v;

    public AbstractGraph(int v) {
        this.v = v;
    }

    public int v() { return v; }
}
