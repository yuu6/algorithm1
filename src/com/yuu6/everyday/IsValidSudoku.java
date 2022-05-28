package com.yuu6.everyday;

import java.util.Arrays;

/**
 * @Author: yuu6
 * @Date: 2022/05/26/上午8:31
 */
public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[] find = new boolean[9];
        // 检测行
        for (int i = 0; i < board.length; i++) {
            Arrays.fill(find, false);
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                boolean res = setC(c, find);
                if (!res){
                    return false;
                }
            }
        }

        // 检测列
        for (int i = 0; i < board[0].length; i++) {
            Arrays.fill(find, false);
            for (int j = 0; j < board.length; j++) {
                char c = board[j][i];
                boolean res = setC(c, find);
                if (!res){
                    return false;
                }
            }
        }

        for (int i = 1; i < board.length ; i+=3) {
            for (int j = 1; j < board[0].length ; j+=3) {
                boolean res = validSquare(i, j, find, board);
                if (!res){
                    return false;
                }
            }
        }

        return true;
    }

    private boolean validSquare(int i, int j, boolean[] find, char[][] board){
        Arrays.fill(find, false);
        int[] tempArr = new int[]{-1, 0, 1};
        for (int tempI:  tempArr) {
            for (int tempJ:  tempArr) {
                char c = board[i + tempI][j + tempJ];
                boolean res = setC(c, find);
                if (!res){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean setC(char c, boolean[] find) {
        if (c == '.'){
            return true;
        }
        int idx = c - '0' - 1;
        if (find[idx]){
            return false;
        }else{
            find[idx] = true;
            return true;
        }
    }
}
