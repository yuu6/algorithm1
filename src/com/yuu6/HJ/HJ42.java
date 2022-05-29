package com.yuu6.HJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HJ42 {
    public static int min = Integer.MAX_VALUE;
    public static List<List<Integer>> minArr  = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            int[][] input = new int[a][b];

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    input[i][j] = in.nextInt();
                }
            }

            Boolean[][] visited = new Boolean[a][b];
            for (int i = 0; i < a; i++) {
                Arrays.fill(visited[i], false);
            }
            List<List<Integer>> arr = new ArrayList<>();
            visited[0][0] = true;
            arr.add(Arrays.asList(0,0));
            find(0,0,a-1,b-1,input, visited, arr);
            for (int i = 0; i < minArr.size(); i++) {
                System.out.println("(" + minArr.get(i).get(0) +","+  minArr.get(i).get(1) + ")");
            }
        }
    }

    private static boolean find(int i, int i1, int i2, int i3, int[][] input, Boolean[][] visited, List<List<Integer>> arr) {


        if (i == i2 && i3 == i1){
            if (arr.size() < min){
                minArr  = new ArrayList<>();
                min = arr.size();
                for (int j = 0; j < arr.size(); j++) {
                    minArr.add(new ArrayList<>(arr.get(j)));
                }
            }
            return true;
        }
        if (i - 1 >= 0 && input[i-1][i1] == 0 &&!visited[i - 1][i1]){
            arr.add(Arrays.asList(i-1, i1));
            visited[i - 1][i1] = true;
            boolean res = find(i - 1, i1, i2, i3,  input, visited, arr );
            if (res){
                return true;
            }
            arr.remove(arr.size() - 1);
            visited[i - 1][i1] = false;

        }
        if (i + 1 < input.length && input[i+1][i1] == 0 &&!visited[i + 1][i1]){
            arr.add(Arrays.asList(i+1, i1));
            visited[i + 1][i1] = true;
            boolean res = find(i + 1, i1, i2, i3,  input, visited,arr);
            if (res){
                return true;
            }
            arr.remove(arr.size() - 1);
            visited[i + 1][i1] = false;

        }
        if (i1 - 1 >= 0 && input[i][i1 - 1] == 0 &&!visited[i][i1 - 1]){
            arr.add(Arrays.asList(i, i1 - 1));
            visited[i ][i1 - 1] = true;

            boolean res = find(i , i1 - 1, i2, i3,  input, visited,arr);
            if (res){
                return true;
            }
            arr.remove(arr.size() - 1);
            visited[i ][i1 - 1] = false;

        }
        if (i1 + 1 < input[0].length && input[i][i1 + 1] == 0 &&!visited[i][i1 + 1]){
            arr.add(Arrays.asList(i, i1 + 1));
            visited[i ][i1 + 1] = true;

            boolean res = find(i , i1 + 1, i2, i3,  input, visited,arr);
            if (res){
                return true;
            }
            arr.remove(arr.size() - 1);
            visited[i ][i1 + 1] = false;

        }
        return false;

    }
}