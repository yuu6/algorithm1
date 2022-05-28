package com.yuu6.HJ;

import java.util.Scanner;

/**
 * @Author: yuu6
 * @Date: 2022/05/28/下午7:02
 */
public class HJ5 {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNext()) { // 注意 while 处理多个 case
                String str = in.next();
                int res = 0;
                for (int i = 2; i < str.length(); i++) {
                    Character c = str.charAt(i);
                    int aInt = 0;
                    if (c >='A' && c <= 'F' ){
                        aInt = c - 'A' + 10;
                    }else if( c >='a' && c <= 'f'){
                        aInt = c - 'a' + 10;
                    }else if(c >= '0' && c <= '9'){
                        aInt = c - '0';
                    }
                    res = res * 16 + aInt;
                }
                System.out.println(res);
            }
    }
}
