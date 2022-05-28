package com.yuu6.HJ;

import java.util.Scanner;

/**
 * @Author: yuu6
 * @Date: 2022/05/26/下午10:54
 */
public class HJ1 {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String pre = null;
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNext()) { // 注意 while 处理多个 case
                String line = in.nextLine();
                String[] strs = line.split(" ");
                System.out.println(strs[strs.length - 1].length());
            }
        }
}
