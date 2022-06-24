package datastructures.graph;

public class GraphUtils {

    /***
     * 计算v的度数
     * @param graph
     * @param v
     * @return
     */
    public static int degree(Graph graph, int v){
        int degree = 0;
        for(int w: graph.adj(v)) degree ++;
        return degree;
    }

    /****
     * 计算所有顶点最大的度数
     * @param graph
     * @return
     */
    public static int maxDegree(Graph graph){
        int max = 0;
        for(int v = 0; v<graph.v(); v++){
            if(degree(graph,v)>max) max = degree(graph,v);
        }
        return max;
    }

    /***
     * 计算所有顶点的平均度数
     * @param graph
     * @return
     */
    public static double avgDegree(Graph graph){
        return 2.0 * graph.e() / graph.v();
    }

    /***
     * 计算自环的个数
     * @param graph
     * @return
     */
    public static int numberOfSelfLoops(Graph graph){
        int count = 0;
        for(int v = 0; v<graph.v(); v++){
            for(int w:graph.adj(v))
                if (v==w) count ++;
        }
        return count/2;
    }
}
