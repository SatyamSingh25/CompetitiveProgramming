package graph;

import java.util.Scanner;

public class NumberOfIceLand {
	public static int maxArea = 0;
	public static void dfs(int[][] arr, int i,int j) {
		int row = arr.length;
		int col = arr[0].length;
		if(i<0||i>=row||j<0||j>=col) {
			return;
		}
		if(arr[i][j] != 1) {
			return;
		}
		arr[i][j] = 0;
		maxArea++;
		dfs(arr, i+1, j);
		dfs(arr, i-1, j);
		dfs(arr, i, j+1);
		dfs(arr, i, j-1);
		dfs(arr, i+1, j+1);
		dfs(arr, i+1, j-1);
		dfs(arr, i-1, j+1);
		dfs(arr, i-1, j-1);
		
	}
	public static int findNumberOfIceLand(int[][] arr, int n) {
		int count  = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(arr[i][j] == 1) {
					maxArea = 0;
					dfs(arr, i , j);
					count = Math.max(count, maxArea);
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}		
		int count = findNumberOfIceLand(arr, n);		
		System.out.println(count);
		
	}

}
