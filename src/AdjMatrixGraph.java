import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class AdjMatrixGraph {
    private boolean adjMatrix[][];
    private int numVertices;

    public AdjMatrixGraph(int numVertices){
        this.numVertices = numVertices;
        this.adjMatrix = new boolean[numVertices][numVertices];
    }

    public void addEdge(int i, int j){
        adjMatrix[i][j] = true;
        adjMatrix[j][i] = true;
    }

    public void removeEdge(int i, int j){
        adjMatrix[i][j] = false;
        adjMatrix[j][i] = false;
    }

    public void bfs(int start, int end) {
        boolean[] visited = new boolean[adjMatrix.length];
        Queue<Integer> queue = new ArrayDeque<>();

        visited[start] = true;
        queue.offer(start);
        System.out.println("BFS, Caminho de " + start + " para " + end + ": ");
        while(!queue.isEmpty()) {

            int current = queue.poll();

            System.out.print(current + " ");
            if(current == end){
                return;
            }
            for(int i = 0;i<adjMatrix.length;i++){
                if(adjMatrix[current][i] && !visited[i]){
                    visited[i] = true;
                    queue.offer(i);
                }
            }

        }
        System.out.println();
        for(int i = 0; i<visited.length;i++){
            if(!visited[i] && (i == end)){
                System.out.println("\nNão há caminho entre: " + start + " " + end);
                return;
            }
        }

    }

    public void dfs(int start){
        boolean[] visited = new boolean[adjMatrix.length];
        Stack<Integer> stack = new Stack<>();

        visited[start] = true;
        stack.push(start);

        System.out.println("DFS a partir de: " + start);

        while(!stack.isEmpty()){
            int current  = stack.pop();
            System.out.print(current + " ");

            for(int i=0;i<adjMatrix.length;i++){
                if(adjMatrix[current][i] && !visited[i]){
                    visited[i] = true;
                    stack.push(i);
                }
            }

        }
        System.out.println();

    }



    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (boolean j: adjMatrix[i]) {
                s.append((j ? 1 : 0) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
}
