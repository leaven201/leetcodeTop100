package others;

/**
 * @author LinZebin
 * @date 2019-08-15 23:34
 */
public class CountS {

    public int count(int[][] matrix) {
        int Row = matrix.length;
        int Column = matrix[0].length;
        // 遮挡面积
        int miss = 0;
        // 正方形总数
        int total = 0;
        for (int row = 0; row < Row; row++) {
            for (int col = 0; col < Column; col++) {
                total += matrix[row][col];
                // 该列高
                int curhight = matrix[row][col];
                if (curhight == 0){
                    continue;
                }
                // 左邻高
                int leftHight = countHight(row, col - 1, matrix);
                // 右邻高
                int rightHight = countHight(row, col + 1, matrix);
                // 上邻高
                int topHight = countHight(row - 1, col, matrix);
                // 下邻高
                int downHight = countHight(row + 1, col, matrix);
                int selfMiss = countSelfMiss(curhight);
                int leftMiss = countNeiborMiss(curhight, leftHight);
                int rightMiss = countNeiborMiss(curhight, rightHight);
                int topMiss = countNeiborMiss(curhight, topHight);
                int downMiss = countNeiborMiss(curhight, downHight);
                miss += leftMiss + rightMiss + topMiss + downMiss + selfMiss;
            }
        }
        return 6 * total - miss;
    }

    // 计算相邻的位置高度
    private int countHight(int row, int col, int[][] matrix) {
        int Row = matrix.length;
        int Column = matrix[0].length;
        if (row >= 0 && row < Row && col >= 0 && col < Column) {
            return matrix[row][col];
        }
        return 0;
    }

    // 计算两个相邻列会遮挡多少面积
    private int countNeiborMiss(int cur, int neibor) {
        // 临面遮挡
        int neiborMiss = Math.min(cur, neibor);
        return neiborMiss;
    }

    // 计算本列遮挡
    private int countSelfMiss(int height){
        return (height - 1) * 2;
    }

    public static void main(String[] args) {
        CountS s = new CountS();
        //int[][] matrix = {{1, 2}, {1, 1}};
        int[][] matrix = {
            {1,0,1,0,1},
            {0,1,0,1,0}
        };
        System.out.println(s.count(matrix));
    }
}
