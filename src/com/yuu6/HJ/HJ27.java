package com.yuu6.HJ;

import java.util.*;
import java.util.stream.Collectors;

public class HJ27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            List<String> arr = new ArrayList<>();
            for (int i = 0; i < a; i++) {
                arr.add(in.next());
            }

            String targetStr = in.next();
            int k = in.nextInt();

            List<String> resList = convertList(arr, targetStr);
            System.out.println(resList.size());
            if (resList.size() >= k) {
                System.out.println(resList.get(k - 1));
            }
        }
    }

    private static List<String> convertList(List<String> arr, String targetStr) {
        boolean[] judge = new boolean[arr.size()];
        Map<Character, Integer> targetMap = toMap(targetStr);

        List<Map.Entry> map1 = targetMap.entrySet().stream().sorted(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return Character.compare(o1.getKey(), o2.getKey());
            }
        }).collect(Collectors.toList());


        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).equals(targetStr)){
                judge[i] = false;
                continue;
            }
            Map<Character, Integer> resMap = toMap(arr.get(i));
            List<Map.Entry> map2 = resMap.entrySet().stream().sorted(new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return Character.compare(o1.getKey(), o2.getKey());
                }
            }).collect(Collectors.toList());

            boolean judgeRes = true;

            if (map1.size() != map2.size()){
                judgeRes=false;
            }else {
                for (int j = 0; j < map1.size(); j++) {
                    if (map1.get(j).getValue() != map2.get(j).getValue() || map1.get(j).getKey() != map2.get(j).getKey()) {
                        judgeRes = false;
                        break;
                    }
                }
            }
            judge[i] = judgeRes;
        }

        List<String> arr2 = new ArrayList<>();
        for (int i = 0; i < judge.length; i++) {
            if (judge[i]){
                arr2.add(arr.get(i));
            }
        }
        Collections.sort(arr2);
        return arr2;
    }

    private static Map<Character, Integer> toMap(String targetStr) {
        Map<Character, Integer> res = new HashMap<>();
        for (Character c :targetStr.toCharArray()) {
            int tempNum = res.getOrDefault(c, 0);
            res.put(c, tempNum + 1);
        }
        return res;
    }


}