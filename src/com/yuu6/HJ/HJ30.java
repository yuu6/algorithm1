package com.yuu6.HJ;

import java.util.*;

public class HJ30 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            String str1 = in.next();
            String str2 = in.next();

            String strAll= str1 + str2;
            List<Character> characters1 = new ArrayList<>();
            List<Character> characters2 = new ArrayList<>();
            for (int i = 0; i < strAll.length(); i++) {
                if (i % 2 ==0){
                    characters1.add(strAll.charAt(i));
                }else{
                    characters2.add(strAll.charAt(i));
                }
            }
            Collections.sort(characters1, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {

                    return Integer.compare(o1, o2);
                }
            });
            Collections.sort(characters2, new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {

                    return Integer.compare(o1, o2);
                }
            });

            List<Character> characters = new ArrayList<>();
            for (int i = 0; i < Math.max(characters1.size(), characters2.size()); i++) {
                if (characters1.size() > i){
                    characters.add(characters1.get(i));
                }
                if (characters2.size() > i){
                    characters.add(characters2.get(i));
                }
            }

            List<Character> res= new ArrayList<>();
            for (int i = 0; i < characters.size(); i++) {
                res.add(doConvert(characters.get(i)));
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < res.size(); i++) {
                sb.append(res.get(i));
            }
            System.out.println(sb.toString());
        }
    }

    private static Character doConvert(Character character) {
        Character[] characters = new Character[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        if (character >= '0' && character <= '9' || character >= 'a' && character <= 'f' || character >= 'A' && character <= 'F'){
            List<Integer> tempList = sixteenToTwo(character);
            int tempRes = 0;
            for (int i = 0; i < tempList.size(); i++) {
                tempRes = tempRes * 2 + tempList.get(i);
            }
            return characters[tempRes];
        }else{
            return character;
        }
    }

    private static List<Integer> sixteenToTwo(Character character) {
        Integer resInt = Character.isDigit(character)? character - '0' : Character.toLowerCase(character) - 'a' + 10;
        List<Integer> arr = new ArrayList<>();
        while (resInt > 0){
            arr.add(resInt % 2);
            resInt /= 2;
        }
        int size = arr.size();
        for (int i = 0; i < 4 - size; i++) {
            arr.add(0);
        }
        return arr;
    }


}

