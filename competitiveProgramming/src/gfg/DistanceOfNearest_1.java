package gfg;
/**
 * @Distance_of_nearest_1
 * @Queue
 * @2_Approaches @GFG
 */
// https://practice.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1/?track=amazon-graphs&batchId=192#
import java.util.*;
public class DistanceOfNearest_1 {
	static class Pair{
		int i, j;
		Pair(int i, int j){
			this.i = i;
			this.j = j;
		}
	}
	//approach 2
	//TC: O(NM)
	//Space: O(NM)
	public static void findNearestOne(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;
		int[][] res = new int[row][col];
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				res[i][j] = Integer.MAX_VALUE;
			}
		}
		Queue<Pair> queue = new LinkedList<Pair>();
		
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++) {
				if(grid[i][j] == 1) {
					res[i][j] = 0;
					queue.add(new Pair(i, j));
				}
			}
		}
		while(queue.isEmpty()==false) {
			int i = queue.peek().i;
			int j = queue.peek().j;
			
			if((i-1)>=0 && i-1<row && res[i-1][j] > res[i][j]+1) {
				res[i-1][j] = res[i][j]+1;
				queue.add(new Pair(i-1, j));
			}
			if((i+1)<row && res[i+1][j] > res[i][j]+1) {
				res[i+1][j] = res[i][j]+1;
				queue.add(new Pair(i+1, j));
			}
			if((j-1)>=0 && res[i][j-1] > res[i][j]+1) {
				res[i][j-1] = res[i][j]+1;
				queue.add(new Pair(i, j-1));
			}
			if((j+1)<col && res[i][j+1] > res[i][j]+1) {
				res[i][j+1] = res[i][j]+1;
				queue.add(new Pair(i, j+1));
			}
			queue.poll();
		}
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	//approach 2
	//TC: O(NM) + (zero * one)
	//space: O(1)
	public static int[][] nearest(int[][] grid)
    {
        int row = grid.length;
        int col = grid[0].length;
        ArrayList<Pair> one = new ArrayList<Pair>();
        ArrayList<Pair> zero = new ArrayList<Pair>();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == 1){
                    one.add(new Pair(i, j));
                    grid[i][j] = 0;
                }
                else{
                    zero.add(new Pair(i, j));
                }
            }
        }
        for(int i=0; i<zero.size(); i++){
            int zi = zero.get(i).i;
            int zj = zero.get(i).j;
            int min = Integer.MAX_VALUE;
            for(int j=0; j<one.size(); j++){
                int ci = Math.abs(zi-one.get(j).i);
                int cj = Math.abs(zj-one.get(j).j);
                min = Math.min(min, ci+cj);
            }
            grid[zi][zj] = min;
        }
        return grid;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] arr = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		//calling function approach 1
		nearest(arr);
		//calling function approach 2
		findNearestOne(arr);
		sc.close();
	}

}
