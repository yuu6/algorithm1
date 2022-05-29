package com.yuu6.HJ;

import java.util.*;

public class HJ41 {
    private static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int[] w = new int[a];
            int[] n = new int[a];
            for (int i = 0; i < a; i++) {
                w[i] = in.nextInt();
            }

            for (int i = 0; i < a; i++) {
                n[i] = in.nextInt();
            }
            set.add(0);
            List<Integer> wSet = new ArrayList<>();
            for (int i = 0; i < a; i++) {
                for (int j = 0; j < n[i]; j++) {
                    wSet.add(w[i]);
                }
            }

            for (int i = 0; i < wSet.size(); i++) {
                Set<Integer> newSet = new HashSet<>(set);
                for (Integer e: set) {
                    newSet.add(wSet.get(i) + e);
                }
                set = newSet;
            }

            System.out.println(set.size());
        }
    }
}