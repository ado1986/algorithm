package algorithm.leetcode.dfs;

public class NumIslands {

    public int numIslands(char[][] grid) {
        int num = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) { // 为'1'且未被访问
                    num++;
                    dfs(visited, grid, i, j);
                }
            }
        }
        return num;
    }


    /**
     * 递归打标
     *
     * @param visited
     * @param grid
     * @param i
     * @param j
     */
    private void dfs(boolean[][] visited, char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) { // 到了边界
            return;
        }

        if (grid[i][j] == '0' || visited[i][j]) { // 为'0' 或已被访问
            return;
        }

        if (grid[i][j] == '1' && !visited[i][j]) { // 设置访问标记
            visited[i][j] = true;
        }

        dfs(visited, grid, i - 1, j); // 上
        dfs(visited, grid, i + 1, j); // 下
        dfs(visited, grid, i, j - 1); //左
        dfs(visited, grid, i, j + 1); // 右
    }

    public static void main(String[] args) {
        NumIslands numIslands = new NumIslands();
        char[][] grid = new char[][]{{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        int num = numIslands.numIslands(grid);
        System.out.println(num);
    }


}
