import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
public class DFSTraversal { 
 private LinkedList<Integer> adjacency[];
 public DFSTraversal(int vertices)
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
 public void dfs(int source)
 {
 boolean visitedNodes[] = new boolean[adjacency.length];
 int parentNodes[] = new int[adjacency.length];
 Stack<Integer> stack = new Stack<>();
 stack.add(source);
 visitedNodes[source] = true;
 parentNodes[source] = -1;
 System.out.print("DFS Traversal is: ");
 while (!stack.isEmpty()) //run the loop untli stack is not empty
 {
 int element = stack.pop();
 System.out.print(element+ ", ");
 for (int i: adjacency[element])
 {
 if(visitedNodes[i] != true)
 {
 visitedNodes[i] = true;
 stack.add(i);
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
 DFSTraversal g = new DFSTraversal(vertices);
 System.out.println("Enter the number of Edges: ");
 for (int i = 0; i < edges; i++)
 {
 int sv = sc.nextInt();
 int dv = sc.nextInt();
 g.insertedge(sv, dv);
 }
 
 System.out.println("Enter the source vertice for traversal: ");
 int source = sc.nextInt();
 g.dfs(source);
 }
}
