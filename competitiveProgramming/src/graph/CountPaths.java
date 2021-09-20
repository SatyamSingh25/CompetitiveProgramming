package graph;

import java.util.*;

public class CountPaths {
	public static void addEdge(ArrayList<ArrayList<Integer>> arr, int source, int destination) {
		arr.get(source).add(destination);
		arr.get(destination).add(source);
	}
	//logic method
	public static int findAllPathsCount(ArrayList<ArrayList<Integer>> arr, int source, int destination) {
		int countPaths = 0;
		countPaths = findPathCoutFromSource(arr, source,destination, countPaths);
		return countPaths;
	}
	//logic supporter method
	public static int findPathCoutFromSource(ArrayList<ArrayList<Integer>> arr, int source,int destination, int count) {
		//using DFS approach
		if(source == destination)
			count++;
		else {
			Iterator<Integer> itr = arr.get(source).iterator();
			while(itr.hasNext()) {
				int curr = itr.next();
				count = findPathCoutFromSource(arr, curr, destination, count);
			}
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int vertices = sc.nextInt();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		for(int i=0; i<vertices; i++) {
			arr.add(new ArrayList<Integer>());
		}
		int edges = sc.nextInt();
		for(int i=0; i<edges; i++) {
			addEdge(arr, sc.nextInt(), sc.nextInt());
		}
		System.out.println("Enter Source & Destination from where you want to find all paths to itself: ");
		int noOfPaths = findAllPathsCount(arr, sc.nextInt(), sc.nextInt());
	}
}
