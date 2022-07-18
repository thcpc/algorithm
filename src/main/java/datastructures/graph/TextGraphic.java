package datastructures.graph;

import std.In;

import java.io.IOException;

public class TextGraphic implements Graph {

    private int V;
    private int E;

    private Bag<Integer>[] adj;

    public TextGraphic(int v){
        this.V = v;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[v];
        for(int i = 0; i< v;i++){
            adj[i] = new Bag<Integer>();
        }
    }

    public TextGraphic(In in) throws IOException {
        this(in.readInt());
        int e = in.readInt();
        for(int i = 0;i < e; i++){
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v,w);
        }
    }

    @Override
    public int v() { return this.V; }

    @Override
    public int e() { return this.E; }


    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return this.adj[v];
    }

    @Override
    public String toString() {
        for(int i= 0;i<adj.length; i++){
            System.out.print( i+ ":");
            adj[i].forEach(System.out::print);
            System.out.println("");
        }
        return "";
    }
}
