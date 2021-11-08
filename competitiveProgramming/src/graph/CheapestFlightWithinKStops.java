package graph;
/**
 * @Graph
 * @BFS
 * @Dijestra
 * @PriorityQueue
 * @author Satyam
 */
import java.util.*;
public class CheapestFlightWithinKStops {
	//pair class for graph
	static class Pair{
		int destiantion, weight;
		Pair(int des, int we){
			this.destiantion = des;
			this.weight = we;
		}
	}
	//Node class for queue
	static class Node{
		int source, weight, k;
		Node(int src, int we, int k){
			this.source = src;
			this.weight = we;
			this.k = k;				
		}
	}
	//Method
	public static int findMinCostFlight(int n, int[][] flights, int source, int destination, int k) {
		//Graph creation
		ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
		for(int i=0; i<n; i++) {
			graph.add(new ArrayList<Pair>());
		}
		//adding edges
		for(int i=0; i<flights.length; i++) {
			graph.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
		}
		
		//Min heap according to weight
		PriorityQueue<Node> queue = new PriorityQueue<Node>((a,b)->Integer.compare(a.weight, b.weight));
		queue.offer(new Node(source, 0, k));
		
		while(queue.isEmpty()==false) {
			Node temp = queue.poll();
			//result
			if(temp.source == destination) {
				return temp.weight;
			}
			//important condition
			if(temp.k >=0) {
				for(Pair i: graph.get(temp.source)) {
					queue.offer(new Node(i.destiantion, i.weight+temp.weight, temp.k-1));
				}
			}
		}
		
		return -1;
	}
	//Driver Code
	public static void main(String[] args) {
		int numberOfCities = 3;
		int[][] flights = new int[][] {{0,1,100},{1,2,100},{0,2,500}};
		int source = 0;	
		int destination = 2;
		int k = 0;
		System.out.println(findMinCostFlight(numberOfCities, flights, source, destination, k));
	}

}
