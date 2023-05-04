import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class AdjListGraph {
    private int size;
    private LinkedList<Integer> adj[];

    AdjListGraph(int size){
        this.size = size;
        this.adj = new LinkedList[size];
        for(int i = 0; i < size; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destiny) {
        adj[source].add(destiny);
    }

    public void BFS (int source, int destiny) {
        boolean[] visited = new boolean[size];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[source] = true;
        queue.add(source);
        System.out.println("BFS, Caminho de " + source + " para " + destiny + ": ");
        while(queue.size() != 0) {
            int initial = queue.poll();
            System.out.print(initial + " ");

            for (int current : adj[initial]) {
                if (!visited[current]) {
                    visited[current] = true;
                    queue.add(current);
                }
            }

        }
        System.out.println();
        for(int i=0;i<size;i++){
            if(!visited[i] && (i == destiny)){
                System.out.println("\nNão há caminho entre: " + source + " " + destiny);
                return;
            }
        }
    }

    public void DFS(int source){
        boolean[] visited = new boolean[size];
        Stack<Integer> stack = new Stack<>();

        visited[source] = true;
        stack.push(source);
        System.out.println("DFS a partir de: " + source);

        while(!stack.isEmpty()){
            source = stack.pop();
            System.out.printf(source + " ");
            for(int current : adj[source]){
                if(!visited[current]){
                    visited[current] = true;
                    stack.push(current);
                }
            }
        }
        System.out.println();


    }
}
