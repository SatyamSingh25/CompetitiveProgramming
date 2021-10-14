package gfg;

public class Max_area_of_1s_or_iceLand {
	public static  int dfs(int i, int j, int[][] grid, int count){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0)
            return 0;
        
        grid[i][j] = 0;
        
        return 1+dfs(i+1, j, grid, count)
                +dfs(i-1, j, grid, count)
                +dfs(i, j+1, grid, count)
                +dfs(i, j-1, grid, count)
                +dfs(i+1, j+1, grid, count)
                +dfs(i-1, j+1, grid, count)
                +dfs(i-1, j-1, grid, count)
                +dfs(i+1, j-1, grid, count);
       
        
    }
    public static int findMaxArea(int[][] grid)
    {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
                    max = Math.max(max, dfs(i, j, grid, 0));
                }
            }
        }
        return max;
    }
	public static void main(String[] args) {
		int[][] grid = {{1,1,1,0},
						{0,0,1,0},
						{0,0,0,1}};
		System.out.println(findMaxArea(grid));
	}

}
