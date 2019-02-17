
public class LongestPathInMatrix {

	/**
	 * Given an integer matrix, find the length of the longest increasing path. From
	 * each cell, you can either move to four directions: left, right, up or down.
	 * You may NOT move diagonally or move outside of the boundary
	 */
	public static void main(String[] args) {
		int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 },
				{ 18, 21, 23, 26, 30 } };
		System.out.println(longestIncreasingPath(matrix));
	}

	public static int longestIncreasingPath(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;

		int[] max = new int[1];
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				dfs(matrix, row, col, max, 1);
			}
		}

		return max[0];
	}

	public static void dfs(int[][] matrix, int row, int col, int[] max, int len) {

		max[0] = Math.max(max[0], len);

		int m = matrix.length;
		int n = matrix[0].length;

		int[] dirX = { -1, 0, 1, 0 };
		int[] dirY = { 0, 1, 0, -1 };

		for (int k = 0; k < 4; k++) {
			int x = row + dirX[k];
			int y = col + dirY[k];

			if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[row][col]) {
				dfs(matrix, x, y, max, len + 1);
			}
		}
	}

}
