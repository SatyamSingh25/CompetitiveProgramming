package graph;
/**
 * @Dijkstra_Algorithm_Shortest_Path
 */
//Dijkstra shortest path using BFS 
import java.util.*;
public class DijestraAlgo {
	//BFS using in Dijkstra's algorithm
	public static void DijkstraAlgo(int source,int vertices, ArrayList<ArrayList<Pair>> graph) {
		int dist[] = new int[vertices];
		PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Pair());
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[source] = 0;
		queue.add(new Pair(source, 0));
		
		while(queue.isEmpty() == false) {
			
			Pair curr = queue.poll();
			
			for(Pair i: graph.get(curr.node)) {
				
				if(dist[curr.node]+i.weight < dist[i.node]) {
					dist[i.node] = dist[curr.node]+i.weight;
					queue.add(new Pair(i.node, dist[i.node]));
				}
			}
		}
		
		for(int i=0; i<vertices; i++)
			System.out.println(source + " to " + i + " : " + dist[i]);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the number of vertices: ");
		int vertices = sc.nextInt();
		ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
		for(int i=0; i<vertices; i++) {
			graph.add(new ArrayList<Pair>());
		}
		
		System.out.println("Enter number of edges: ");
		int edges = sc.nextInt();
		
		System.out.println("Enter edges: ");
		for(int i=0; i<edges; i++) {
			graph.get(sc.nextInt()).add(new Pair(sc.nextInt(), sc.nextInt()));
		}
		//calling Dijkstra 
		DijkstraAlgo(sc.nextInt(), vertices, graph);
		sc.close();
	}
	
	//pair class and sort the elements according to weights
	static class Pair implements Comparator<Pair>{
		Pair(){};
		int node, weight;
		Pair(int n, int w){
			this.node = n;
			this.weight = w;
		}
		@Override
		public int compare(Pair node1, Pair node2) {
			if(node1.weight < node2.weight) {
				return -1;
			}
			else if(node1.weight > node2.weight){
				return 1;
			}
			return 0;
		}
	}
}
