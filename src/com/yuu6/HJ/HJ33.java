package com.yuu6.HJ;

import java.util.*;
import java.util.stream.Collectors;

public class HJ33 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String a = in.next();
            Long b = in.nextLong();
            System.out.println(convert(a));
            System.out.println(reverseConvert(b));
        }
    }

    private static String reverseConvert(Long b) {
        char[] characters = Long.toBinaryString(b).toCharArray();
        List<Integer> resList = new ArrayList<>();
        for (int j = 0; j < 4; j++) {
            int res = 0;
            for (int i = 7; i >= 0; i--) {
                int index = j * 8 + i;
                char c = index<characters.length?characters[characters.length - 1 - index] :'0';
                res = res * 2 + c - '0';
            }
            resList.add(res);
        }
        Collections.reverse(resList);

        return (String) resList.stream().map(a -> String.valueOf(a)).collect(Collectors.joining("."));
    }

    private static Long convert(String a) {
        String[] arrs = a.split("\\.");
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < arrs.length; i++) {
            String tempStr = arrs[i];
            Integer aInt = Integer.parseInt(tempStr);

            LinkedList<Integer> arr = new LinkedList<>();
            while (aInt > 0){
                arr.add(0, aInt % 2);
                aInt /= 2;
            }

            int size = arr.size();
            for (int j = 0; j < 8 - size; j++) {
                arr.add(0, 0);
            }

            resList.addAll(arr);
        }

        Long sumRes = 0L;
        for (int i = 0; i < resList.size(); i++) {
            sumRes = sumRes *2 + resList.get(i);
        }
        return sumRes;
    }
}