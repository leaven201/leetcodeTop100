package top100.medium._200_NumberOfIslands;

import org.junit.Test;

/**
 * @author LinZebin
 * @date 2019-04-13 14:58
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] sameIsland = new boolean[grid.length][grid[0].length];
        int islands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                if (grid[row][column] == '1' && sameIsland[row][column] == false) {
                    islands++;
                }
                helper(grid, row, column, sameIsland);
            }
        }
        return islands;
    }

    //如果(x,y)是1，则将与其属于同一块岛屿的陆地('1')都设为sameIsland
    private void helper(char[][] grid, int x, int y, boolean[][] sameIsland) {
        //(x,y)越界
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return;
        }
        //(x,y不是1或者已经被访问过)
        if (grid[x][y] != '1' || sameIsland[x][y] == true) {
            return;
        }
        //从(x,y)的上下左右递归调用helper函数，将所有与其属于同一块岛屿的陆地('1')都设为sameIsland
        sameIsland[x][y] = true;
        helper(grid, x + 1, y, sameIsland);
        helper(grid, x - 1, y, sameIsland);
        helper(grid, x, y + 1, sameIsland);
        helper(grid, x, y - 1, sameIsland);
    }

    @Test
    public void test() {
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}};
        int islands = numIslands(grid);
        System.out.println(islands);
    }
}
