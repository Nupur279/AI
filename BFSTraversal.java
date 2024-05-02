import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
public class BFSTraversal { //graph_implement
 private LinkedList<Integer> adjacency[];
 public BFSTraversal(int vertices)
 {
 adjacency = new LinkedList[vertices];
 for (int i = 0; i < vertices; i++)
 {
 adjacency[i] = new LinkedList<Integer>();
 }
 }
 public void insertedge(int sv, int dv)
 {
 adjacency[sv].add(dv);
 adjacency[dv].add(sv);
 System.out.print(adjacency[dv]);
 System.out.println(adjacency[sv]);
 }
 public void bfs(int source)
 {
 boolean visitedNodes[] = new boolean[adjacency.length];
 int parentNodes[] = new int[adjacency.length];
 Queue<Integer> queue = new LinkedList<>();
 queue.add(source);
 visitedNodes[source] = true;
 parentNodes[source] = -1;
 System.out.print("BFS Traversal is: ");
 while (!queue.isEmpty()) 
 {
 int element = queue.poll();
 System.out.print(element +" ");
 for (int i: adjacency[element])
 {
 if(visitedNodes[i] != true)
 {
 visitedNodes[i] = true;
 queue.add(i);
 parentNodes[i] = element;
 }
 }
 }
 }
 public static void main(String[] args) {
 Scanner sc = new Scanner(System.in);
 System.out.println("Enter the number of Vertices and Edges: ");
 int vertices = sc.nextInt();
 int edges = sc.nextInt();
 BFSTraversal g = new BFSTraversal(vertices);
 System.out.println("Enter the number of Edges: ");
 for (int i = 0; i < edges; i++)
 {
 int sv = sc.nextInt();
 int dv = sc.nextInt();
 g.insertedge(sv, dv);
 }
 System.out.println("Enter the source vertice for BFS traversal: ");
 int source = sc.nextInt();
 g.bfs(source);
 }
}
