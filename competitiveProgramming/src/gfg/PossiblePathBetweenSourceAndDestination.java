package gfg;
import java.util.*;
public class PossiblePathBetweenSourceAndDestination {
	static int count =0 ;
    public static int countPaths(int V, ArrayList<ArrayList<Integer>> adj, int source,
                   int destination) {
        dfs(adj, source, destination);
        return count;
    }
    public static void dfs(ArrayList<ArrayList<Integer>> adj, int source,
                   int destination){
        if(source == destination){
            count++;
            return;
        }
        for(int i: adj.get(source)){
            dfs(adj, i, destination);
        }
        
    }
	public static void main(String[] args) {
		
	}

}
