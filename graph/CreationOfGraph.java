package graph;
import java.util.*;
public class CreationOfGraph {
	public static void addEdge(ArrayList<ArrayList<Integer>> graph, int source, int destination) {
		graph.get(source).add(destination);
		graph.get(destination).add(source);
	}
	public static void printGraph(ArrayList<ArrayList<Integer>> graph) {
		for(int i=0; i<graph.size(); i++) {
			System.out.print(i + ":");
			for(int j=0; j<graph.get(i).size(); j++) {
				System.out.print("->" + graph.get(i).get(j));
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(vertices);
		for(int i=0; i<vertices; i++){
				graph.add(new ArrayList<Integer>());
		}
		
		int edges = sc.nextInt();
		for(int i=0; i<edges; i++) {
			addEdge(graph, sc.nextInt(), sc.nextInt());
		}
		printGraph(graph);
		sc.close();
	}
}
