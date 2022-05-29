package com.yuu6.HJ;


import java.util.*;
import java.util.stream.Collectors;

public class HJ26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            LinkedList<CharO> arr = new LinkedList<>();

            for (int i = 0; i < str.length(); i++) {
                if (!Character.isLetter(str.charAt(i))){
                    continue;
                }else {
                    arr.add(new CharO(str.charAt(i), i));
                }
            }

            Collections.sort(arr);
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isLetter(str.charAt(i))){
                    arr.add(i, new CharO(str.charAt(i), i));
                }
            }
           List<Character> characters = arr.stream().map(o -> o.c).collect(Collectors.toList());
            StringBuilder sb = new StringBuilder();
            for (Character ch :characters){
                sb.append(ch);
            }
            System.out.println(sb.toString());
        }
    }

    static class CharO implements Comparable<CharO>{
        public Character c;
        public int index;

        public CharO(Character c, int index) {
            this.c = c;
            this.index = index;
        }

        @Override
        public int compareTo(CharO o) {
            Character thisC = Character.toLowerCase(c);
            Character thatC = Character.toLowerCase(o.c);
            return thisC.compareTo(thatC);
        }
    }
}