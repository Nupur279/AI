import java.util.*;
class Node implements Comparable<Node> {
 int[][] data;
 int level;
 int fval;
 public Node(int[][] data, int level) {
 this.data = data;
 this.level = level;
 this.fval = 0; // Will be set externally
 }
 public List<Node> generateChildren(int[][] goal) {
 List<Node> children = new ArrayList<>();
 int x = -1, y = -1;
 for (int i = 0; i < this.data.length; i++) {
 for (int j = 0; j < this.data[i].length; j++) {
 if (this.data[i][j] == 0) {
 x = i;
 y = j;
 break;
 }
 }
 if (x != -1) break; // Found the blank space, exit loop
 }
 int[][] directions = {{x, y-1}, {x, y+1}, {x-1, y}, {x+1, y}};
 for (int[] dir : directions) {
 if (dir[0] >= 0 && dir[0] < this.data.length && dir[1] >= 0 && dir[1] < this.data[0].length) 
{
 int[][] newData = copyData();
 newData[x][y] = newData[dir[0]][dir[1]];
 newData[dir[0]][dir[1]] = 0;
 Node childNode = new Node(newData, this.level + 1);
 childNode.fval = calculateHeuristic(newData, goal) + childNode.level;
 children.add(childNode);
 }
 }
 return children;
 }
 private int[][] copyData() {
 int[][] newData = new int[this.data.length][];
 for (int i = 0; i < this.data.length; i++) {
 newData[i] = Arrays.copyOf(this.data[i], this.data[i].length);
 }
 return newData;
 }
 public int calculateHeuristic(int[][] data, int[][] goal) {
 int h = 0;
 for (int i = 0; i < data.length; i++) {
 for (int j = 0; j < data[i].length; j++) {
 if (data[i][j] != 0 && data[i][j] != goal[i][j]) {
 h++;
 }
 }
 }
 return h;
 }
 @Override
 public int compareTo(Node other) {
 return Integer.compare(this.fval, other.fval);
 }
 // Ensure Nodes with the same state are considered equal for HashSet operations
 @Override
 public boolean equals(Object obj) {
 if (this == obj) return true;
 if (obj == null || getClass() != obj.getClass()) return false;
 Node node = (Node) obj;
 return Arrays.deepEquals(data, node.data);
 }
 @Override
 public int hashCode() {
 return Arrays.deepHashCode(data);
 }
}
public class PuzzleSolver {
 private final int size;
 private final PriorityQueue<Node> open;
 private final Set<Node> closed;
 private final int[][] goal;
 public PuzzleSolver(int size, int[][] start, int[][] goal) {
 this.size = size;
 this.open = new PriorityQueue<>();
 this.closed = new HashSet<>();
 this.goal = goal;
 Node startNode = new Node(start, 0);
 startNode.fval = startNode.calculateHeuristic(start, goal) + startNode.level;
 open.add(startNode);
 }
 public void solve() {
 while (!open.isEmpty()) {
 Node current = open.poll();
 if (Arrays.deepEquals(current.data, goal)) {
 System.out.println("Goal state reached at level " + current.level);
 return; // Solution found
 }
 closed.add(current);

 for (Node child : current.generateChildren(goal)) {
    if (!closed.contains(child) && !open.contains(child)) {
    open.add(child);
 }
 }
 }
 System.out.println("Solution not found."); // No solution
 }
 public static void main(String[] args) {
 // Example start and goal states
 int[][] start = {{1, 2, 3}, 
                  {4, 0, 5}, 
                  {7, 8, 6}};

 int[][] goal = {{1, 2, 3}, 
                 {4, 5, 6}, 
                 {7, 8, 0}};

 PuzzleSolver solver = new PuzzleSolver(3, start, goal);
 solver.solve();
 } 
}