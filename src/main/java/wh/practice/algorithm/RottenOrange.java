package wh.practice.algorithm;

/**
 * @author wanghuan
 * @date of submit 2020/03/05
 *
 * 在给定的网格中，每个单元格可以有以下三个值之一：
 *
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
 *
 * 返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 *
 * 示例 1：
 *
 * 输入：[[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 *
 * 示例 2：
 *
 * 输入：[[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
 *
 * 示例 3：
 *
 * 输入：[[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 *  
 *
 * 提示：
 *
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * grid[i][j] 仅为 0、1 或 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotting-oranges
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RottenOrange {
    public static void main(String[] args) {
        int[][] grid = {{0,2}};
        System.out.println(rotting(grid));
    }

    /**
     * @param grid 橘子网格
     * @return 全部腐烂需要的分钟数
     */
    public static int rotting(int[][] grid) {
        int up, down, left, right, centre, flag=0, progress=0, flag1=0;
        int[][] newGrid = grid.clone();
        for (int i=0; i<grid.length; i++){
            newGrid[i] = grid[i].clone();
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                centre = grid[i][j];
                up = (i == 0 ? 0 : grid[i-1][j]);
                down = (i == grid.length-1 ? 0 : grid[i+1][j]);
                left = (j == 0 ? 0 : grid[i][j-1]);
                right = (j == grid[0].length-1 ? 0 : grid[i][j+1]);
                if (centre == 1 && (up==2 || down==2 || left==2 || right==2)) {
                    newGrid[i][j] = 2;
                    progress++;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    flag1 = 1;
                }
                if (newGrid[i][j] == 1) {
                    flag = 1;
                }
            }
        }
        if (flag1 == 0){
            return 0;
        }
        if (flag == 1) {
            if (progress == 0) {
                return -1;
            } else {
                int rotting = rotting(newGrid);
                return rotting == -1 ? -1 : rotting+1;
            }
        } else {
            return 1;
        }
    }
}
