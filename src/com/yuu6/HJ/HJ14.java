package com.yuu6.HJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: yuu6
 * @Date: 2022/05/28/下午7:39
 */
public class HJ14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        List<String> strs = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            strs.add(scanner.next());
        }
        Collections.sort(strs);
        for (int i = 0; i < strs.size(); i++) {
            System.out.println(strs.get(i));
        }
    }
}
