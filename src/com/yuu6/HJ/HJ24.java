package com.yuu6.HJ;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: yuu6
 * @Date: 2022/05/29/上午8:47
 */
public class HJ24 {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNextInt()) { // 注意 while 处理多个 case
                int a = in.nextInt();
                List<Integer> arr = new ArrayList<>();
                for (int i = 0; i < a; i++) {
                    arr.add(in.nextInt());
                }
                System.out.println(getRes(arr));
            }
        }

    private static Integer getRes(List<Integer> arr) {
            int[] temp1 = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            int tempMax = 1;
            for (int j = 0; j < i; j++) {
                if (arr.get(j) < arr.get(i) && temp1[j] + 1 > tempMax){
                    tempMax = temp1[j] + 1;
                }
            }
            temp1[i] = tempMax;
        }

        int[] temp2 = new int[arr.size()];
        for (int i = arr.size() - 1; i > 0; i--) {
            int tempMax = 1;
            for (int j = arr.size() - 1; j > i; j--) {
                if (arr.get(j) < arr.get(i) && temp2[j] + 1 > tempMax){
                    tempMax = temp2[j] + 1;
                }
            }
            temp2[i] = tempMax;
        }

        int res = temp1.length - 1;
        for (int i = 0; i < temp1.length; i++) {
            int tempInt = temp1.length - temp1[i] - temp2[i] + 1;
            if (tempInt < res){
                res = tempInt;
            }
        }

        return res;
    }


}
