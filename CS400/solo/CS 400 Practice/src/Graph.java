import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
  int size;
  LinkedList<Integer> list[];

  public Graph(int size) {
    this.size = size;
    list = new LinkedList[size];
    for (int i = 0; i<size; i++) {
      list[i] = new LinkedList<>();
    }
  }

  public void addEdge(int source, int destination){
    //add edge
    list[source].add(destination);
    //add back edge
    list[destination].add(source);
  }

  public void printGraph(){
    for (int i = 0; i<size; i++) {
      if(list[i].size()>0) {
        System.out.print("Vertex " + i + " is connected to: ");
        for (int j = 0; j < list[i].size(); j++) {
          System.out.print(list[i].get(j) + " ");
        }
        System.out.println();
      }
    }
  }
  
  public void bfsTraversal(int v) {
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[size];
    q.add(v);
    visited[v] = true;
    while(q.size()>0) {
      v = q.remove();
      System.out.print(v+" ");
      Iterator<Integer> i = list[v].listIterator();
      while(i.hasNext()) {
        int n = i.next();
        if(!visited[n]) {
          visited[n] = true;
          q.add(n);
        }
      }
    }
    System.out.println();
  }
  
  public void dfsTraversal(int v) {
    boolean[] visited = new boolean[size];
    dfsHelper(v, visited);
  }
  
  public void dfsHelper(int v, boolean[] visited) {
    visited[v] = true;
    System.out.print(v+" ");
    Iterator<Integer> i = list[v].listIterator();
    while(i.hasNext()) {
      int n = i.next();
      if(!visited[n]) {
        dfsHelper(n, visited);
      }
    }
    
  }

  public static void main(String[] args) {
    Graph graph = new Graph(11);
    graph.addEdge(1, 4);
    graph.addEdge(1, 2);
    graph.addEdge(4, 3);
    graph.addEdge(2, 3);
    graph.addEdge(3, 10);
    graph.addEdge(3, 9);
    graph.addEdge(2, 5);
    graph.addEdge(2, 7);
    graph.addEdge(2, 8);
    graph.addEdge(5, 8);
    graph.addEdge(7, 5);
    graph.addEdge(7, 8);
    graph.addEdge(5, 6);
      
    graph.printGraph();
    
    graph.bfsTraversal(1);
    graph.dfsTraversal(1);
  }
}