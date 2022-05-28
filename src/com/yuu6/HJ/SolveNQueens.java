package com.yuu6.HJ;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: yuu6
 * @Date: 2022/05/28/下午4:00
 */
public class SolveNQueens {
    public List<List<String>> solveNQueens(int n) {
        int[][] visited = new int[n][n];
        for (int i = 0; i < visited.length; i++) {
            Arrays.fill(visited[i], -1);
        }
        List<List<String>> resList = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        step(visited, tempList, resList, n, 0);
        return resList;
    }

    private void step(int[][] visited, List<String> tempList, List<List<String>> resList, int maxRow, int tempRow) {
        if (tempRow == maxRow) {
            resList.add(new ArrayList<>(tempList));
            return;
        }

        for (int j = 0; j < visited.length; j++) {
            if (visited[tempRow][j] != -1) {
                continue;
            } else {
                putVisited(visited, tempRow, j);

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < visited.length; i++) {
                    if (i == j) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                tempList.add(sb.toString());

                step(visited, tempList, resList, maxRow, tempRow + 1);

                tempList.remove(tempList.size() - 1);
                notPutVisited(visited, tempRow, j);
            }
        }
    }

    private void putVisited(int[][] visited, int tempRow, int j) {
        for (int i = 0; i < visited.length; i++) {
            for (int k = 0; k < visited.length; k++) {
                if (i-tempRow == k - j && visited[i][k] == -1){
                    visited[i][k] =tempRow;
                }
                if (i-tempRow == j- k && visited[i][k] == -1){
                    visited[i][k] =tempRow;
                }
                if (i-tempRow == 0 && visited[i][k] == -1){
                    visited[i][k] =tempRow;
                }
                if (j - k == 0&& visited[i][k] == -1 ){
                    visited[i][k] =tempRow;
                }
            }
        }
    }

    private void notPutVisited(int[][] visited, int tempRow, int j) {
        for (int i = 0; i < visited.length; i++) {
            for (int k = 0; k < visited.length; k++) {
                if (visited[i][k] == tempRow){
                    visited[i][k] = -1;
                }
            }
        }
    }

    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        List<List<String>> res = solveNQueens.solveNQueens(4);
        System.out.println(res);
    }
}
