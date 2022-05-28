package com.yuu6.everyday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: yuu6
 * @Date: 2022/05/24/下午10:04
 */
public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> charNum = getCountMap(p);
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()){
            return res;
        }

        int pre = 0;
        int post = 0;
        while(post < s.length()){
            if (!charNum.containsKey(s.charAt(post))){
                pre = post + 1;
                post = post + 1;
                charNum = getCountMap(p);
                continue;
            }else{
                int tempNum = charNum.get(s.charAt(post));
                charNum.put(s.charAt(post), tempNum - 1);
            }

            if ((post - pre) == (p.length() - 1)){
                boolean find = true;
                for (Map.Entry<Character, Integer> e :charNum.entrySet()) {
                    if (e.getValue() != 0){
                        find = false;
                    }
                }
                if (find){
                    res.add(pre);
                }

                int tempNum = charNum.get(s.charAt(pre));
                charNum.put(s.charAt(pre), tempNum + 1);
                pre++;

            }
            post++;
        }
        return res;
    }

    private Map<Character, Integer> getCountMap(String p) {
        Map<Character, Integer> charNum = new HashMap<>();
        for (Character c: p.toCharArray()){
            int num = charNum.getOrDefault(c, 0);
            charNum.put(c, num + 1);
        }
        return charNum;
    }

    public static void main(String[] args) {
        FindAnagrams findAnagrams = new FindAnagrams();
        List<Integer> res = findAnagrams.findAnagrams("baa", "aa");
        System.out.println(res);
    }
}
