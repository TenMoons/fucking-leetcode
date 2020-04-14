package Explore.queueandstack;

/**
 * 图像渲染
 */

public class Solution_16 {
    private int R;
    private int C;
    private int val;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        val = image[sr][sc];
        R = image.length;
        C = image[0].length;
        return dfs(image, sr, sc, newColor);
    }

    public int[][] dfs(int[][] image, int i, int j, int newColor){
        if(!validate(i, j) || image[i][j] == newColor || image[i][j] != val){

        } else{
            image[i][j] = newColor;
            dfs(image, i + 1, j, newColor);
            dfs(image, i - 1, j, newColor);
            dfs(image, i, j + 1, newColor);
            dfs(image, i, j - 1, newColor);
        }
        return image;
    }

    private boolean validate(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }

}
