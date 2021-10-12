package graph;

import java.util.*;

public class BFSinMat {
	
	static int[] dRow = new int[] {-1,0,1,0};
	static int[] dCol = new int[] {0,1,0,-1};
	
	static class Pair{
		int i, j;
		Pair(int x, int y){
			this.i = x;
			this.j = y;
		}
	}
	
	public static boolean isValid(boolean[][] visited , int i, int j) {
		int row = visited.length;
		int col = visited[0].length;
		if(i<0 || i>=row || j<0 || j>=col) {
			return false;
		}
		if(visited[i][j] == true) {
			return false;
		}
		return true;
	}
	
	public static void bfs(int i, int j, int[][] mat, boolean[][] visited) {
		Queue<Pair> queue = new LinkedList<Pair>();
		queue.add(new Pair(i, j));
		visited[i][j] = true;
		while(queue.isEmpty() == false) {
			Pair curr = queue.poll();
			int x = curr.i;
			int y = curr.j;
			System.out.print(mat[x][y] + " ");
			for(int t=0; t<4; t++) {
				int adj_x = x + dRow[t];
				int adj_y = y + dCol[t];
				if(isValid(visited, adj_x, adj_y)){
					queue.add(new Pair(adj_x, adj_y));
					visited[adj_x][adj_y] = true;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] mat = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		for(int i=0 ;i<n; i++) {
			for(int j=0; j<m; j++) {
				mat[i][j] = sc.nextInt();
			}
		}
		bfs(0, 0, mat, visited);
		sc.close();
	}
	
}
