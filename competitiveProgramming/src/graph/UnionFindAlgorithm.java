package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class UnionFindAlgorithm {
	public static void addEdge(ArrayList<ArrayList<Integer>> arr, int source, int destination) {
		arr.get(source).add(destination);
		arr.get(source).add(destination);
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
		sc.close();
	}
}