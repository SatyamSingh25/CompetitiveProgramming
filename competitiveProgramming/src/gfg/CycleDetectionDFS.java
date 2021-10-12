package gfg;
// https://practice.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1/?track=amazon-graphs&batchId=192#
//Cycle detection using DFS
import java.util.*;
public class CycleDetectionDFS {
	public boolean isCycleDFS(int curr, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adj){
        visited[curr] = true;
        for(int i: adj.get(curr)){
            if(visited[i] == false){
                if(isCycleDFS(i, curr, visited, adj)){
                    return true;
                }
            }
            else{
                if(parent != i){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isCycle(int v, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[v];
        for(int i=0; i<v; i++){
            if(visited[i] == false){
                if(isCycleDFS(i, -1, visited, adj)){
                    return true;
                }
            }
        }
        return false;
    }
}