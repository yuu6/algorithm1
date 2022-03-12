package com.yuu6.everyday;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 *  
 *
 * 注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *  
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinWind {

    public String minWindow(String s, String t) {
        int[] countArr = new int[52];
        int[] countTArr = stringToArr(t);

        int l = 0, r = 0;
        int resL = 0, resR = 0;
        boolean find = false;
        while(r < s.length()){
            // 不想等的情况
            while (r - l < t.length() && r < s.length()){
                putCharToArr(s.charAt(r), countArr);
                r++;
            }

            if (r - l == t.length() && arrContain(countArr, countTArr)){
                return s.substring(l, r);
            }

            while (!arrContain(countArr, countTArr) && r < s.length()){
                putCharToArr(s.charAt(r), countArr);
                r++;
            }

            if (r - l >= t.length() && arrContain(countArr, countTArr)){
                while(r - l >= t.length() && arrContain(countArr, countTArr)){
                    if (find && r - l < resR - resL) {
                        resL = l;
                        resR = r;
                        find = true;
                    }
                    if (!find) {
                        resL = l;
                        resR = r;
                        find = true;
                    }
                    removeCharToArr(s.charAt(l), countArr);
                    l++;
                }
            }
        }
        return find ? s.substring(resL, resR) : "";
    }

    private boolean arrContain(int[] countArr, int[] countTArr) {
        int i = 0;
        for (; i < countArr.length && countArr[i] >= countTArr[i]; i++);
        return i - 52 == 0;
    }

    public void putCharToArr(char a, int[] arr){
        if (a >= 'A' && a <= 'Z'){
            arr[26 + a - 'A'] += 1;
        }else{
            arr[a - 'a'] += 1;
        }
    }

    public void removeCharToArr(char a, int[] arr){
        if (a >= 'A' && a <= 'Z'){
            arr[26 + a - 'A'] -= 1;
        }else{
            arr[a - 'a'] -= 1;
        }
    }

    public int[] stringToArr(String str){
        int[] res = new int[52];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z'){
                res[26 + str.charAt(i) - 'A'] += 1;
            }else{
                res[str.charAt(i) - 'a'] += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MinWind minWind = new MinWind();
//        String res = minWind.minWindow("ADOBECODEBANC", "ABC");
//        System.out.println(res);
        String res = minWind.minWindow("a", "aa");
        System.out.println(res);

    }

}
