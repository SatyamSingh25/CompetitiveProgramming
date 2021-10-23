package gfg;
/**
 * @DFS_Cycle_Detection_in_Directed_Graph
 * @Toposort : here i have to check where a toposort is possible or not. 
 * 				If we want to check Toposort is possible of not so wee have to check where there is Cycle or Not.
 * 				if cycle is present then Toposort is not possible other wise possible.
 * @Leetcode_207
 * @GFG_SDE_Sheet_Amazon   
 */
import java.util.*;
public class PrerequisitesTasks {
	
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(numCourses);
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0; i<prerequisites.length; i++){
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        if(isCycle(numCourses, graph)){
            return false;
        }
        return true;
    }

	//checking there is cycle present or not
    public static boolean isCycle(int vertices, ArrayList<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[vertices];
        boolean[] recVisited = new boolean[vertices];

        //iterating there all vertices
        for(int i=0; i<vertices; i++){
            if(visited[i] == false){
                if(isCycleUtil(i, graph, visited, recVisited)){
                    return true; // here we know there is a cycle in graph
                }
            }
        }
        //if cycle if not found then return false
        return false;
    }
    public static boolean isCycleUtil(int source, ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] recVisited){
        visited[source] = true;
        recVisited[source] = true;
        
        for(int i: graph.get(source)){
            if(visited[i] == false){
                if(isCycleUtil(i, graph, visited, recVisited)){
                    return true;
                }
            }
            else if(recVisited[i] == true){ // if visited & recVisited both are TRUE then there is cycle
                return true;
            }
        }
        //making parent unvisited for further processing
        recVisited[source] = false;
        return false;
    }

	public static void main(String[] args) {
		//input 1
		int totalCourses = 2;
		int[][] prerequisites = new int[][] {{1,0}};
		System.out.println(canFinish(totalCourses, prerequisites));
		
		//input 2
		int totalCourses2 = 2;
		int[][] prerequisites2 = new int[][] {{1,0},{0,1}};
		System.out.println(canFinish(totalCourses2, prerequisites2));
	}

}
