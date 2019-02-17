package important;
/**
 * Given a non-empty 2D array grid of 0's and 1's, 
 * an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) 
 * You may assume all four edges of the grid are surrounded by water.
 * Find the maximum area of an island in the given 2D array. 
 * (If there is no island, the maximum area is 0.)
 */
public class MaxAreaOfIsland {

	public static void main(String[] args) {
		
		int[][] testCase1 = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
			                 {0,0,0,0,0,0,0,1,1,1,0,0,0},
			                 {0,1,1,0,1,0,0,0,0,0,0,0,0},
			                 {0,1,0,0,1,1,0,0,1,0,1,0,0},
			                 {0,1,0,0,1,1,0,0,1,1,1,0,0},
			                 {0,0,0,0,0,0,0,0,0,0,1,0,0},
			                 {0,0,0,0,0,0,0,1,1,1,0,0,0},
			                 {0,0,0,0,0,0,0,1,1,0,0,0,0}};
		
		int[][] testCase2 = {{0,0,0,0,0,0,0,0}};
		
		Solution s = new Solution();
		System.out.println(s.maxAreaOfIsland(testCase1));
		
		System.out.println(s.maxAreaOfIsland(testCase2));

	}
}
	
	class Solution {
	    int[][] grid;
	    boolean[][] seen;
	    
	    public int maxAreaOfIsland(int[][] grid) {
	        this.grid = grid;
	        seen = new boolean[grid.length][grid[0].length];
	        int ans = 0;
	        for (int row = 0; row < grid.length; row++) {
	            for (int col = 0; col < grid[0].length; col++) {
	                ans = Math.max(ans, area(row, col));
	            }
	        }
	        return ans;
	    }

	    // recursive function
	    public int area(int row, int col) {
	        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length ||
	                seen[row][col] || grid[row][col] == 0)
	            return 0;
	        seen[row][col] = true;
	        return (1 + area(row+1, col) + area(row-1, col)
	                  + area(row, col-1) + area(row, col+1));
	    }
	    
	}

