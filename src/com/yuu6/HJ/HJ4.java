package com.yuu6.HJ;
import java.util.Scanner;

/**
 * @Author: yuu6
 * @Date: 2022/05/28/下午5:48
 */
public class HJ4 {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNext()) { // 注意 while 处理多个 case
                String nextString = in.nextLine();
                StringBuilder res = new StringBuilder();
                for (int j = 0; j < nextString.length(); j++) {
                    if (j % 8 == 0 && j != 0) {
                        System.out.println(res.toString());
                        res.delete(0, res.length());
                    }
                    res.append(nextString.charAt(j));
                }
                if (res.length() == 8){
                    System.out.println(res.toString());

                }else {
                    if (res.length() != 0) {
                        for (int i = 0; i < 8 - nextString.length() % 8; i++) {
                            res.append(0);
                        }
                        System.out.println(res.toString());
                    }
                }

            }


        }
}
