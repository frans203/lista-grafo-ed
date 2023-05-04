public class Main {
    public static void main(String[] args) {
        //Grafo com lista de adjacência
        System.out.println("LISTA DE ADJACÊNCIA");
        AdjListGraph g = new AdjListGraph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(4, 4);

        g.BFS(0, 3);
        g.DFS(1);
        g.BFS(0,4);

        //Grafo com matrix de adjacência
        System.out.println();
        System.out.println("MATRIZ DE ADJACÊNCIA");
        AdjMatrixGraph graph = new AdjMatrixGraph(6);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(0,3);
        graph.addEdge(2,4);
        graph.addEdge(5,5);

        graph.dfs(0);
        graph.bfs(0, 4);
        System.out.println();
        graph.bfs(0,5);
    }
}