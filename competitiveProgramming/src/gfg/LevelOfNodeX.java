package gfg;
/**
 * @level_Of_Node_X_in_Graph
 * @BFS @IndexArray @Graph
 * @GFG
 */
//https://practice.geeksforgeeks.org/problems/level-of-nodes1147/0/?track=amazon-graphs&batchId=192#
import java.util.*;
public class LevelOfNodeX {
	
	public static int findLevelOfX(int v, ArrayList<ArrayList<Integer>> graph, int x) {
		
		int[] index = new int[v+1];	//storing level of every node in its index value
		boolean[] visited = new boolean[v+1]; //marking whether node is visited or not
		Queue<Integer> queue = new LinkedList<Integer>(); //queue used because of BFS appraoch
		
		queue.offer(0); //offering 0 to queue as initial 
		index[0] = 0;
		visited[0] = true;
		
		while(queue.isEmpty() == false) {
			
			int curr = queue.poll();
			
			for(int i: graph.get(curr)) {
				
				if(visited[i] == false) {
					
					visited[i] = true;
					index[i] = index[curr] +1; //level of node 'i' is +1 level of its parent
					queue.offer(i);
				}
			}
		}
		//return nth node level
		return index[x];
	}
	
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>(8);
		
		for(int i = 0; i <8; i++)
		    graph.add(new ArrayList<Integer>());

		graph.get(0).add(1); 
		graph.get(0).add(2); 
		graph.get(1).add(3); 
		graph.get(1).add(4);
		graph.get(1).add(5); 
		graph.get(2).add(5); 
		graph.get(2).add(6); 
		graph.get(6).add(7);
		
		System.out.println("Level of 7: "+findLevelOfX(8, graph, 7));
	}
	
}
