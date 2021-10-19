package graph;
import java.util.*;
public class WeightedGraphCreation {
	public static class Edge{
		int source, destination, weight;
		public Edge(int s, int d, int w) {
			this.source = s;
			this.destination = d;
			this.weight = w;
		}
	}
	public static void addEdge(ArrayList<ArrayList<Edge>> arr, int source, int destination, int weight) {
		Edge edge = new Edge(source, destination, weight);
		arr.get(source).add(edge);		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		ArrayList<ArrayList<Edge>> arr = new ArrayList<>(vertices);
		
		int edges = sc.nextInt();
		for(int i=0; i<edges; i++) {
			addEdge(arr, sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
	}

}
