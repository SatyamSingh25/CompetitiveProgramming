package graph;
import java.util.*;
public class BFS {
	public static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination) {
		graph.get(source).add(destination);
		graph.get(destination).add(source);
	}
	public static void printGraph(ArrayList<ArrayList<Integer>> arr) {
		for(int i=0; i<arr.size(); i++) {
			System.out.print(i+" node:");
			for(int j=0; j<arr.get(i).size(); j++){
				System.out.print("->" + arr.get(i).get(j));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>(vertices);
		for(int i=0; i<vertices; i++) {
			arr.add(new ArrayList<Integer>());
		}
		int edges = sc.nextInt();
		for(int i=0; i<edges; i++) {
			addEdge(arr, sc.nextInt(), sc.nextInt());
		}
		printGraph(arr);
		//bfs(arr);
		sc.close();
	}

}
