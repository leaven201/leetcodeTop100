package top100.medium._62_Unique_Paths.回溯;

/**
 * @author LinZebin
 * @date 2019-09-18 15:13
 */
public class Solution {
    public boolean exist(char[][] board, String word) {

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, visited, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 递归定义：从(x,y)点出发，在标记过是否访问过的visited[][]基础上，判断是否可以找到word中从index到尾的字符
     * @param board   单词矩阵
     * @param word    搜索单词
     * @param visited 是否访问
     * @param index   当前搜索单词中第index个字符
     * @param x       单词矩阵位置x
     * @param y       单词矩阵位置y
     * @return
     */
    private boolean dfs(char[][] board, String word, boolean[][] visited, int index, int x, int y) {

        // 递归的出口
        // 1.index已经到达尾部了，即已经找到匹配的
        if (index == word.length()) {
            return true;
        }
        // 2.(x,y)越界了
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return false;
        }
        // 3.(x,y)已经被访问过
        if (visited[x][y]) {
            return false;
        }
        // 4.(x,y)位置的字母与word中index下标不匹配
        if (board[x][y] != word.charAt(index)) {
            return false;
        }

        // 此时说明(x,y)的字母满足条件，将(x,y)标记为访问过，然后递归从该点的上下左右出发去寻找匹配index+1个字母
        visited[x][y] = true;
        boolean result = dfs(board, word, visited, index + 1, x - 1, y)// 上
            || dfs(board, word, visited, index + 1, x + 1, y)// 下
            || dfs(board, word, visited, index + 1, x, y - 1)// 左
            || dfs(board, word, visited, index + 1, x, y + 1);// 右
        // 回溯，将(x,y)点从新标记为未放问，从别点出发
        visited[x][y] = false;
        return result;
    }
}
