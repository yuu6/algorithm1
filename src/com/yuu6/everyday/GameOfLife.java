package com.yuu6.everyday;

import java.util.function.Predicate;

/**
 * @Author: yuu6
 * @Date: 2022/07/25/12:54 PM
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] live = new int[m][n];
        int[][] die = new int[m][n];

        summaryByFunc(live, board, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer == 1;
            }
        });

        summaryByFunc(die, board, new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer == 0;
            }
        });

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1 && live[i][j] < 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 1 && live[i][j] >= 2 && live[i][j] <= 3){
                    board[i][j] = 1;
                }else if(board[i][j] == 1 && live[i][j] > 3){
                    board[i][j] = 0;
                }else if(board[i][j] == 0 && live[i][j] == 3){
                    board[i][j] = 1;
                }
            }
        }
    }

    private void summaryByFunc(int[][] targetArr, int[][] originArr, Predicate<Integer> integerPredicate) {
        for (int i = 0; i < originArr.length; i++) {
            for (int j = 0; j < originArr[0].length; j++) {
                int n = 0;
                if (i - 1 >= 0){
                    if (j - 1 >= 0){
                        if(integerPredicate.test(originArr[i - 1][j - 1])){
                            n += 1;
                        }
                    }
                    if(integerPredicate.test(originArr[i - 1][j])){
                        n += 1;
                    }
                    if (j + 1 < originArr[0].length){
                        if(integerPredicate.test(originArr[i - 1][j + 1])){
                            n += 1;
                        }
                    }
                }

                if (j - 1 >= 0){
                    if(integerPredicate.test(originArr[i][j - 1])){
                        n += 1;
                    }
                }
                if (j + 1 < originArr[0].length){
                    if(integerPredicate.test(originArr[i][j + 1])){
                        n += 1;
                    }
                }

                if (i + 1 < originArr.length){
                    if (j - 1 >= 0){
                        if(integerPredicate.test(originArr[i + 1][j - 1])){
                            n += 1;
                        }
                    }
                    if(integerPredicate.test(originArr[i + 1][j])){
                        n += 1;
                    }
                    if (j + 1 < originArr[0].length){
                        if(integerPredicate.test(originArr[i + 1][j + 1])){
                            n += 1;
                        }
                    }
                }

                targetArr[i][j] = n;
            }

        }
    }
}
